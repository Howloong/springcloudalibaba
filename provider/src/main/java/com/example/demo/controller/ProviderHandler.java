package com.example.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderHandler {
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return this.port;
    }

    @GetMapping("/list")
    public String list() {
        return "list";
    }

    @Autowired
    private ProviderService providerService;

    @GetMapping("/test1")
    public String test() {
        this.providerService.test();
        return "test1";
    }

    @GetMapping("/test2")
    public String test2() {
        this.providerService.test();
        return "test2";
    }

}

