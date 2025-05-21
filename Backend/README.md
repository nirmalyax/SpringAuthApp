# SpringAuthApp

---

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.0-6DB33F.svg?style=flat&logo=spring-boot)
![Supabase](https://img.shields.io/badge/Supabase-3ECF8E?style=flat&logo=supabase&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13.0-336791.svg?style=flat&logo=postgresql)
![Gradle](https://img.shields.io/badge/Gradle-7.6-02303A.svg?style=flat&logo=gradle)
![Docker](https://img.shields.io/badge/Docker-24.0.2-2496ED.svg?style=flat&logo=docker)
![Java](https://img.shields.io/badge/Java-17-ED8B00.svg?style=flat&logo=java)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162.svg?style=flat&logo=junit5)
![REST API](https://img.shields.io/badge/REST_API-FF6C37.svg?style=flat&logo=postman)
![License](https://img.shields.io/badge/License-MIT-blue.svg)


## ✨ Features

- **User Registration**: Create new user accounts with validation
- **User Authentication**: Secure login mechanism with password encryption
- **RESTful API Design**: Modern API architecture following REST principles
- **Data Persistence**: Reliable storage with Supabase PostgreSQL
- **Security**: Input validation and protected endpoints
- **Error Handling**: Comprehensive error responses

## ⚙️ Tech Stack

- **Backend Framework**: Spring Boot 3
- **Build System**: Gradle 7.6+
- **Database**: Supabase (PostgreSQL)
- **ORM**: Spring Data JPA
- **Security**: Spring Security (BCrypt password encoding)
- **Testing**: JUnit 5, Mockito

## 🧠 System Architecture

### Data Flow Diagram (Level 1)

```
User → AuthController: Register/Login Request
AuthController → UserService: Process Request
UserService → UserRepository: Data Operations
UserRepository → Supabase-PostgreSQL: Database Queries
Supabase-PostgreSQL → UserRepository: User Data
UserRepository → UserService: Data Results
UserService → AuthController: Service Response
AuthController → User: API Response
```

## 📁 Project Structure
```
SpringAuthApp/
├── build.gradle                    # Gradle build configuration
├── settings.gradle                 # Gradle settings
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── nirmalya/
│   │   │           └── springauthapp/
│   │   │               ├── controller/        # API endpoints
│   │   │               │   └── AuthController.java
│   │   │               ├── model/             # Entity classes
│   │   │               │   └── User.java
│   │   │               ├── repository/        # Data access objects
│   │   │               │   └── UserRepository.java
│   │   │               ├── service/           # Business logic
│   │   │               │   └── UserService.java
│   │   │               ├── config/            # Application config
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── exception/         # Custom exceptions
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               └── SpringAuthAppApplication.java
│   │   └── resources/
│   │       ├── application.properties         # Main config
│   │       ├── application-dev.properties     # Development config
│   │       └── application-prod.properties    # Production config
│   └── test/                                  # Test cases
│       └── java/
│           └── com/
│               └── nirmalya/
│                   └── springauthapp/
│                       ├── controller/
│                       │   └── AuthControllerTest.java
│                       └── service/
│                           └── UserServiceTest.java
└── README.md   # This file
```

## 🗃️ Database Schema: `users` Table

| Column      | Type      | Constraints                                |
|-------------|-----------|--------------------------------------------|
| `id`        | BIGINT    | Primary key, auto-generated                |
| `username`  | VARCHAR   | Not null                                   |
| `email`     | VARCHAR   | Unique, not null                           |
| `password`  | VARCHAR   | Encrypted, not null                        |
| `created_at`| TIMESTAMP | Default: current timestamp                 |
| `updated_at`| TIMESTAMP | Default: current timestamp                 |
| `active`    | BOOLEAN   | Default: true                              |

---
## Database Connection

Update your `src/main/resources/application.properties`:
```# Database Configuration
# Database Configuration
spring.datasource.url=jdbc:postgresql://.com:6543/postgres
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate Configuration
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

# Connection Pool Configuration
spring.datasource.hikari.connection-timeout=20000
spring.datasource.hikari.maximum-pool-size=5

# Show SQL
spring.jpa.show-sql=true

# Server Configuration
server.port=8080

# Logging Configuration
logging.level.org.springframework=INFO
logging.level.com.nirmalya.springauthapp=DEBUG

# Security Configuration (if using JWT)
# app.jwt.secret=your-secret-key
# app.jwt.expiration=86400000
```

## 🙌 Author
 - #### **_Nirmalya Mondal_** - No-Developer

## 📜 License
This project is licensed under the `MIT License` - see the LICENSE file for details.


