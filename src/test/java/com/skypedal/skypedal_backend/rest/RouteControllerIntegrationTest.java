package com.skypedal.skypedal_backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.utils.AuthenticationRequest;
import com.skypedal.skypedal_backend.utils.AuthenticationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.skypedal.skypedal_backend.test.Constants;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:/test/test-schema.sql", "classpath:test/test-data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class RouteControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    private String token1;
    private String token2;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    void login() throws Exception {
        String response = this.mvc.perform(
                MockMvcRequestBuilders
                        .post("/authenticate")
                        .content("{\"login\":\"will@sky.uk\",\"password\":\"password\"}")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse().getContentAsString();

        AuthenticationResponse authenticationResponse = this.mapper.readValue(response, AuthenticationResponse.class);
        this.token1 = authenticationResponse.getAccessToken();

        String response2 = this.mvc.perform(
                MockMvcRequestBuilders
                        .post("/authenticate")
                        .content("{\"login\":\"Samel@sky.com\",\"password\":\"password\"}")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse().getContentAsString();

        AuthenticationResponse authenticationResponse2 = this.mapper.readValue(response2, AuthenticationResponse.class);
        this.token2 = authenticationResponse2.getAccessToken();
    }

    @Test
    void testCreate() throws Exception {
        System.out.println("!!!" + SecurityContextHolder.getContext().getAuthentication());
        NewRouteDTO newRoute = new NewRouteDTO(1,2);
        String newRouteAsJSON = this.mapper.writeValueAsString(newRoute);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/routes")
                .content(newRouteAsJSON)
                .header("Authorization","Bearer "+this.token1)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        RouteDTO createdRoute = new RouteDTO(3, Constants.ROUTE_GEOJSON, 30084, 5911);
        String createdRouteAsJSON = this.mapper.writeValueAsString(createdRoute);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRouteAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testGet() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/routes?userId=1")
                .header("Authorization","Bearer "+this.token1)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<RouteDTO> routes = List.of(new RouteDTO(1, null, 3400, 1200));

        String createdRouteAsJSON = this.mapper.writeValueAsString(routes);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRouteAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

    }

    @Test
    void testGetOtherUser() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/routes")
                .header("Authorization","Bearer "+this.token2)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<RouteDTO> routes = List.of(new RouteDTO(2, null, 3500, 1300));

        String createdRouteAsJSON = this.mapper.writeValueAsString(routes);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRouteAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }


    @Test
    void testGetById() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/routes/1?userId=1")
                .header("Authorization","Bearer "+this.token1)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        RouteDTO route = new RouteDTO(1, null, 3400, 1200);

        String createdRouteAsJSON = this.mapper.writeValueAsString(route);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRouteAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testGetByEnds() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/routes/start/1/end/2?userId=1")
                .header("Authorization","Bearer "+this.token1)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        RouteDTO route = new RouteDTO(1, null, 3400, 1200);

        String createdRouteAsJSON = this.mapper.writeValueAsString(route);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRouteAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
}
