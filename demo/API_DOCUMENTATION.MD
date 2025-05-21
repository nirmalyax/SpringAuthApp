# 📦 API Documentation

---

## 1. Register a User

**Endpoint:** `POST /api/auth/register`  
**Content-Type:** `application/json`

### 🔸 Request Body:
```json
{
  "username": "john123",
  "email": "john@example.com",
  "password": "password123"
}
````

### ✅ 201 CREATED: User registered successfully

```json
{
  "id": 1,
  "username": "john123",
  "email": "john@example.com",
  "message": "User registered successfully"
}
```

### ❌ 400 BAD REQUEST: Validation error

```json
{
  "timestamp": "2023-05-17T12:00:00.000+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Email must be valid"
}
```

### ❌ 409 CONFLICT: Email already exists

```json
{
  "timestamp": "2023-05-17T12:00:00.000+00:00",
  "status": 409,
  "error": "Conflict",
  "message": "Email already registered"
}
```

---

## 2. Login a User

**Endpoint:** `POST /api/auth/login`
**Content-Type:** `application/json`

### 🔸 Request Body:

```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

### ✅ 200 OK: Login successful

```json
{
  "id": 1,
  "username": "john123",
  "email": "john@example.com",
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "message": "Login successful"
}
```

### ❌ 401 UNAUTHORIZED: Invalid credentials

```json
{
  "timestamp": "2023-05-17T12:00:00.000+00:00",
  "status": 401,
  "error": "Unauthorized",
  "message": "Invalid email or password"
}
```