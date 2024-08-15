package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.UsersRewards;

import java.time.LocalDateTime;
import java.util.Date;

public class UsersRewardsDTO {

    private Integer id;

    private LocalDateTime dateRedeemed;
    private LocalDateTime dateExpiry;
    private boolean hasUsed;

    private Integer rewardId;
    private Long userId;
    private String rewardName;

    public UsersRewardsDTO() {
        super();
    }

    public UsersRewardsDTO(Integer id, LocalDateTime dateRedeemed, LocalDateTime dateExpiry, boolean hasUsed, Integer rewardId, Long userId) {
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
        if (usersRewards.getUser() != null) this.userId = usersRewards.getUser().getId();
        if (usersRewards.getReward() != null) this.rewardName = usersRewards.getReward().getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateRedeemed() {
        return dateRedeemed;
    }

    public void setDateRedeemed(LocalDateTime dateRedeemed) {
        this.dateRedeemed = dateRedeemed;
    }

    public LocalDateTime getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(LocalDateTime dateExpiry) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }
}
