package com.davidemauri.serviceloadbalancing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceLoadbalancingApplication {

    @Value("${SERVICE_NAME:unknown}")
    private String serviceName;

    public static void main(String[] args) {
        SpringApplication.run(ServiceLoadbalancingApplication.class, args);
    }

    @GetMapping("/loadbalancing")
    public String getHello() {
        return "Hello from "+serviceName;
    }
}
