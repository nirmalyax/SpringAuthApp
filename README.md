# Spring Authentication Application

## Project Overview
This is a full-stack authentication application built with Spring Boot backend and HTML/CSS frontend. The application provides basic user authentication functionality including user registration and login. The backend API handles the authentication logic while the frontend provides a simple interface for users to interact with.

## Technology Stack

### Backend
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL (Supabase)
- Gradle Build Tool

### Frontend
- HTML5
- CSS3
- JavaScript (vanilla)

## Project Structure

```
demo/
├── Backend/                          # Spring Boot application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/nirmalya/springauthapp/
│   │   │   │   ├── config/           # Configuration classes
│   │   │   │   ├── controller/       # REST controllers
│   │   │   │   ├── model/            # Entity classes
│   │   │   │   ├── repository/       # Data repositories
│   │   │   │   ├── service/          # Business logic
│   │   │   │   └── SpringAuthAppApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   ├── build.gradle                 # Gradle configuration
│   └── Dockerfile                   # Docker configuration
└── SpringAuthApp-frontend/          # Frontend application
    ├── index.html                   # Login page
    ├── register.html                # Registration page
    └── style.css                    # Styling
```

## Setup Instructions

### Prerequisites
- JDK 17 or higher
- Gradle
- PostgreSQL database or Supabase account
- Web browser
- Web server for frontend (e.g., Live Server extension for VSCode)

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd demo
   ```

2. **Configure Database**
   - Create a Supabase account and project at [supabase.com](https://supabase.com/)
   - Get your connection URL, username, and password
   - Update the `Backend/src/main/resources/application.properties` file:
     ```properties
     spring.datasource.url=jdbc:postgresql://<your-supabase-host>:6543/postgres
     spring.datasource.username=<your-supabase-username>
     spring.datasource.password=<your-supabase-password>
     ```

3. **Build the application**
   ```bash
   cd Backend
   ./gradlew build
   ```

### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd SpringAuthApp-frontend
   ```

2. **Serve the frontend**
   - If you're using Visual Studio Code, install Live Server extension and click "Go Live"
   - Alternatively, you can use any static file server:
     ```bash
     # Using Python's built-in server
     python -m http.server 5500
     ```

## API Endpoints

The backend provides the following REST endpoints:

### 1. Register a User

**Endpoint:** `POST /api/auth/register`  
**Content-Type:** `application/json`

#### Request Body:
```json
{
  "username": "john123",
  "email": "john@example.com",
  "password": "password123"
}
```

#### Responses:

**201 CREATED: User registered successfully**
```json
{
  "id": 1,
  "username": "john123",
  "email": "john@example.com",
  "message": "User registered successfully"
}
```

**400 BAD REQUEST: Validation error**
```json
{
  "timestamp": "2023-05-17T12:00:00.000+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Email must be valid"
}
```

**409 CONFLICT: Email already exists**
```json
{
  "timestamp": "2023-05-17T12:00:00.000+00:00",
  "status": 409,
  "error": "Conflict",
  "message": "Email already registered"
}
```

### 2. Login a User

**Endpoint:** `POST /api/auth/login`  
**Content-Type:** `application/json`

#### Request Body:
```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

#### Responses:

**200 OK: Login successful**
```json
{
  "id": 1,
  "username": "john123",
  "email": "john@example.com",
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "message": "Login successful"
}
```

**401 UNAUTHORIZED: Invalid credentials**
```json
{
  "timestamp": "2023-05-17T12:00:00.000+00:00",
  "status": 401,
  "error": "Unauthorized",
  "message": "Invalid email or password"
}
```

## Current Implementation Notes

The API documentation above represents the intended final API design. The current implementation may differ in the following ways:

1. **JWT Tokens:** The token-based authentication shown in the login response is not yet implemented. The current implementation returns user details but no authentication token.

2. **Status Codes:** The current implementation may return different HTTP status codes than documented:
   - Registration success returns 200 OK instead of 201 CREATED
   - Error responses might use different status codes

3. **Response Format:** The actual error responses are currently simpler than documented:
   - Error responses may not include timestamp and detailed status information
   - The registration success response may only return a simple message without user details

4. **Validation:** The current implementation has minimal input validation. Field validations mentioned in the documentation may not be fully implemented.

These differences will be addressed in future updates to align the implementation with the documentation.

## Frontend Details

The frontend consists of two main pages:

1. **Login Page (index.html)**
   - Form for user authentication
   - Fields: Email and Password
   - Submit button to send login request

2. **Registration Page (register.html)**
   - Form for new user registration
   - Fields: Username, Email, and Password
   - Submit button to send registration request

The styling is defined in a single CSS file (style.css) that provides a clean, responsive interface.

## Development Environment Requirements

- IDE: IntelliJ IDEA, Eclipse, VS Code, or any Java IDE
- JDK 17+
- Gradle 8.x
- Web browser (Chrome, Firefox, Edge, etc.)
- Supabase account or PostgreSQL database

## Running the Application

### Running the Backend

1. **Navigate to backend directory**
   ```bash
   cd Backend
   ```

2. **Run the Spring Boot application**
   ```bash
   ./gradlew bootRun
   ```
   The server will start on port 8080.

3. **Using Docker (optional)**
   ```bash
   docker build -t spring-auth-app .
   docker run -p 8080:8080 spring-auth-app
   ```

### Running the Frontend

1. **Serve the frontend with a static file server on port 5500**

2. **Open in browser**
   - Navigate to http://localhost:5500

## Security Considerations

**Note:** This is a basic authentication application for demonstration purposes. For production use, consider implementing:

- Password hashing (currently using plain text passwords)
- JWT or session-based authentication
- HTTPS
- Input validation
- CSRF protection

## License

[MIT License](LICENSE)

