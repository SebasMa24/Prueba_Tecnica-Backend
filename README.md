
# Backend (Springboot + Docker) - Guia de Ejecución

Este documento explica cómo ejecutar el backend del proyecto usando Docker.
Por facilidad el backend cuenta con un **schema.sql** y **data.sql**(Se uso IA para la generación de estos datos), por lo que para el correcto funcionamiento cada vez que se realiza una ejecución se debe bajar el contenedor y volverlo a subir.

## Variables de entorno

Por defecto ya funciona, pero si se desea modificar las variables de entorno crear un .env con lo siguiente:

```bash
APP_PORT=8080
SPRING_PROFILE=dev
DB_PORT=5432
DB_NAME=prueba_tecnica_SebasMa24
DB_USER=postgres
DB_PASSWORD=postgres
DB_URL=jdbc:postgresql://db:5432/prueba_tecnica_SebasMa24
CORS=http://localhost:5173
```

## Levantar el proyecto

Desde la carpeta raiz del backend ejecutar:

```bash
docker compose down -v
docker compose up --build
```

Si se desea volver a ejecutar el proyecto (para evitar errores de duplicado o no ejecución de schema.sql):

```bash
docker compose down -v
docker compose up --build
```
