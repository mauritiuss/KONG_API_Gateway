package com.davidemauri.servicefaulttolerance;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FaulttoleranceController {

    @GetMapping("/faulttolerance")
    @CircuitBreaker(
            name = "faultToleranceCircuitBreaker",
            fallbackMethod = "fallbackResponse"
    )
    public Map<String, Object> faultTolerance( @RequestParam(defaultValue = "false") boolean fail) {
        if (fail) throw new RuntimeException("Errore simulato nel servizio principale");

        return Map.of(
                "Service", "fault-tolerance-service",
                "status", "ok",
                "message", "Risposta normale dal servizio principale"
        );
    }

    public Map<String, Object> fallbackResponse(boolean fail, Throwable throwable){
        return Map.of(
                "Service", "fault-tolerance-service",
                "status", "FALLBACK",
                "message", "Servizio principale NON disponibile. Risposta alternativa dal fallback",
                "error", throwable.getMessage()
        );
    }


}
