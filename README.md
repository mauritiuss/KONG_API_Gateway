# Microservices API Gateway — Kong, Spring Boot & Docker

A containerized microservices application demonstrating reliability, security and traffic management patterns in distributed systems.

Built as an individual university project using **Java 17, Spring Boot, Kong API Gateway, Nginx and Docker Compose**.

## Architecture

The application uses Nginx as its entry point, distributing incoming requests between two Kong API Gateway instances.

Kong routes requests to four independent Spring Boot microservices, each demonstrating a different non-functional property.

**Request flow:**

Client → Nginx → Kong Gateway (2 instances) → Spring Boot Microservices

## Key Features

- **Load Balancing:** Distributes requests across multiple service replicas, using Kong upstreams and health checks.
- **Fault Tolerance:** Implements circuit breaker and fallback mechanisms with Resilience4j.
- **High Availability:** Uses two Kong instances behind Nginx to reduce gateway-level single points of failure.
- **JWT Authentication:** Protects API endpoints through Kong's JWT plugin.
- **Rate Limiting:** Restricts request frequency through gateway-level policies.
- **Containerization:** Runs the application components using Docker and Docker Compose.

## Technology Stack

Java 17 · Spring Boot · Maven · Kong API Gateway · Nginx · Docker · Docker Compose · JWT · Resilience4j

## Getting Started

### Requirements

- Docker
- Docker Compose

### Start the application

```bash
docker compose up --build
```

The API Gateway is available at:

`http://localhost:8000`

### Example Requests

```bash
curl http://localhost:8000/loadbalancing
curl http://localhost:8000/ratelimiting
curl http://localhost:8000/faulttolerance
```

### Stop the application

```bash
docker compose down
```

## Technical Documentation

See [DOCUMENTAZIONE.md](DOCUMENTAZIONE.md) for the architecture, microservice responsibilities and implementation details.

## Author

Davide Mauri — University of Milan
