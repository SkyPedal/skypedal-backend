package com.skypedal.skypedal_backend.entities;

import com.skypedal.skypedal_backend.dto.UserDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    private String firstName;
    private String lastName;
    private Integer rewardPoints;
    private String officeLocation;

    @Column(nullable = false, name = "password_hash")
    private String passwordHash;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<UsersRewards> usersRewards;

    public User() {
        super();
    }

    public User(Long id, String email, String password, String firstName, String lastName, Integer rewardPoints, String officeLocation) {
        this.email = email;
        this.id = id;
        this.firstName = firstName;
        this.rewardPoints = rewardPoints;
        this.officeLocation = officeLocation;
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.rewardPoints = userDTO.getRewardPoints();
        this.officeLocation = userDTO.getOfficeLocation();
    }
    // Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
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

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }


    public String getOfficeLocation() {
        return officeLocation;
    }

    public List<UsersRewards> getUsersRewards() {
        return usersRewards;
    }

    public void setUsersRewards(List<UsersRewards> usersRewards) {
        this.usersRewards = usersRewards;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getPassword_Hash() {
        return passwordHash;
    }

    public void setPassword_Hash(String password) {
        this.passwordHash = password;
    }
}
