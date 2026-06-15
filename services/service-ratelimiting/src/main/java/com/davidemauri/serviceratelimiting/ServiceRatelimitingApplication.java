package com.davidemauri.serviceratelimiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceRatelimitingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRatelimitingApplication.class, args);
    }

    @GetMapping("/ratelimiting")
    public String getHello() {
        return "Hello from Rate Limiting service";
    }
}
