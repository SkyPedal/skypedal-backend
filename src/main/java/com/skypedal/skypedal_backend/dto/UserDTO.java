package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.User;

public class UserDTO {
    private Integer id;
    private String name;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
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
