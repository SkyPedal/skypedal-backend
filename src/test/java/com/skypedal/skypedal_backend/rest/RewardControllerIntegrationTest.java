package com.skypedal.skypedal_backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypedal.skypedal_backend.dto.RewardDTO;
import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // creates the mockmvc object
@Sql(scripts = {"classpath:test/test-schema.sql", "classpath:test/test-data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class RewardControllerIntegrationTest {
    @Autowired // requests the object from spring
    private MockMvc mvc; // sends the mock requests

    @Autowired
    private ObjectMapper mapper;


    /* test create method */
    @Test
    void testCreate() throws Exception {
        RewardDTO newReward = new RewardDTO(null, "Free Tea", null, null, 15, null, true, null);
        String newRewardAsJSON = this.mapper.writeValueAsString(newReward);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/rewards/create")
                .content(newRewardAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        RewardDTO createdReward = new RewardDTO(6, "Free Tea", null, null, 15, null, true, null);
        String createdDriverAsJSON = this.mapper.writeValueAsString(createdReward);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdDriverAsJSON);


        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); // performs the request and checks the response
    }

    /* test get methods */
    @Test
    void testGetById() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/rewards/4");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<UsersRewardsDTO> usersRewardsDTOList = List.of(
                new UsersRewardsDTO(4, "Thursday", "2024/09/06 T 12:00", false, 4, 1)
        );
        RewardDTO found = new RewardDTO(4, "Free Car", "1 delicious free car of your choosing!", 100000, 1, "34552345-23452345-23452345.jpg", true, usersRewardsDTOList);
        String foundAsJSON = this.mapper.writeValueAsString(found);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJSON);


        this.mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
    }
    @Test
    void testGetByIdNotFound() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/rewards/40");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNotFound();

        this.mvc.perform(req).andExpect(checkStatus);
    }
    @Test
    void testGetAllRewards() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/rewards/getAll");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        this.mvc.perform(req).andExpect(jsonPath("$", hasSize(5))).andExpect(checkStatus);
    }
    @Test
    void testGetAvailableRewards() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/rewards/getActive");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        this.mvc.perform(req).andExpect(jsonPath("$", hasSize(3))).andExpect(checkStatus);
    }

    /* test update method */
    @Test
    void testUpdateRewardWithUsersRewardsPresent() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .patch("/rewards/update/3")
                .param("name", "Free Brownie")
                .param("numberAvailable", "5")
                .param("active", "true");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<UsersRewardsDTO> usersRewardsDTOS = List.of(
                new UsersRewardsDTO(3, "Thursday", "2024/09/06 T 12:00", false, 3, 1)
        );
        RewardDTO createdReward = new RewardDTO(3, "Free Brownie", "1 delicious free cookie of your choosing!", 500, 5, "34552345-23452345-23452345.jpg", true, usersRewardsDTOS);
        String createdRewardAsJSON = this.mapper.writeValueAsString(createdReward);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRewardAsJSON);


        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
    @Test
    void testUpdateRewardWithNoUsersRewards() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .patch("/rewards/update/5")
                .param("name", "Free Crown")
                .param("description", "1 delicious free crown of your choosing!")
                .param("active", "true");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        RewardDTO createdReward = new RewardDTO(5, "Free Crown", "1 delicious free crown of your choosing!", 5000000, 1, "34552345-23452345-23452345.jpg", true, new ArrayList<>());
        String createdRewardAsJSON = this.mapper.writeValueAsString(createdReward);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdRewardAsJSON);


        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
}
