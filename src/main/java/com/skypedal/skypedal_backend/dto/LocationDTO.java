package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.Location;
import com.skypedal.skypedal_backend.entities.User;

public class LocationDTO {
    private Integer id;
    private String name;
    private Double lat;
    private Double lng;

    public LocationDTO(String name, Double lat, Double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.lat = location.getLat();
        this.lng = location.getLng();
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

