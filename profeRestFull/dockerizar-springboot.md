# Dockerización de un Proyecto Spring Boot

Este documento resume los pasos necesarios para dockerizar un proyecto desarrollado con Spring Boot.

---

## 1. Dockerfile

Coloca este `Dockerfile` en la raíz del proyecto:

```Dockerfile
# Etapa de construcción
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 2. .dockerignore (opcional pero recomendado)

Crea un archivo `.dockerignore` para evitar copiar archivos innecesarios en la imagen Docker:

```
target/
.git
.idea
*.iml
```

---

## 3. Construir la imagen Docker

Ejecuta el siguiente comando desde la raíz del proyecto (donde está el `Dockerfile`):

```bash
docker build -t mi-springboot-app .
```

---

## 4. Ejecutar el contenedor

Una vez construida la imagen, puedes ejecutarla así:

```bash
docker run -p 8080:8080 mi-springboot-app
```

Tu aplicación estará disponible en `http://localhost:8080`.

---

## 📝 Notas adicionales

- Si ya tienes el `.jar` generado en `target/`, puedes usar un Dockerfile más simple.
- Asegúrate de que `mvn package` se ejecute correctamente antes de construir la imagen.
- Puedes usar Docker Compose si necesitas levantar otros servicios como bases de datos.

---

¡Y eso es todo! Tu aplicación Spring Boot ahora corre dentro de un contenedor Docker listo para producción o pruebas.
