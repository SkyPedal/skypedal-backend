package com.skypedal.skypedal_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapsRouteRequest {
    public MapsRouteRequest(LocationDTO start, LocationDTO end) {
        this.origin = new GMLocationWrapper(start.getLat(), start.getLng());
        this.destination = new GMLocationWrapper(end.getLat(), end.getLng());
        this.travelMode = "BICYCLE";
        this.computeAlternativeRoutes = false;
        this.routeModifiers = new GMRouteModifiers();
        this.routeModifiers.setAvoidFerries(false);
        this.routeModifiers.setAvoidHighways(false);
        this.routeModifiers.setAvoidFerries(false);
        this.languageCode = "en-US";
        this.units = "IMPERIAL";
    }

    @JsonProperty("origin")
    private GMLocationWrapper origin;

    @JsonProperty("destination")
    private GMLocationWrapper destination;

    @JsonProperty("travelMode")
    private String travelMode;

    @JsonProperty("computeAlternativeRoutes")
    private boolean computeAlternativeRoutes;

    @JsonProperty("routeModifiers")
    private GMRouteModifiers routeModifiers;

    @JsonProperty("languageCode")
    private String languageCode;

    @JsonProperty("units")
    private String units;

    // Getters and setters

    public GMLocationWrapper getOrigin() {
        return origin;
    }

    public void setOrigin(GMLocationWrapper origin) {
        this.origin = origin;
    }

    public GMLocationWrapper getDestination() {
        return destination;
    }

    public void setDestination(GMLocationWrapper destination) {
        this.destination = destination;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public boolean isComputeAlternativeRoutes() {
        return computeAlternativeRoutes;
    }

    public void setComputeAlternativeRoutes(boolean computeAlternativeRoutes) {
        this.computeAlternativeRoutes = computeAlternativeRoutes;
    }

    public GMRouteModifiers getRouteModifiers() {
        return routeModifiers;
    }

    public void setRouteModifiers(GMRouteModifiers routeModifiers) {
        this.routeModifiers = routeModifiers;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    // Nested classes

    private static class GMLocationWrapper {
        @JsonProperty("location")
        private GMLocation location;

        public GMLocationWrapper(double lat, double lng) {
            GMLatLng latLng = new GMLatLng();
            latLng.setLatitude(lat);
            latLng.setLongitude(lng);
            this.location = new GMLocation();
            this.location.setLatLng(latLng);
        }

        // Getters and setters

        public GMLocation getLocation() {
            return location;
        }

        public void setLocation(GMLocation location) {
            this.location = location;
        }
    }

    private static class GMLocation {
        @JsonProperty("latLng")
        private GMLatLng latLng;

        // Getters and setters

        public GMLatLng getLatLng() {
            return latLng;
        }

        public void setLatLng(GMLatLng latLng) {
            this.latLng = latLng;
        }
    }

    private static class GMLatLng {
        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("longitude")
        private double longitude;

        // Getters and setters

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    private static class GMRouteModifiers {
        @JsonProperty("avoidTolls")
        private boolean avoidTolls;

        @JsonProperty("avoidHighways")
        private boolean avoidHighways;

        @JsonProperty("avoidFerries")
        private boolean avoidFerries;

        // Getters and setters

        public boolean isAvoidTolls() {
            return avoidTolls;
        }

        public void setAvoidTolls(boolean avoidTolls) {
            this.avoidTolls = avoidTolls;
        }

        public boolean isAvoidHighways() {
            return avoidHighways;
        }

        public void setAvoidHighways(boolean avoidHighways) {
            this.avoidHighways = avoidHighways;
        }

        public boolean isAvoidFerries() {
            return avoidFerries;
        }

        public void setAvoidFerries(boolean avoidFerries) {
            this.avoidFerries = avoidFerries;
        }
    }

    private static void main(String[] args) throws JsonProcessingException {
        MapsRouteRequest mrr = new MapsRouteRequest(new LocationDTO(null, "blah",12.1,14.1), new LocationDTO(null, "bleh", 15.1,
                16.1));
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(mrr));
    }
}
