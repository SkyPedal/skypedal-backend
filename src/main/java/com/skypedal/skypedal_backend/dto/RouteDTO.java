package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.Route;

public class RouteDTO {
    private Integer id;
    private String geoJson;
    private Integer distanceM;
    private Integer durationS;

    public RouteDTO() {

    }

    public RouteDTO(Integer id, String geoJson, Integer distanceM, Integer durationS) {
        this.id = id;
        this.geoJson = geoJson;
        this.distanceM = distanceM;
        this.durationS = durationS;
    }

    public RouteDTO(Route route) {
        this.id = route.getId();
        this.geoJson = route.getGeoJson();
        this.distanceM = route.getDistanceM();
        this.durationS = route.getDurationS();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGeoJson() {
        return geoJson;
    }

    public void setGeoJson(String geoJson) {
        this.geoJson = geoJson;
    }

    public Integer getDistanceM() {
        return distanceM;
    }

    public void setDistanceM(Integer distanceM) {
        this.distanceM = distanceM;
    }

    public Integer getDurationS() {
        return durationS;
    }

    public void setDurationS(Integer durationS) {
        this.durationS = durationS;
    }
}
