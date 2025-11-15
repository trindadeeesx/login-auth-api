# Login Auth API

Register and Login API made in Java using Spring, H2 Database and JWT.  
Personal portfolio project demonstrating user registration, authentication, and authorization using bearer tokens.

## Table of contents
- About
- Tech stack
- Features
- Getting started
    - Requirements
    - Configuration
    - Run
- API (example endpoints)
- Usage examples (curl)
- H2 Console
- Notes & Security
- License
- Author

## About
This is a small, focused Spring-based API that implements:
- User registration (save user with hashed password)
- User login (issue JWT)
- Bearer-token authorization for protected endpoints

It's a personal project intended for portfolio use and learning/explaining common auth patterns (Spring, JWT).

## Tech stack
- Java (11+ recommended)
- Spring Boot (Web, Security, Data JPA)
- H2 in-memory database (for quick local development)
- JWT for stateless authentication

## Features
- Register new users
- Login and receive a JWT access token
- Protect endpoints using "Authorization: Bearer <token>"
- Simple H2 database for persistence (no external DB required)
- Example protected endpoint(s) to verify token-based access

## Getting started

### Requirements
- Java 11 or newer
- Maven (or the project's build tool if different)
- Git (optional, to clone this repo)

### Configuration
Default configuration is suitable for local development using H2. For production-like usage, set a secure JWT secret and appropriate token expiry.

Typical configurable properties (application.properties / application.yml):
- jwt.secret (or environment variable JWT_SECRET)
- jwt.expiration-ms (token lifetime in milliseconds)

Example (application.properties):
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true

jwt.secret=change-this-secret-for-prod
jwt.expiration-ms=3600000
```

Set a secure `jwt.secret` before deploying or sharing the service.

### Run
From the project root (Maven example):
```
# build
mvn clean package

# run
mvn spring-boot:run
# or
java -jar target/login-auth-api-<version>.jar
```

The API will start on port 3333 unless configured otherwise.

## API (example endpoints)
The exact routes in your implementation may vary — adjust these examples to match the project's controllers.

- POST /auth/register
    - body: { "name": "user complete name", "email": "user@example.com", "password": "secret" }

- POST /auth/login
    - body: { "email": "email@email.com", "password": "secret" }
    - response: { "name": "user complete name", "email": "email@email.com", "token": "<jwt>" }

- GET /users (example protected endpoint)
    - header: Authorization: Bearer <jwt>
    - response: user info if token valid

H2 Console (dev): /h2-console

## Usage examples (curl)

Register:
```
curl -X POST http://localhost:3333/auth/register \
  -H "Content-Type: application/json" \
  -d '{"name":"john","email":"john@doe.com","password":"redhotchilipeppers"}'
```

Login:
```
curl -X POST http://localhost:3333/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"john@doe.com","password":"redhotchilipeppers"}'
```
Sample response:
```
{
  "name": "john",
  "email": "john@doe.com"
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

Access protected route:
```
curl -X GET http://localhost:3333/users \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

## H2 Console
If enabled (application.properties), visit:
http://localhost:3333/h2-console  
JDBC URL: jdbc:h2:mem:testdb  
User: sa  
Password: (empty)

## Notes & Security
- This project is intended for learning and portfolio purposes.
- For production:
    - Use a strong jwt.secret stored securely (not in source control).
    - Use HTTPS to protect tokens in transit.
    - Consider refresh tokens, token revocation/blacklist, and strict CORS and CSRF policies as needed.
    - Use a persistent database rather than H2 in-memory.
    - Harden Spring Security configuration and exception handling.

## License
MIT — see LICENSE file (or add one if you want to explicitly license this repo).

## Author
trindadeeesx — personal project / portfolio
