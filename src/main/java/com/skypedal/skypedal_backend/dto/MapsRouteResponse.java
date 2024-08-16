package com.skypedal.skypedal_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skypedal.skypedal_backend.exceptions.MapsAPIException;
import com.skypedal.skypedal_backend.utils.PolylineToGeoJson;

import java.util.List;

public class MapsRouteResponse {

    @JsonProperty("routes")
    private List<GMRoute> routes;

    // Getter and setter

    public List<GMRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<GMRoute> routes) {
        this.routes = routes;
    }

    // Nested classes

    private static class GMRoute {

        @JsonProperty("distanceMeters")
        private int distanceMeters;

        @JsonProperty("duration")
        private String duration;

        @JsonProperty("polyline")
        private GMPolyline polyline;

        // Getters and setters

        public int getDistanceMeters() {
            return distanceMeters;
        }

        public void setDistanceMeters(int distanceMeters) {
            this.distanceMeters = distanceMeters;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public GMPolyline getPolyline() {
            return polyline;
        }

        public void setPolyline(GMPolyline polyline) {
            this.polyline = polyline;
        }
    }

    private static class GMPolyline {

        @JsonProperty("encodedPolyline")
        private String encodedPolyline;

        // Getter and setter

        public String getEncodedPolyline() {
            return encodedPolyline;
        }

        public void setEncodedPolyline(String encodedPolyline) {
            this.encodedPolyline = encodedPolyline;
        }
    }

    public RouteDTO toRouteDTO() {
        if (this.getRoutes().isEmpty()) return null;

        Integer distanceM = this.getRoutes().getFirst().getDistanceMeters();
        String duration = this.getRoutes().getFirst().getDuration();
        if (!duration.endsWith("s")) throw new MapsAPIException();
        Integer durationS = Integer.parseInt(duration.substring(0,duration.length()-1));
        String encodedPolyline = this.getRoutes().getFirst().getPolyline().getEncodedPolyline();
        String geoJson = PolylineToGeoJson.decode(encodedPolyline);

        return new RouteDTO(null, geoJson, distanceM, durationS);
    }
}
