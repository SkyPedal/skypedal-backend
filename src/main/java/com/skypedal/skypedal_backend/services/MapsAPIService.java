package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.*;
import com.skypedal.skypedal_backend.exceptions.MapsAPIException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MapsAPIService {
    private final WebClient placesClient;
    private final WebClient routesClient;

    public MapsAPIService(@Qualifier("mapsPlacesClient") WebClient placesClient,
                          @Qualifier("mapsRoutesClient") WebClient routesClient) {
        this.placesClient = placesClient;
        this.routesClient = routesClient;
    }

    public Mono<List<LocationDTO>> fetchLocations(String queryText) {
        return placesClient
                .post().uri("/places:searchText")
                .header("X-Goog-FieldMask", "places.displayName,places.formattedAddress,places.location")
                .bodyValue(new MapsLocationRequest(queryText))
                .retrieve()
                .onStatus(HttpStatusCode::isError, _ -> Mono.error(MapsAPIException::new))
                .bodyToMono(MapsLocationResponse.class).map(MapsLocationResponse::toLocationDTOs);
    }

    public Mono<RouteDTO> fetchRoute(LocationDTO start, LocationDTO end) {
        return routesClient
                .post().uri("/directions/v2:computeRoutes")
                .header("X-Goog-FieldMask","routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline")
                .bodyValue(new MapsRouteRequest(start, end))
                .retrieve()
                .onStatus(HttpStatusCode::isError, _ -> Mono.error(MapsAPIException::new))
                .bodyToMono(MapsRouteResponse.class).map(MapsRouteResponse::toRouteDTO);
    }
}
