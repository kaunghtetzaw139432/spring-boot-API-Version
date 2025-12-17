# Spring Boot API Versioning Example

This is a **Spring Boot** project demonstrating **API versioning** using **DTOs, records, and in-memory repository**.  
It supports **multiple API versions** (v1, v2) and shows how to separate response DTOs for backward compatibility.

---

## Features

- Spring Boot REST API
- In-memory `User` repository for demo purposes
- API Versioning via **path segment** (`/api/v1/users`) or optional header (`X-API-Version`)
- `UserDTOv1` and `UserDTOv2` with version-specific fields
- Mapper (`UserMapper`) to convert domain objects to versioned DTOs
- Full example of splitting full name into first name and last name (v2)

---

## Technologies

- Java 17
- Spring Boot 3.x
- Maven
- Lombok (optional)
- GitHub for version control

---
GET http://localhost:8080/api/v1/users   # v1
GET http://localhost:8080/api/v2/users   # v2

## Project Structure

