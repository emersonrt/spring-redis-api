# Spring Boot REST API with PostgreSQL and Redis

This project is a demonstration of my skills in building a Spring Boot REST API that uses PostgreSQL for data storage and Redis for caching. The API provides endpoints to retrieve information about "imoveis" (real estate properties) and is documented using Swagger (OpenAPI 3.0.1).

## Features

- REST API with endpoints to find all "imoveis" and find an "imovel" by its ID.
- PostgreSQL for persistent data storage.
- Redis for caching with a TTL of 10 seconds.
- Integration tests to ensure the functionality of the API.
- Docker and Docker Compose setup for easy deployment.
- Swagger documentation for the API.

## Requirements

- Docker
- Docker Compose

## Getting Started

### Running the Application

To start the application along with its dependencies (PostgreSQL and Redis), run:

```sh
docker-compose up
```

To stop the application, run:
```sh
docker-compose down
```

### API Endpoints

The API is accessible at `http://localhost:8080/api/v1`. It has the following endpoints:

- `GET /imoveis`: Retrieve a list of all "imoveis".
- `GET /imoveis/{imovelId}`: Retrieve a specific "imovel" by its ID.

### Swagger Documentation

The API documentation is available at `http://localhost:8080/api/v1/swagger-ui.html`.

### Running Tests

To run the integration tests, use the following command:

```sh
./gradlew test
```
