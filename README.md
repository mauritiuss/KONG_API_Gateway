# KONG_API_Gateway

## Descrizione
Progetto dedicato a mostrare il funzionamento di un'architettura a microservizi basata su API Gateway.
Il progetto utilizza Spring Boot, Docker e Kong Gateway.

L'applicazione è composta da tre microservizi indipendenti. A ogni microservizio corrisponde una o più caratteristiche tipiche dei sistemi distribuiti:
1. Service 1 → Load balancing
2. Service 2 → Security
3. Service 3 → Rate Limiting
4. Service 4 → Fault tolerance

Tutti i servizi vengono eseguiti tramite Docker Compose e sono accesibili attraverso Kong API Gateway (unico punto di ingresso del sistema).

## Microservizi

### Service 1 - Load Balancing
Questo servizio viene eseguito tramite più istanze identiche.
L'obiettivo è dimostrare il funzionamento del load balancing, mostrare come Kong distribuisce le richieste tra più repliche e verificare che richieste consecutive possano essere gestite da istanze diverse.

La presenza di più istanze consente inoltre di mostrare una forma di fault tolerance infrastrutturale: se una replica dovesse smettere di funzionare, le richieste vengono inoltrate alle istanze ancora attive, garantendo continuità.

### Service 2 - Security
Servizio dedicato alla protezione delle API.
L'obiettivo è proteggere gli endpoint tramite API Key e dimostrare che l'accesso è consentito solo ai client autorizzati.

Le richieste senza credenziali vengono bloccate direttamente dal gateway senza che queste debbano raggiungere il servizio interno.

### Service 3 - Rate limiting
Questo servizio è dedicato al controllo del traffico.
L'obiettivo è quello di limitare il numero massimo di richieste effettuabili in un certo intervallo di tempo così da proteggere il sistema da:
- Utilizzi abusivi delle API
- Picchi di traffico
- Attacchi DoS

### Service 4 - Fault tolerance
Servizio dedicato alla resilienza del sistema.
L'obiettivo è dimostrare come il sistema continua a fornire una risposta anche in caso di errori o malfunzionamenti nei microservizi.

Vengono utilizzate pattern di Circuit Breaker e Fallback:
- *Circuit Breaker* → Evita di continuare a eseguire operazioni verso componenti che stanno fallendo di continuo. Quando viene superata una certa soglia, il Circuit Breaker viene aperto e le richieste non vengono più inoltrate.
- *Fallback* → Quando il servizio non è disponibile, il sistema restituisce una risposta alternativa.

## Tecnologie utilizzate
- Java 17
- Spring Boot
- Maven
- Docker
- Docker compose
- Kong API Gateway
- Resilience4j

## Obiettivo didattico
Comprendere e dimostrare il ruolo dell'API Gateway e delle principali tecniche utilizzate nei sistemi distribuiti moderni.
