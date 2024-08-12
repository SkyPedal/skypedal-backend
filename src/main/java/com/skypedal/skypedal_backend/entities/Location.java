package com.skypedal.skypedal_backend.entities;

import com.skypedal.skypedal_backend.dto.LocationDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    private String name;
    private Double lat;
    private Double lng;

    public Location() {}

    public Location(LocationDTO locationDTO, User user) {
        this.id = locationDTO.getId();
        this.user = user;
        this.name = locationDTO.getName();
        this.lat = locationDTO.getLat();
        this.lng = locationDTO.getLng();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
