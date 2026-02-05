# This is the initial prototype of the project. The project has since evolved into a team-based version with full functionality, which you can find here: https://github.com/Nik974/BiletUZ


# Cinema-Booking-System

A backend service for a cinema ticket reservation and purchasing system, built with Spring Boot. This is an educational project focused on implementing a secure, scalable, and modern Java backend.

The core feature already implemented is a robust Authentication and Authorization system using Spring Security and JWT (JSON Web Tokens).


## Key Features

### Implemented:

* Secure User Authentication: Full Sign Up (Registration) and Log In (Authentication) flow.

* Password Hashing: User passwords are securely stored using BCryptPasswordEncoder

* JWT-Based Security: API endpoints are secured using Spring Security, requiring a valid JWT.

### In Progress / Planned:

* QR Code Ticket Generation: Creating a unique QR code for each purchased ticket.

* Email Service: Sending booking confirmations and tickets via email (spring-boot-starter-mail).

* Cinema/Map Integration: Using OpenStreetMap to display cinema locations.

* Full Booking Flow: Implementing logic for movie sessions, seat selection, and booking.

### Tech Stack

* Java 21

* Spring Boot 3.5.6

* Spring Security

* JWT

* PostgreSQL 18

* Spring Data JPA 

* Maven

* Docker & Docker Compose (for containerizing and running the database)

## How to Run Locally

To get this project up and running on your local machine, follow these steps.

### Prerequisites

* Java 21 (JDK)

* Apache Maven

* Docker Desktop

## 1. Set Up Environment Variables

This project uses .env (for Docker) and application.properties (for Spring) to handle sensitive data. These files are not committed to Git (via .gitignore).

### Create .env file (for Docker)

Create a file named .env in the project's root directory and add your database credentials:

### .env file
    DB_NAME=cinemadb
    DB_USER=postgres
    DB_PASSWORD=mysecretpassword



### Database Configuration

Edit `application.properties`:

    spring.datasource.url=jdbc:postgresql://localhost:5432/cinemadb
    spring.datasource.username=postgres
    spring.datasource.password=mysecretpassword
    spring.jpa.hibernate.ddl-auto=update

### JWT Secret Key (Generate your own strong key)
    jwt.secret-key=/*paste here your key*/
## 2. Launch the Database

Run the PostgreSQL database in a Docker container using Docker Compose.

    docker-compose up -d

## 3. Run the Spring Boot Application


    mvn spring-boot:run

The application will start on `http://localhost:8080`

# API Usage Examples

The API is secured with JWT. You must register and log in to receive a bearer token. This token must be included in the Authorization header for all other protected endpoints.

Here are the examples for authentication using curl:

## 1. Register a New User

Send a POST request to /api/auth/register with your username, email, and password.
Bash

    curl -X POST 'http://localhost:8080/api/auth/register' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "username": "myuser",
    "email": "myuser@example.com",
    "password": "mypassword123"
    }'

### Success Response:
    
    {
    "message": "User registered successfully!"
    }

## 2. Log In to Get JWT Token

Send a POST request to /api/auth/login with the credentials you just registered.
Bash

    curl -X POST 'http://localhost:8080/api/auth/login' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "username": "myuser",
    "password": "mypassword123"
    }'

### Success Response:

The server will return a JWT token.
    
    {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJteXVzZXIiLCJpYXQiOjE3Nj..."
    }

