#De la imagen que iniciamos
FROM openjdk:11-jre-slim

#Directorio de trabajo
WORKDIR /app

#Copiamos el .jar en el directorio de trabajo
COPY target/*.jar /app

#Exponemos el puerto 8080
EXPOSE 9090

#Comando que se ejecutará una vez ejecutemos el contendor
CMD ["java","-jar","exchange-rate-0.0.1.jar"]