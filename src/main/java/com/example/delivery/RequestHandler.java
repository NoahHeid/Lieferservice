package com.example.delivery;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;

public class RequestHandler {
    public static ResponseEntity<Double> sendRequest(String url, HttpEntity entity, HttpMethod method){
        return new RestTemplate().exchange(url, method, entity, Double.class);
    }
}
