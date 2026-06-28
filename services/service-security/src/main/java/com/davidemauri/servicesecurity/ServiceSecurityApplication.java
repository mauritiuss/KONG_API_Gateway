package com.davidemauri.servicesecurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Map;

@RestController
@SpringBootApplication
public class ServiceSecurityApplication {

    private static final String JWT_ISSUER = "user-demo";
    private static final String JWT_SECRET = "my-jwt-secret";

    public static void main(String[] args) {
        SpringApplication.run(ServiceSecurityApplication.class, args);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request){
        if(!request.email().equals("mario@test.it") || !request.password().equals("password123")){
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Credenziali non valide"
            );
        }

        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

        String token = JWT.create()
                .withIssuer(JWT_ISSUER)
                .withSubject(request.email)
                .withClaim("role", "USER")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .sign(algorithm);

        return Map.of(
                "message", "Login effettuato con successo",
                "token", token
        );
    }

    @GetMapping("/security")
    public Map<String, Object> getSecurityInfo(){
        return Map.of(
                "service", "security-service",
                "message", "Accesso consentito: Richiesta autenticata tramite JWT"
        );
    }

    public record LoginRequest(String email, String password){}

}
