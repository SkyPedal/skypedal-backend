package com.skypedal.skypedal_backend.dto;

public class NewUsersRewardsDTO {

    private Integer rewardId;
    private Long userId;

    public NewUsersRewardsDTO() {
        super();
    }

    public NewUsersRewardsDTO(Integer rewardId, Long userId) {
        this.rewardId = rewardId;
        this.userId = userId;
    }

    public Integer getRewardId() {
        return rewardId;
    }

    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
