package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.UsersRewards;

public class UsersRewardsDTO {

    private Integer id;

    private String dateRedeemed;
    private String dateExpiry;
    private boolean hasUsed;

    private Integer rewardId;
    private Integer userId;

    public UsersRewardsDTO() {
        super();
    }

    public UsersRewardsDTO(Integer id, String dateRedeemed, String dateExpiry, boolean hasUsed, Integer rewardId, Integer userId) {
        this.id = id;
        this.dateRedeemed = dateRedeemed;
        this.dateExpiry = dateExpiry;
        this.hasUsed = hasUsed;
        this.rewardId = rewardId;
        this.userId = userId;
    }

    public UsersRewardsDTO(UsersRewards usersRewards) {
        this.id = usersRewards.getId();
        this.dateRedeemed = usersRewards.getDateRedeemed();
        this.dateExpiry = usersRewards.getDateExpiry();
        this.hasUsed = usersRewards.isHasUsed();

        if (usersRewards.getReward() != null) this.rewardId = usersRewards.getReward().getId();
        if (usersRewards.getUser() != null) this.rewardId = usersRewards.getUser().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateRedeemed() {
        return dateRedeemed;
    }

    public void setDateRedeemed(String dateRedeemed) {
        this.dateRedeemed = dateRedeemed;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public boolean isHasUsed() {
        return hasUsed;
    }

    public void setHasUsed(boolean hasUsed) {
        this.hasUsed = hasUsed;
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
