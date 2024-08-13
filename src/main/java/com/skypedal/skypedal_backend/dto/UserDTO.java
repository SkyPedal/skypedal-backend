package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.User;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;

    private List<UsersRewardsDTO> usersRewards;

    public UserDTO() {
        super();
    }

    public UserDTO(Long id, String name, List<UsersRewardsDTO> usersRewards) {
        this.id = id;
        this.name = name;
        this.usersRewards = usersRewards;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();

        if (user.getUsersRewards() != null) {
            this.usersRewards = user.getUsersRewards().stream().map(UsersRewardsDTO::new).toList();
        }
    }

    public UserDTO(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public List<UsersRewardsDTO> getUsersRewards() {
        return usersRewards;
    }

    public void setUsersRewards(List<UsersRewardsDTO> usersRewards) {
        this.usersRewards = usersRewards;
    }
}
