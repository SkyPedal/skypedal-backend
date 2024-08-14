package com.skypedal.skypedal_backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypedal.skypedal_backend.dto.UserDTO;
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


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
@Sql(scripts = {"classpath:test/users.sql", "classpath:test/data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;


    //tests GET function
    @Test
    void testGetUserById() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/users/6");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        UserDTO expectedUser = new UserDTO(6L, "John", "Johnson", "John@email.com", "test123", 25, "Leeds", null);
        String expectedUserAsJSON = this.mapper.writeValueAsString(expectedUser);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(expectedUserAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    //tests GET ALL function
    @Test
    void testGetAllUsers() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/users/all");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        UserDTO user1 = new UserDTO(6L, "John", "Johnson", "John@email.com", "test123", 25, "Leeds", null);
        UserDTO user2 = new UserDTO(7L, "Bob", "Bobson", "bob@email.com", "password123", 30, "Livingston", null);
        List<UserDTO> expectedUsers = List.of(user1, user2);
        String expectedUsersAsJSON = this.mapper.writeValueAsString(expectedUsers);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(expectedUsersAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    //tests UPDATE user fields
    @Test
    void testUpdateUser() throws Exception {
        UserDTO updatedUser = new UserDTO(6L, "Bob", "Bobson", "bob@email.com", "password123", 30, "Livingston", null);
        String updatedUserAsJSON = this.mapper.writeValueAsString(updatedUser);

        RequestBuilder req = MockMvcRequestBuilders
                .put("/users/6")
                .content(updatedUserAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        UserDTO expectedUser = new UserDTO(6L, "Bob", "Bobson", "bob@email.com", "password123", 30, "Livingston", null);
        String expectedUserAsJSON = this.mapper.writeValueAsString(expectedUser);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(expectedUserAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    //tests DELETE user field
    @Test
    void testDeleteUser() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.delete("/users/1");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNoContent();

        this.mvc.perform(req).andExpect(checkStatus);
    }

    // tests USER NOT FOUND
    @Test
    void testGetUserByIdNotFound() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/users/5");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNotFound();

        this.mvc.perform(req).andExpect(checkStatus);
    }
}
