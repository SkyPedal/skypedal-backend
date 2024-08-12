package com.skypedal.skypedal_backend.entities;

import com.skypedal.skypedal_backend.dto.UserDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<UsersRewards> usersRewards;

    public User() {

    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
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

    public List<UsersRewards> getUsersRewards() {
        return usersRewards;
    }

    public void setUsersRewards(List<UsersRewards> usersRewards) {
        this.usersRewards = usersRewards;
    }
}
