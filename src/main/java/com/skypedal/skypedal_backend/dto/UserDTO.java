package com.skypedal.skypedal_backend.dto;
import com.skypedal.skypedal_backend.entities.User;

import java.util.List;


public class UserDTO {
    private String firstName;
    private String lastName;
    private Long id;
    private String email;
    private int rewardPoints;
    private String officeLocation;
    private String password;

    private List<UsersRewardsDTO> usersRewards;

    public UserDTO() {
        super();
    }

    public UserDTO (Long id, String firstName, String lastName, String email, String password, Integer rewardPoints, String officeLocation, List<UsersRewardsDTO> usersRewards){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rewardPoints = rewardPoints;
        this.officeLocation = officeLocation;

        if (usersRewards != null) {
            this.usersRewards = usersRewards;
        }
    }

    public UserDTO (User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.rewardPoints = user.getRewardPoints();
        this.officeLocation = user.getOfficeLocation();

        if (user.getUsersRewards() != null) {
            this.usersRewards = user.getUsersRewards().stream().map(UsersRewardsDTO::new).toList();
        }
    }

    public UserDTO(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getPassword() {
        return password;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public List<UsersRewardsDTO> getUsersRewards() {
        return usersRewards;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public void setUsersRewards(List<UsersRewardsDTO> usersRewards) {
        this.usersRewards = usersRewards;
    }
}
