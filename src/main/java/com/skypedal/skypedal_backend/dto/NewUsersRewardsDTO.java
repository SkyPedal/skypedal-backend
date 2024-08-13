package com.skypedal.skypedal_backend.dto;

public class NewUsersRewardsDTO {

    private Integer rewardId;
    private Integer userId;

    public NewUsersRewardsDTO() {
        super();
    }

    public NewUsersRewardsDTO(Integer rewardId, Integer userId) {
        this.rewardId = rewardId;
        this.userId = userId;
    }

    public Integer getRewardId() {
        return rewardId;
    }

    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
