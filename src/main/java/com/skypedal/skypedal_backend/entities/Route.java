package com.skypedal.skypedal_backend.entities;

import com.skypedal.skypedal_backend.dto.RouteDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Location start;
    @ManyToOne
    private Location end;
    @ManyToOne
    private User user;

    @Column(columnDefinition = "TEXT")
    private String geoJson;
    @Column(name = "distance_m")
    private Integer distanceM;
    @Column(name = "duration_s")
    private Integer durationS;

    public Route() {
    }

    public Route(Location start, Location end, User user, String geoJson, Integer distanceM, Integer durationS) {
        this.start = start;
        this.end = end;
        this.user = user;
        this.geoJson = geoJson;
        this.distanceM = distanceM;
        this.durationS = durationS;
    }

    public Route(RouteDTO routeDTO, Location start, Location end, User user) {
        this.start = start;
        this.end = end;
        this.user = user;
        this.geoJson = routeDTO.getGeoJson();
        this.distanceM = routeDTO.getDistanceM();
        this.durationS = routeDTO.getDurationS();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
