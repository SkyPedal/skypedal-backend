package com.skypedal.skypedal_backend.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypedal.skypedal_backend.dto.NewRouteDTO;
import com.skypedal.skypedal_backend.dto.RouteDTO;
import com.skypedal.skypedal_backend.dto.UserDTO;
import com.skypedal.skypedal_backend.utils.AuthenticationRequest;
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

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:test/test-schema.sql", "classpath:test/test-data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class LoginIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testRegister() throws Exception {
        UserDTO newUser = new UserDTO(6L, "John", "Johnson", "John@email.com", "test123", 25, "Leeds", null);
        String json = mapper.writeValueAsString(newUser);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/users/register")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(json);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testAuthenticate() throws Exception {
        UserDTO newUser = new UserDTO(6L, "Bob", "Bobson", "bob@email.com", "password123", 30, "Livingston", null);
        String json = mapper.writeValueAsString(newUser);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/users/register")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(json);

        this.mvc.perform(req);

        AuthenticationRequest authRequest = new AuthenticationRequest("bob@email.com", "password123");
        AuthenticationRequest invalidAuthRequest = new AuthenticationRequest("bob@email.com", "wrongSomething");

        String json1 = mapper.writeValueAsString(authRequest);
        String json2 = mapper.writeValueAsString(invalidAuthRequest);

        RequestBuilder authReq1 = MockMvcRequestBuilders
                .post("/authenticate")
                .content(json1)
                .contentType(MediaType.APPLICATION_JSON);

        RequestBuilder authReq2 = MockMvcRequestBuilders
                .post("/authenticate")
                .content(json2)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus1 = MockMvcResultMatchers.status().isOk();
        ResultMatcher checkStatus2 = MockMvcResultMatchers.status().isUnauthorized();

        this.mvc.perform(authReq1).andExpect(checkStatus1);
        this.mvc.perform(authReq2).andExpect(checkStatus2);
    }
}
