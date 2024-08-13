package com.skypedal.skypedal_backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypedal.skypedal_backend.dto.LocationDTO;
import com.skypedal.skypedal_backend.test.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:/test/schema-test.sql", "classpath:test/data-test.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class LocationControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        LocationDTO newLocation = new LocationDTO(null, "test", 1.0,2.0);
        String newLocationAsJSON = this.mapper.writeValueAsString(newLocation);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/locations?userId=2")
                .content(newLocationAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        LocationDTO createdLocation = new LocationDTO(3, "test", 1.0, 2.0);
        String createdLocationAsJSON = this.mapper.writeValueAsString(createdLocation);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdLocationAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testGet() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/locations?userId=1")
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<LocationDTO> routes = List.of(new LocationDTO(1, "Home",55.9391172,-3.1866364), new LocationDTO(2,"Work - Watermark",55.8737717,-3.5436674999999997));

        String createdLocationAsJSON = this.mapper.writeValueAsString(routes);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdLocationAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

    }

    @Test
    void testGetOtherUser() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/locations?userId=2")
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<LocationDTO> routes = List.of();

        String createdLocationAsJSON = this.mapper.writeValueAsString(routes);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdLocationAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testGetById() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/locations/1?userId=1")
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        LocationDTO route = new LocationDTO(1, "Home",55.9391172,-3.1866364);

        String createdLocationAsJSON = this.mapper.writeValueAsString(route);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdLocationAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
}
