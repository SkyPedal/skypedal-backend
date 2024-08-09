package com.skypedal.skypedal_backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:/test/schema-test.sql", "classpath:test/data-test.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class RouteControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        NewRouteDTO newRoute = new NewRouteDTO(1,1);
        String newRouteAsJSON = this.mapper.writeValueAsString(newRoute);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/routes?userId=1")
                .content(newRouteAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        RouteDTO createdRoute = new RouteDTO(4,null,1000,2000);
        String createdRouteAsJSON = this.mapper.writeValueAsString(createdRoute);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRouteAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
}
