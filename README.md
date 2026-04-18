# 🚖 Ridehailing Backend

A monolithic backend service for a ridehailing application, built with **Spring Boot (latest)**, **Java 21**, and **PostgreSQL + PostGIS**.  
This project provides REST APIs for managing users, drivers, rides, and payments, with geospatial support for location-based queries.

---

## 📌 Features
- User & driver registration with JWT authentication
- Ride request, matching, and assignment
- Ride lifecycle management (start, update, end)
- Geospatial queries using **PostGIS** (nearest driver search, distance calculation)
- Payment placeholder APIs
- PostgreSQL persistence with JPA/Hibernate
- DTO mapping with ModelMapper
- Centralized logging & exception handling

---

## 🛠️ Tech Stack
- **Language:** Java 21
- **Framework:** Spring Boot (latest)
- **Database:** PostgreSQL 14+ with PostGIS extension
- **ORM:** Hibernate / JPA
- **Build Tool:** Maven
- **Authentication:** Spring Security + JWT
- **Testing:** JUnit & Mockito
- **Containerization:** Docker (optional)

---

## ⚙️ Prerequisites
- Java 21
- Maven 3.9+
- PostgreSQL 14+ with PostGIS installed


