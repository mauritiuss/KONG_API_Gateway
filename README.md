# KONG_API_Gateway

Progetto universitario dedicato allo sviluppo di un'architettura a microservizi basata su Spring Boot, Kong API Gateway, Nginx e Docker.

L'obiettivo è dimostrare alcune delle principali proprietà non funzionali dei sistemi distribuiti, tra cui:
- Load balancing
- Fault tolerance
- High availability
- JWT Authentication
- Rate limiting

La descrizione completa del progetto è disponibile nel file *DOCUMENTAZIONE.md*.

## Requisiti
Per eseguire il progetto è necessario:
- Docker
- Docker compose
- Java 17
- Maven

## Esecuzione progetto

### Avvio del progetto

1. Clonare la repository
2. Costruite le immagini Docker
   docker compose build
3. Avviare l'applicazione
   docker compose up
   oppure
   docker compose up --build

### Accesso ai servizi
Una volta avviato il progetto, tutte le richieste devono essere inviate all'API Gateway tramite:
```bash
http://localhost:8000
```

Esempio:
```bash
curl http://localhost:8000/loadbalancing
```
```bash
curl http://localhost:8000/ratelimiting
```
```bash
curl http://localhost:8000/faulttolerance
```

Per il servizio di autenticazione:
```bash
POST /login
```
Successivamente sarà possibile utilizzare il JWT ottenuto per acccedere agli endpoint protetti.

### Arresto del progetto
Per fare fermare tutti i container:
```bash
docker compose down
```

Per eliminare anche volumi e immagini inutilizzate:
```bash
docker compose down -v
```