package com.skypedal.skypedal_backend.utils;

import io.leonard.PolylineUtils;
import io.leonard.Position;

import java.util.List;
import java.util.stream.Collectors;

public class PolylineToGeoJson {
    public static String decode(String encodedPolyline) {
        List<Position> decodedPoints = PolylineUtils.decode(encodedPolyline, 5);
        
        return toGeoJsonLineString(decodedPoints);
    }

    private static String toGeoJsonLineString(List<Position> coordinates) {
        String coordinatesJson = coordinates.stream()
                .map(c -> "[" + c.getLatitude() + "," + c.getLongitude() + "]")
                .collect(Collectors.joining(","));

        return "{" +
                "  \"type\": \"Feature\"," +
                "  \"geometry\": {" +
                "    \"type\": \"LineString\"," +
                "    \"coordinates\": [" + coordinatesJson + "]" +
                "  }" +
                "}";
    }
}

