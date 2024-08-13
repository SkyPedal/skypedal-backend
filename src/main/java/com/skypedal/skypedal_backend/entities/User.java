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
    private String name;
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, name = "password_hash")
    private String passwordHash;

    @OneToMany(mappedBy = "user")
    private List<UsersRewards> usersRewards;

    public User() {
        super();
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UsersRewards> getUsersRewards() {
        return usersRewards;
    }

    public void setUsersRewards(List<UsersRewards> usersRewards) {
        this.usersRewards = usersRewards;
    }
}
