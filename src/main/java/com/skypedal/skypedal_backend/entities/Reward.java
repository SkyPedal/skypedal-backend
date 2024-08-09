package com.skypedal.skypedal_backend.entities;

import com.skypedal.skypedal_backend.dto.RewardDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rewards")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Integer pointCost;
    private Integer numberAvailable;
    private String imageLink;
    private boolean active;

    @OneToMany(mappedBy = "reward")
    private List<UsersRewards> usersRewards;

    public Reward() {
        super();
    }

    public Reward(Integer id, String name, String description, Integer pointCost, Integer numberAvailable, String imageLink, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pointCost = pointCost;
        this.numberAvailable = numberAvailable;
        this.imageLink = imageLink;
        this.active = active;
    }

    public Reward(RewardDTO rewardDTO) {
        this.id = rewardDTO.getId();
        this.name = rewardDTO.getName();
        this.description = rewardDTO.getDescription();
        this.pointCost = rewardDTO.getPointCost();
        this.numberAvailable = rewardDTO.getNumberAvailable();
        this.imageLink = rewardDTO.getImageLink();
        this.active = rewardDTO.isActive();
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

    public List<UsersRewards> getUsersRewards() {
        return usersRewards;
    }

    public void setUsersRewards(List<UsersRewards> usersRewards) {
        this.usersRewards = usersRewards;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pointCost=" + pointCost +
                ", numberAvailable=" + numberAvailable +
                ", imageLink='" + imageLink + '\'' +
                ", active=" + active +
                ", usersRewards=" + usersRewards +
                '}';
    }
}
