# Elegimos la LTS de maven y la LTS de Amazon Corretto
FROM maven:3.9.6-amazoncorretto-17 AS build

# Traemos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo pom.xml
COPY pom.xml .

# Descargamos las dependencias del proyecto y las guardamos en la cache usando un único hilo y offline
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline

# Copiamos el resto de los archivos
COPY src ./src

# Compilamos el proyecto
RUN mvn -B -e -T 1C verify

# Creamos la imagen de producción
FROM amazoncorretto:17-alpine AS production

# Definimos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo jar
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto 8080
EXPOSE 8080

# Ejecutamos el archivo jar
CMD ["java", "-jar", "app.jar"]
