# API Client Server Architecture

A small Spring Boot project where I learned how one service can communicate with another using REST APIs.

## Structure

- `user-service` - handles users and the database
- `email-service` - communicates with the user service

## Flow

email-service → REST API → user-service → H2 database

## User Service APIs

- `POST /api/v1/users` - create user
- `GET /api/v1/users` - get all users
- `GET /api/v1/users/{id}` - get user
- `PUT /api/v1/users/{id}` - update user
- `DELETE /api/v1/users/{id}` - delete user

## Tech Used

- Java
- Spring Boot
- Spring Data JPA
- H2
- REST Client
- Postman
- Swagger / OpenAPI

## Swagger

<img width="1910" height="1170" alt="image" src="https://github.com/user-attachments/assets/eafaa4c7-ed85-4c94-8e93-3d15911b7d94" />


## Example

<img width="1910" height="2019" alt="screencapture-localhost-8080-swagger-ui-index-html-2026-09-27-23_45_23" src="https://github.com/user-attachments/assets/3931ae19-2e85-4c6f-8f98-0339c37dae41" />
