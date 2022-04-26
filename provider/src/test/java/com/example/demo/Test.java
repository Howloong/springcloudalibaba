package com.example.demo;

import org.springframework.web.client.RestTemplate;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 1000; i++) {
            restTemplate.getForObject("http://localhost:8082/index", String.class);
            Thread.sleep(200);

        }
    }
}
