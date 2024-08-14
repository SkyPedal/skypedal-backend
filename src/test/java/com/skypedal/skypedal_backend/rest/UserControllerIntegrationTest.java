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
import java.util.*;

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
        RequestBuilder req = MockMvcRequestBuilders.get("/users/3");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        UserDTO expectedUser = new UserDTO(3L, "John", "Johnson", "John@email.com", null, 25, "Leeds", Collections.emptyList());
        String expectedUserAsJSON = this.mapper.writeValueAsString(expectedUser);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(expectedUserAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    //tests GET ALL function
    @Test
    void testGetAllUsers() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/users/all");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        UserDTO user1 = new UserDTO(1L, "will", "moolman", "will@sky.uk", null, 42, "Livingston", Collections.emptyList());
        UserDTO user2 = new UserDTO(2L, "Sam", "El", "Samel@sky.com", null, 25, "Brentwood", Collections.emptyList());
        UserDTO user3 = new UserDTO(3L, "John", "Johnson", "John@email.com", null, 25, "Leeds", Collections.emptyList());
        List<UserDTO> expectedUsers = List.of(user1, user2, user3);
        String expectedUsersAsJSON = this.mapper.writeValueAsString(expectedUsers);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(expectedUsersAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    //tests UPDATE user fields
    @Test
    void testUpdateUser() throws Exception {
        UserDTO updatedUser = new UserDTO(3L, "Bob", "Bobson", "bob@email.com", null, 30, "Livingston", Collections.emptyList());
        String updatedUserAsJSON = this.mapper.writeValueAsString(updatedUser);

        RequestBuilder req = MockMvcRequestBuilders
                .put("/users/3")
                .content(updatedUserAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        UserDTO expectedUser = new UserDTO(3L, "Bob", "Bobson", "bob@email.com", null, 30, "Livingston", null);
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
