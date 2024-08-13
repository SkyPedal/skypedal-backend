package com.skypedal.skypedal_backend.entities;


import com.skypedal.skypedal_backend.dto.UsersRewardsDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users_rewards")
public class UsersRewards {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    private LocalDateTime dateRedeemed;
    private LocalDateTime dateExpiry;
    private boolean hasUsed;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Reward reward;
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    public UsersRewards() {
        super();
    }

    public UsersRewards(Integer id, LocalDateTime dateRedeemed, LocalDateTime dateExpiry, boolean hasUsed) {
        this.id = id;
        this.dateRedeemed = dateRedeemed;
        this.dateExpiry = dateExpiry;
        this.hasUsed = hasUsed;
    }

    public UsersRewards(UsersRewardsDTO newUserReward) {
        this.id = newUserReward.getId();
        this.dateRedeemed = newUserReward.getDateRedeemed();
        this.dateExpiry = newUserReward.getDateExpiry();
        this.hasUsed = newUserReward.isHasUsed();


        if (newUserReward.getUserId() != null) {
            this.user = new User();
            this.user.setId(newUserReward.getUserId());
        }
        if (newUserReward.getRewardId() != null) {
            this.reward = new Reward();
            this.reward.setId(newUserReward.getRewardId());
        }
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

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UsersRewards{" +
                "id=" + id +
                ", dateRedeemed='" + dateRedeemed + '\'' +
                ", dateExpiry='" + dateExpiry + '\'' +
                ", hasUsed=" + hasUsed +
                ", reward=" + reward +
                ", user=" + user +
                '}';
    }
}
