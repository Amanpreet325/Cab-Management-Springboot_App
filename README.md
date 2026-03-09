# Pahadi Punjabi Yatra - Cab Booking System

## 📖 Overview

A Spring Boot application demonstrating a **real-world cab booking system** with proper business layer architecture. Built as a learning project to understand enterprise-level Spring Boot development patterns.

---

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────┐
│                    Controller Layer                     │
│         (REST APIs - handles HTTP requests)             │
├─────────────────────────────────────────────────────────┤
│                      DTO Layer                          │
│    (Data Transfer Objects - request/response models)    │
├─────────────────────────────────────────────────────────┤
│                    Mapper Layer                         │
│        (Converts between DTOs and Entities)             │
├─────────────────────────────────────────────────────────┤
│                    Service Layer                        │
│            (Business logic implementation)              │
├─────────────────────────────────────────────────────────┤
│                  Repository Layer                       │
│              (Database operations - JPA)                │
├─────────────────────────────────────────────────────────┤
│                    Model/Entity Layer                   │
│              (Database table mappings)                  │
└─────────────────────────────────────────────────────────┘
```

---

## 📁 Project Structure

```
src/main/java/com/ppy/pahadi_punjabi_yatra/
├── controller/          # REST API endpoints
├── dto/                 # Data Transfer Objects
├── mapper/              # Entity <-> DTO converters
├── service/             # Business logic
│   ├── customer/
│   ├── cab/
│   ├── driver/
│   └── booking/
├── repository/          # JPA repositories
├── model/               # Entity classes
└── exception/           # Custom exceptions
```

---

## 🔄 Business Flow

### How a Cab Booking Works:

1. **Customer Registration** → Customer signs up with details
2. **Cab Registration** → Cabs are added to the fleet
3. **Driver Registration** → Drivers join the platform
4. **Driver-Cab Assignment** → Drivers are assigned to cabs
5. **Booking Creation** → Customer books an available cab
6. **Ride Completion** → Status updates, fare calculation

---

## 🧩 Layer Responsibilities

| Layer | Responsibility |
|-------|----------------|
| **Controller** | Handle HTTP requests, validate input, return responses |
| **DTO** | Transfer data between client and server (no entity exposure) |
| **Mapper** | Convert DTOs to Entities and vice versa |
| **Service** | Business logic, validations, transactions |
| **Repository** | Database CRUD operations |
| **Model** | JPA entities mapped to database tables |

---

## 🚀 Key Features

- ✅ Customer registration & management
- ✅ Cab fleet management
- ✅ Driver onboarding
- ✅ Real-time cab availability
- ✅ Booking system with status tracking
- ✅ Driver-Cab assignment
- ✅ Custom exception handling
- ✅ Input validation with error messages

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Maven**
- **MySQL/H2 Database**

---

## ▶️ Running the Application

```bash
# Clone the repository
git clone https://github.com/Amanpreet325/pahadi-punjabi-yatra.git

# Navigate to project
cd pahadi-punjabi-yatra

# Run with Maven
./mvnw spring-boot:run
```

---

## 📚 Learning Outcomes

- Understanding layered architecture in Spring Boot
- Implementing DTOs for API security
- Using MapStruct/manual mappers
- Exception handling with `@ControllerAdvice`
- JPA relationships (OneToOne, OneToMany)
- Service layer patterns

---

## 👤 Author

**Amanpreet325**

---

Save this as `README.md` in your project root.
