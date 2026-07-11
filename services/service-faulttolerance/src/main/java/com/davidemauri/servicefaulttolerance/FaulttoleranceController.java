package com.davidemauri.servicefaulttolerance;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
        System.out.println("Metodo principale eseguito. fail = " + fail);

        if (fail) throw new RuntimeException("Errore simulato nel servizio principale");

        return Map.of(
                "status", "ok",
                "message", "Risposta normale dal servizio principale"
        );
    }

    public Map<String, Object> fallbackResponse(boolean fail, Throwable throwable){
        return Map.of(
                "status", "FALLBACK",
                "message", "Servizio principale NON disponibile. Risposta alternativa dal fallback",
                "errorType", throwable.getClass().getSimpleName()
        );
    }


}
