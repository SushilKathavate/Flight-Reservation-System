package com.org.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import org.springframework.stereotype.Service;

@Service
public class MapsService {

    private static final String API_KEY = "your_api_key";

    private GeoApiContext context = new GeoApiContext.Builder().apiKey(API_KEY).build();

    public GeocodingResult[] getGeocoding(String address) throws Exception {
        return GeocodingApi.geocode(context, address).await();
    }
}
