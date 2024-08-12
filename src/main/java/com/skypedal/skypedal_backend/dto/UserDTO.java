package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.User;

import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;

    private List<UsersRewardsDTO> usersRewards;

    public UserDTO() {
        super();
    }

    public UserDTO(Integer id, String name, List<UsersRewardsDTO> usersRewards) {
        this.id = id;
        this.name = name;
        this.usersRewards = usersRewards;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();

        if (user.getUsersRewards() != null) {
            this.usersRewards = user.getUsersRewards().stream().map(UsersRewardsDTO::new).toList();
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
}
