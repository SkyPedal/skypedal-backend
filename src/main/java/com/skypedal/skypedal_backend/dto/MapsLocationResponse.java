package com.skypedal.skypedal_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MapsLocationResponse {

    @JsonProperty("places")
    private List<GMPlace> places;

    private static class GMPlace {
        @JsonProperty("formattedAddress")
        private String address;

        @JsonProperty("location")
        private GMLocation location;

        @JsonProperty("displayName")
        private GMDisplayName displayName;

        private static class GMLocation {
            @JsonProperty("latitude")
            private double latitude;

            @JsonProperty("longitude")
            private double longitude;

            // Getters and Setters
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

        private static class GMDisplayName {
            @JsonProperty("text")
            private String text;

            @JsonProperty("languageCode")
            private String languageCode;

            // Getters and Setters
            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getLanguageCode() {
                return languageCode;
            }

            public void setLanguageCode(String languageCode) {
                this.languageCode = languageCode;
            }
        }

        // Getters and Setters
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public GMLocation getLocation() {
            return location;
        }

        public void setLocation(GMLocation location) {
            this.location = location;
        }

        public GMDisplayName getDisplayName() {
            return displayName;
        }

        public void setDisplayName(GMDisplayName displayName) {
            this.displayName = displayName;
        }
    }

    // Getters and Setters
    public List<GMPlace> getPlaces() {
        return places;
    }

    public List<LocationDTO> toLocationDTOs() {
        return this.places.stream().map(place -> new LocationDTO(
                null, place.getDisplayName().getText(), place.location.getLatitude(), place.location.getLongitude()
        )).toList();
    }

    public void setPlaces(List<GMPlace> places) {
        this.places = places;
    }
}
