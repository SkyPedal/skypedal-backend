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

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // creates the mockmvc object
@Sql(scripts = {"classpath:test/test-schema.sql", "classpath:test/test-data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UsersRewardsControllerIntegrationTest {
    @Autowired // requests the object from spring
    private MockMvc mvc; // sends the mock requests

    @Autowired
    private ObjectMapper mapper;


    /* test create method */
    @Test
    void testCreate() throws Exception {
        UsersRewardsDTO newUR = new UsersRewardsDTO(null, "Thursday", "2024/09/06 T 12:00", false, 1, 1);
        String newRewardAsJSON = this.mapper.writeValueAsString(newUR);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/users_rewards")
                .content(newRewardAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        UsersRewardsDTO createdUR = new UsersRewardsDTO(11, "Thursday", "2024/09/06 T 12:00", false, 1, 1);
        String createdDriverAsJSON = this.mapper.writeValueAsString(createdUR);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdDriverAsJSON);


        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); // performs the request and checks the response
    }

    /* test create method for unavailable rewards */
    @Test
    void testCreateUnavailable() throws Exception {
        UsersRewardsDTO newUR = new UsersRewardsDTO(null, "Thursday", "2024/09/06 T 12:00", false, 5, 1);
        String newRewardAsJSON = this.mapper.writeValueAsString(newUR);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/users_rewards")
                .content(newRewardAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req);

        /* Claiming the same reward twice, even though it is available once */
        UsersRewardsDTO newUR2 = new UsersRewardsDTO(null, "Thursday", "2024/09/06 T 12:00", false, 5, 2);
        String newUserRewardAsJSON = this.mapper.writeValueAsString(newUR2);
        RequestBuilder req2 = MockMvcRequestBuilders
                .post("/users_rewards")
                .content(newUserRewardAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isForbidden();


        this.mvc.perform(req2).andExpect(checkStatus); // performs the request and checks the response
    }

    /* test that available number decreases by 1 */
    @Test
    void testAvailableNumberDecreasesBy1() throws Exception {
        UsersRewardsDTO newUR = new UsersRewardsDTO(null, "Thursday", "2024/09/06 T 12:00", false, 4, 2);
        String newRewardAsJSON = this.mapper.writeValueAsString(newUR);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/users_rewards")
                .content(newRewardAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req);
        RequestBuilder req2 = MockMvcRequestBuilders.get("/rewards/4");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<UsersRewardsDTO> usersRewardsDTOList = List.of(
                new UsersRewardsDTO(4, "Thursday", "2024/09/06 T 12:00", false, 4, 1),
                new UsersRewardsDTO(11, "Thursday", "2024/09/06 T 12:00", false, 4, 2)
        );
        RewardDTO found = new RewardDTO(4, "Free Car", "1 delicious free car of your choosing!", 100000, 0, "34552345-23452345-23452345.jpg", false, usersRewardsDTOList);
        String foundAsJSON = this.mapper.writeValueAsString(found);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJSON);


        this.mvc.perform(req2).andExpect(checkBody).andExpect(checkStatus);
    }

    /* test get methods */
    @Test
    void testGetById() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/users_rewards/4");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        UsersRewardsDTO found = new UsersRewardsDTO(4, "Thursday", "2024/09/06 T 12:00", false, 4, 1);
        String foundAsJSON = this.mapper.writeValueAsString(found);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJSON);


        this.mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
    }
    @Test
    void testGetByIdNotFound() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/users_rewards/40");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNotFound();

        this.mvc.perform(req).andExpect(checkStatus);
    }
    @Test
    void testGetActiveUsersRewards() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/users_rewards/user/2");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        UsersRewardsDTO found = new UsersRewardsDTO(5, "Thursday", "2024/09/06 T 12:00", false, 1, 2);
        List<UsersRewardsDTO> foundList = List.of(found);
        String foundAsJSON = this.mapper.writeValueAsString(foundList);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJSON);


        this.mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
    }
    @Test
    void testGetActiveUsersRewardsSize() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/users_rewards/user/1");
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        this.mvc.perform(req).andExpect(jsonPath("$", hasSize(4))).andExpect(checkStatus);
    }
}
