# KONG_API_Gateway

## Descrizione
Progetto dedicato a mostrare il funzionamento di un'architettura a microservizi basata su API Gateway.
Il progetto utilizza Spring Boot, Docker e Kong Gateway.

L'applicazione è composta da tre microservizi indipendenti. A ogni microservizio corrisponde una o più caratteristiche tipiche dei sistemi distribuiti:
1. Service 1 → Dedicato al load balacing
2. Service 2 → Dedicato alla security
3. Service 3 → Dedicato al rate limiting
4. Service 4 → Dedicato alla fault tolerance

Tutti i servizi vengono eseguiti tramite Docker Compose e sono accesibili attraverso Kong API Gateway (unico punto di ingresso del sistema).

## Microservizi

### Service 1 - Load Balancing
Questo servizio viene eseguito tramite più istanze identiche.
L'obiettivo è dimostrare il funzionamento del load balancing, mostrare come Kong distribuisce le richieste tra più repliche e verificare che richieste consecutive possano essere gestite da istanze diverse.

### Service 2 - Security
Servizio dedicato alla protezione delle API.
L'obiettivo è proteggere gli endpoint tramite API Key e dimostrare che l'accesso è consentito solo ai client autorizzati.

### Service 3 - Rate limiting
Questo servizio è dedicato al controllo del traffico.
L'obiettivo è quello di limitare il numero massimo di richieste effettuabili in un certo intervallo di tempo così da proteggere il sistema da abusi, picchi di traffico e attacchi DoS.

### Service 4 - Fault tolerance
Servizio dedicato alla resilienza del sistema.
L'obiettivo è dimostrare la capacità del sistema nella gestione dei guasti, mostrare come continua a funzionare anche in presenza di errori. Implementare Circuit Breaker e Fallback.

*Circuit Breaker* → Evita di continuare a inviare richieste verso un componente che sta già fallendo
*Fallback* → Quando il servizio principale non è disponibile, il sistema restituisce una risposta alternativa.

## Tecnologie utilizzate
- Java 17
- Spring Boot
- Maven
- Docker
- Docker compose
- Kong API Gateway
- Resilience4j (ipotetico per ora)

## Obiettivo didattico
Comprendere e dimostrare il ruolo dell'API Gateway e delle principali tecniche utilizzate nei sistemi distribuiti moderni.
