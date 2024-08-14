package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.Reward;

import java.util.List;

public class RewardDTO {

    private Integer id;

    private String name;
    private String description;
    private Integer pointCost;
    private Integer numberAvailable;
    private String imageLink;
    private boolean active;

    private List<UsersRewardsDTO> usersRewards;

    public RewardDTO() {
        super();
    }

    public RewardDTO(Integer id, String name, String description, Integer pointCost, Integer numberAvailable, String imageLink, boolean active, List<UsersRewardsDTO> usersRewards) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pointCost = pointCost;
        this.numberAvailable = numberAvailable;
        this.imageLink = imageLink;
        this.active = active;
        this.usersRewards = usersRewards;
    }

    public RewardDTO(Reward reward) {
        this.id = reward.getId();
        this.name = reward.getName();
        this.description = reward.getDescription();
        this.pointCost = reward.getPointCost();
        this.numberAvailable = reward.getNumberAvailable();
        this.imageLink = reward.getImageLink();
        this.active = reward.isActive();

        if (reward.getUsersRewards() != null) {
            this.usersRewards = reward.getUsersRewards().stream().map(UsersRewardsDTO::new).toList();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPointCost() {
        return pointCost;
    }

    public void setPointCost(Integer pointCost) {
        this.pointCost = pointCost;
    }

    public Integer getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(Integer numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<UsersRewardsDTO> getUsersRewards() {
        return usersRewards;
    }

    public void setUsersRewards(List<UsersRewardsDTO> usersRewards) {
        this.usersRewards = usersRewards;
    }
}
