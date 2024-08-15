package com.skypedal.skypedal_backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypedal.skypedal_backend.dto.NewUsersRewardsDTO;
import com.skypedal.skypedal_backend.dto.RewardDTO;
import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
import com.skypedal.skypedal_backend.test.Constants;
import com.skypedal.skypedal_backend.utils.AuthenticationResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
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

    private String token1;
    private String token2;

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


    /* test create method */
    @Test
    void testCreate() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .post("/users_rewards/redeem/1")
                .header("Authorization","Bearer "+this.token1);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        UsersRewardsDTO createdUR = new UsersRewardsDTO(11, LocalDateTime.now(), LocalDateTime.now().plusDays(12), false, 1, 1L);
        LocalDateTime earlier = LocalDateTime.now().minusHours(1);
        LocalDateTime later = LocalDateTime.now().plusHours(1);

        String response = this.mvc.perform(req).andExpect(checkStatus).andReturn().getResponse().getContentAsString(); // performs the request and checks the response
        UsersRewardsDTO dto = this.mapper.readValue(response, UsersRewardsDTO.class);
        Assertions.assertThat(dto).isEqualToIgnoringGivenFields(createdUR, "dateRedeemed", "dateExpiry");

        Assertions.assertThat(dto.getDateRedeemed()).isBetween(earlier, later);
        Assertions.assertThat(dto.getDateExpiry()).isBetween(earlier.plusDays(12), later.plusDays(12));
    }

    /* test create method for unavailable rewards */
    @Test
    void testCreateUnavailable() throws Exception {
        NewUsersRewardsDTO newUR = new NewUsersRewardsDTO( 5, 1L);
        String newRewardAsJSON = this.mapper.writeValueAsString(newUR);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/users_rewards")
                .content(newRewardAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req);

        /* Claiming the same reward twice, even though it is available once */
        NewUsersRewardsDTO newUR2 = new NewUsersRewardsDTO( 5, 2L);
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
//        NewUsersRewardsDTO newUR = new NewUsersRewardsDTO( 4, 2L);
//        String newRewardAsJSON = this.mapper.writeValueAsString(newUR);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/users_rewards/redeem/4")
                .header("Authorization","Bearer "+this.token1);
        this.mvc.perform(req);
        System.out.println(token1);

        RequestBuilder req2 = MockMvcRequestBuilders
                .get("/rewards/4")
                .header("Authorization","Bearer "+this.token1);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        String response = this.mvc.perform(req2).andExpect(checkStatus).andReturn().getResponse().getContentAsString();
        RewardDTO dto = this.mapper.readValue(response, RewardDTO.class);
        Assertions.assertThat(dto.getNumberAvailable()).isEqualTo(0);
    }

    /* test get methods */
    @Test
    void testGetById() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/users_rewards/4")
                .header("Authorization","Bearer "+this.token1);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        UsersRewardsDTO found = new UsersRewardsDTO(4, Constants.DATE_REDEEMED, Constants.DATE_EXPIRY, false, 4, 1L);
        found.setRewardName("Free Car");
        String foundAsJSON = this.mapper.writeValueAsString(found);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJSON);


        this.mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
    }
    @Test
    void testGetByIdNotFound() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/users_rewards/40")
                .header("Authorization","Bearer "+this.token1);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isNotFound();

        this.mvc.perform(req).andExpect(checkStatus);
    }
    @Test
    void testGetActiveUsersRewards() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/users_rewards/user")
                .header("Authorization","Bearer "+this.token2);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        UsersRewardsDTO found = new UsersRewardsDTO(5, Constants.DATE_REDEEMED, Constants.DATE_EXPIRY, false, 1, 2L);
        found.setRewardName("Free Cake");
        List<UsersRewardsDTO> foundList = List.of(found);
        String foundAsJSON = this.mapper.writeValueAsString(foundList);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJSON);


        this.mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
    }
    @Test
    void testGetActiveUsersRewardsSize() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .get("/users_rewards/user")
                .header("Authorization","Bearer "+this.token1);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();

        this.mvc.perform(req).andExpect(jsonPath("$", hasSize(4))).andExpect(checkStatus);
    }

    /* test use method */
    @Test
    void testUseMethod() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders
                .patch("/users_rewards/1")
                .header("Authorization","Bearer "+this.token1);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        this.mvc.perform(req).andExpect(checkStatus);

        RequestBuilder req2 = MockMvcRequestBuilders
                .get("/users_rewards/1")
                .header("Authorization","Bearer "+this.token1);
        ResultMatcher checkStatus2 = MockMvcResultMatchers.status().isOk();
        UsersRewardsDTO found = new UsersRewardsDTO(1, Constants.DATE_REDEEMED, Constants.DATE_EXPIRY, true, 1, 1L);
        found.setRewardName("Free Cake");
        String foundAsJSON = this.mapper.writeValueAsString(found);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJSON);

        this.mvc.perform(req2).andExpect(checkBody).andExpect(checkStatus2);
    }
}
