package com.skypedal.skypedal_backend.dto;

public class NewActivityDTO {
    private String date;
    private String geoJson;
    private Integer duration;
    private Integer distance;

    private int co2_saving;
    private int cost_saving;
    private int points_earned;


    public NewActivityDTO() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGeoJson() {
        return geoJson;
    }

    public void setGeoJson(String geoJson) {
        this.geoJson = geoJson;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public int getCo2_saving() {
        return co2_saving;
    }

    public void setCo2_saving(int co2_saving) {
        this.co2_saving = co2_saving;
    }

    public int getCost_saving() {
        return cost_saving;
    }

    public void setCost_saving(int cost_saving) {
        this.cost_saving = cost_saving;
    }

    public int getPoints_earned() {
        return points_earned;
    }

    public void setPoints_earned(int points_earned) {
        this.points_earned = points_earned;
    }
}

