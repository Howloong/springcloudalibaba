package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class ConsumerHandler {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/instance")
    public List<ServiceInstance> instances() {
        List<ServiceInstance> provider = this.discoveryClient.getInstances("provider");

        return provider;
    }

    @GetMapping("/index")
    public String index() {
        return this.restTemplate.getForObject("http://provider/index", String.class);
    }
}
