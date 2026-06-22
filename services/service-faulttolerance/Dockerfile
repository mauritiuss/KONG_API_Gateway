# Immagine base con Java 17 già installato
FROM eclipse-temurin:17-jdk

# Impostazione di cartella di lavoro dentro il container
# Tutti i comandi successivi verranno eseguite da questa cartella
WORKDIR /app

# Copia il file .jar generato da Maven dentro il container.
# Il file .jar si trova nella cartella target dopo aver eseguito mvn package
COPY target/*.jar app.jar

# Il container userà la porta 8081
EXPOSE 8084

# Comando eseguito quando il container parte
# In pratica avvia il microservizio Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]