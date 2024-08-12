package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.MyUser;

public class UserDTO {
    private Long id;
    private String name;

    public UserDTO(MyUser myUser) {
        this.id = myUser.getId();
        this.name = myUser.getName();
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
}
