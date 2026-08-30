# E-Commerce RESTful API

A backend RESTful API for an e-commerce platform built with Java 26, Spring Boot, Spring Security 6, JWT, PostgreSQL, and Flyway.

> **Project Purpose:** I am using this project to apply what I learned about Spring Boot into practice, building a clean, production-ready backend architecture from scratch.

---

## Roadmap & Implementation Steps

### Step 1 [DONE]: Database Setup & Migrations
* Configure PostgreSQL connection settings using environment variables.
* Set up Flyway for automated schema versioning.
* Define relational tables, foreign key constraints, and indexes using incremental SQL migration files.

### Step 2 [DONE]: Domain Modeling (JPA Entities)
* Create JPA entity classes mapped directly to database tables.
* Configure entity relationships (`@OneToOne`, `@ManyToOne`, `@ManyToMany`).

### Step 3: Repositories & Data Access Layer
* Implement Spring Data JPA repositories for CRUD operations.
* Build custom query methods and dynamic filtering using JPA Specifications.

### Step 4: DTOs & Service Layer
* Create Data Transfer Objects (DTOs) to decouple internal entities from client requests/responses.
* Implement business logic in transactional service classes (`@Transactional`).
* Add custom exception handling and global error-handling controllers.

### Step 5: Authentication & Security
* Configure Spring Security 6 with stateless session management.
* Implement user registration, password hashing (BCrypt), and JWT-based authentication.
* Set up role-based access control (RBAC) to protect specific endpoints.

### Step 6: REST Controllers & API Endpoints
* Expose RESTful endpoints for catalog browsing, product filtering, user profiles, and wishlists.
* Ensure consistent JSON response structures and HTTP status codes.

---

## Tech Stack
* **Language:** Java 26
* **Framework:** Spring Boot 4 (Spring MVC, Spring Data JPA, Spring Security 6)
* **Database:** PostgreSQL
* **Migration Tool:** Flyway
* **Build Tool:** Maven
* **Authentication:** JWT (JSON Web Tokens)