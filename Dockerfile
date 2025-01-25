# Usa una imagen base de OpenJDK 20 (alpine para ser más ligera)
FROM azul/zulu-openjdk-alpine:20-jre-latest

WORKDIR /app

# Crea el directorio de logs
RUN mkdir ./logs

# Copia el archivo JAR generado por Gradle (con un nombre más específico)
COPY ./build/libs/apigateway-service-0.0.1-SNAPSHOT.jar ./apigateway-service-0.0.1-SNAPSHOT.jar

# Configuración de healthcheck
HEALTHCHECK --interval=5m --timeout=3s \
  CMD curl -f http://localhost/ || exit 1

# Limpia las listas de apt, si es que hay algo en la imagen base que lo requiera
RUN rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Establece las variables de entorno
ENV JASYPT_ENCRYPTOR=xxxxxx
ENV DRIVE=xxxxxx
ENV URL_DB=xxxxxx
ENV USERNAME_BD=xxxxxx
ENV PORT=8081
ENV PDB=xxxxxx

# Expone el puerto
EXPOSE $PORT

# Ejecuta el JAR con nombre fijo
CMD ["java", "-jar", "apigateway-service-0.0.1-SNAPSHOT.jar"]
