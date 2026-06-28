# Documentazione KONG_API_Gateway

## Descrizione
Progetto dedicato a mostrare il funzionamento di un'architettura a microservizi basata su API Gateway.
Il progetto utilizza Spring Boot, Kong Gateway, Nginx e Docker.

L'applicazione è composta da quattro microservizi indipendenti. A ogni microservizio corrisponde una o più caratteristiche tipiche dei sistemi distribuiti.

Per aumentare l'affidabilità dell'infrastruttura, il gateway è composto da due istanze di Kong, dietro Nginx, che distribuisce il traffico tra le due istanza e fa si che il gateway NON sia un possibile _single point of failure_.

Tutti i componenti vengono eseguiti all'interno di container Docker, gestiti tramite Docker compose.

## Architettura
Client → Nginx → Kong gateway 1 / Kong gateway 2 → Microservizi

Il client comunica esclusivamente con Nginx (unico punto di ingresso dell'applicazione).

Nginx distribuisce le richieste tra le due istanze di Kong.

Kong si occupa quindi di instradare ogni richiesta verso il microservizio corretto.

## Microservizi

### Service 1 - Load Balancing
Questo servizio viene eseguito tramite più istanze identiche.

Kong utilizza un Upstream con Health Check per distribuire automaticamente le richieste tra le repliche.

Nel caso in cui una replica non sia più disponibile, Kong la esclude continuando a utilizzare quelle funzionanti, garantendo continuità.

### Service 2 - Security
Servizio dedicato alla protezione delle API tramite JSON Web Token (JWT).

Il client effettua l'autenticazione tramite l'endpoint /login, ottenendo un token JWT.

L'endpoint /security è progettato dal plugin JWT di Kong: tutte le richieste prive di un token valido vengono bloccate direttamente dal gateway senza raggiungere il microservizio.

### Service 3 - Rate limiting
Questo servizio dimostra il controllo del numero di richieste effettuabili da un client in un determinato intervallo di tempo.

Il rate limiting protegge il sistema da:
- Utilizzi abusivi
- Picchi di traffico
- Attacchi di tipo Denial of Service (DoS)

La limitazione viene applicata direttamente da Kong tramite il plugin dedicato.

### Service 4 - Fault tolerance
Questo servizio dimostra alcune tecniche di resilienza tipiche dei sistemi distribuiti.

Vengono utilizzati pattern di Circuit Breaker e Fallback:
- *Circuit Breaker* → Evita di continuare a eseguire operazioni verso componenti che stanno fallendo di continuo. Quando viene superata una certa soglia, il Circuit Breaker viene aperto e le richieste non vengono più inoltrate.
- *Fallback* → Quando il servizio non è disponibile, il sistema restituisce una risposta alternativa.

Entrambi i meccanismi sono implementati tramite *Resilience4J*.

## Alta disponibilità del Gateway
Oltre alla resilienza dei microservizi, il progetto dimostra anche l'alta disponibilità dell'API Gateway.

Sono presenti due istanze di Kong configurate in modo identico.

Nginx distribuisce automaticaente le richieste tra le due istanze e, nel caso in cui una di esse venga bloccata, continua a inoltrare il traffico verso quella disponibile.

## Tecnologie utilizzate
- Java 17
- Spring Boot
- Maven
- Docker
- Docker compose
- Kong API Gateway
- Nginx
- JWT
- Resilience4j

## Obiettivo didattico
L'obiettivo è comprendere e dimostrare il funzionamento di un'architettura basata su API Gateway e mostrare alcune delle principali proprietà non funzionali dei sistemi distribuiti.