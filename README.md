# ✈️ Airline Booking App

A full-stack airline booking application built with **Spring Boot** and **React**.  
The project provides a practical example of building an airline reservation system with authentication, flight management, airport management, booking management, passenger information, email notification, and a layered backend architecture.

## 📌 Project Overview

**Airline Booking App** is designed to simulate the core workflow of an online flight-booking system:

- Users can register and log in securely.
- Users can browse available flights.
- Flights are associated with departure and arrival airports.
- Users can create and manage flight bookings.
- A booking can contain multiple passengers.
- Passenger information is stored together with the booking.
- Email functionality is integrated for notifications.
- Role-based authorization is supported for different user permissions.

The application is divided into two main parts:

```text
airline-booking-app/
├── backend/       # Spring Boot REST API
└── frontend/      # React client
```

---

## 🛠️ Tech Stack

### Backend

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot 4.1.1 | Backend framework |
| Spring MVC | REST API |
| Spring Data JPA | Database access |
| Spring Security | Authentication & authorization |
| JWT | Stateless authentication |
| MySQL | Relational database |
| JavaMail / Spring Mail | Email notifications |
| Thymeleaf | Email/template rendering |
| ModelMapper | DTO ↔ Entity mapping |
| Lombok | Reduce boilerplate code |
| Maven | Build & dependency management |

### Frontend

| Technology | Purpose |
|---|---|
| React 19 | User interface |
| Vite | Frontend development/build tool |
| React Router | Client-side routing |
| Axios | HTTP requests |
| JavaScript | Frontend programming language |

The versions above are based on the current project configuration. fileciteturn2file0 fileciteturn3file0

---

## ✨ Main Features

### 🔐 Authentication & Authorization

- User registration
- User login
- JWT-based authentication
- Password protection
- Role-based access control
- Protected API endpoints

### 👤 User Management

- User profile information
- Email and phone number
- Account activation status
- User roles
- User booking history

### ✈️ Flight Management

- Create and manage flights
- Flight number
- Flight status
- Departure airport
- Arrival airport
- Departure time
- Arrival time
- Base ticket price
- Assigned pilot

### 🏢 Airport Management

- Airport information
- Airport name
- City
- Country
- IATA code

### 🎫 Booking Management

- Create flight bookings
- Booking reference
- Booking date
- Booking status
- Associate a booking with a user
- Associate a booking with a flight
- Multiple passengers per booking

### 👨‍👩‍👧 Passenger Management

Each booking can contain multiple passengers with information such as:

- First name
- Last name
- Passport number
- Passenger type
- Seat number
- Special requests

### 📧 Email Notification

The backend includes an email module using Spring Mail for sending booking-related notifications.

---

# 🏗️ System Architecture

The backend follows a conventional layered architecture:

```text
                    ┌─────────────────────┐
                    │   React Frontend    │
                    │       (Client)      │
                    └──────────┬──────────┘
                               │ HTTP / REST
                               ▼
                    ┌─────────────────────┐
                    │     Controller      │
                    │  REST API Layer     │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │       Service       │
                    │ Business Logic      │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │     Repository      │
                    │   Data Access       │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │       MySQL         │
                    │      Database       │
                    └─────────────────────┘

             ┌──────────────────────────────┐
             │ Authentication / Security    │
             │ JWT + Spring Security        │
             └──────────────────────────────┘

             ┌──────────────────────────────┐
             │       Email Module           │
             │       Spring Mail            │
             └──────────────────────────────┘
```

The project structure separates configuration, controllers, DTOs, entities, enums, exceptions, repositories, security, and services. fileciteturn6file0

## 📐 Architecture Diagram

<img width="806" height="679" alt="image" src="https://github.com/user-attachments/assets/2eca40d0-2975-4897-a620-dffb85860d00" />


---

# 🗄️ Database Design

The main domain entities are:

- `User`
- `Role`
- `Airport`
- `Flight`
- `Booking`
- `Passenger`
- `EmailNotification`

### Entity relationships

```text
User
 │
 ├── Roles
 │
 └── Bookings
       │
       ├── Flight
       │      ├── Departure Airport
       │      └── Arrival Airport
       │
       └── Passengers

EmailNotification
 └── Booking
```

### Database ERD
<img width="1545" height="880" alt="image" src="https://github.com/user-attachments/assets/8eadb0d9-74cb-4c62-bf65-d7aab2e3e59a" />


---

# 📂 Backend Project Structure

```text
backend/
└── src/
    └── main/
        ├── java/com/airline_booking_app/
        │   ├── config/
        │   ├── controller/
        │   ├── dto/
        │   ├── entity/
        │   ├── enums/
        │   ├── exception/
        │   ├── repo/
        │   ├── security/
        │   └── services/
        │
        └── resources/
            ├── application.properties
            └── templates/
```

The repository currently contains dedicated controllers for authentication, users, roles, airports, and flights. fileciteturn7file0

---

# 🌐 API Overview

The backend exposes REST APIs for the main application modules.

Typical API groups include:

```text
/api/auth
/api/users
/api/roles
/api/airports
/api/flights
/api/bookings
```

> The exact endpoint paths should be checked against the current controller mappings before using them in production documentation.

---

# ⚙️ Configuration

The backend currently uses MySQL with the following local database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/airlinedb
spring.datasource.username=root
spring.datasource.password=<your-password>
```

Hibernate is configured to update the database schema automatically during development:

```properties
spring.jpa.hibernate.ddl-auto=update
```

The frontend login and booking URLs are also configured through application properties. fileciteturn11file0

## ⚠️ Security Note

**Do not commit real database passwords, JWT secrets, Gmail passwords, API keys, or other credentials to GitHub.**

If credentials are currently present in `application.properties`, rotate them and move them to environment variables or another secure configuration mechanism before using the repository publicly.

Example:

```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

jwtSecreteString=${JWT_SECRET}

spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
```

---

# 🚀 Getting Started

## 1. Prerequisites

Make sure you have installed:

- Java 21
- Maven
- Node.js
- npm
- MySQL
- Git

---

## 2. Clone the Repository

```bash
git clone https://github.com/HungHayHo-IT/airline-booking-app.git
cd airline-booking-app
```

---

## 3. Create the MySQL Database

Create the database:

```sql
CREATE DATABASE airlinedb;
```

Then configure the database credentials in:

```text
backend/src/main/resources/application.properties
```

---

## 4. Start the Backend

```bash
cd backend
mvn spring-boot:run
```

The backend uses the default Spring Boot HTTP port unless another port is configured.

---

## 5. Start the Frontend

Open another terminal:

```bash
cd frontend
npm install
npm run dev
```

Vite will display the local development URL in the terminal.

---

# 🔄 Application Flow

A typical booking workflow looks like this:

```text
1. User
   │
   ▼
2. Register / Login
   │
   ▼
3. JWT Authentication
   │
   ▼
4. Search Flights
   │
   ▼
5. Select Flight
   │
   ▼
6. Enter Passenger Information
   │
   ▼
7. Create Booking
   │
   ▼
8. Save Booking + Passengers
   │
   ▼
9. Send Email Notification
```

---

# 🧪 Testing

Backend tests can be executed with Maven:

```bash
cd backend
mvn test
```

For manual API testing, tools such as **Postman** or **Insomnia** can be used.

Recommended testing flow:

```text
Authentication
     ↓
Create/Login User
     ↓
Create Airport
     ↓
Create Flight
     ↓
Search Flight
     ↓
Create Booking
     ↓
Add Passenger Information
     ↓
Verify Booking
     ↓
Verify Email Notification
```

---

# 🔒 Security

The application uses:

- Spring Security
- JWT authentication
- Password-based authentication
- Role-based authorization
- Protected API endpoints

The goal is to keep authentication and authorization responsibilities separated from the application's business logic.

---

# 📈 Future Improvements

Possible improvements for future versions:

- [ ] Docker / Docker Compose
- [ ] CI/CD with GitHub Actions
- [ ] Redis caching
- [ ] Payment integration
- [ ] Seat availability management
- [ ] Flight search filters
- [ ] Pagination and sorting
- [ ] Global exception handling improvements
- [ ] API documentation with OpenAPI / Swagger
- [ ] Integration testing
- [ ] Production deployment
- [ ] Centralized application logging

---

# 🎯 Learning Goals

This project is intended to demonstrate practical experience with:

- Building a full-stack application
- Designing REST APIs
- Spring Boot layered architecture
- Spring Security and JWT
- JPA entity relationships
- MySQL database design
- DTO and entity mapping
- React frontend development
- HTTP communication between React and Spring Boot
- Email notification integration
- Authentication and authorization

---

# 👨‍💻 Author

**HungDeveloper**

GitHub:  
https://github.com/HungHayHo-IT

---

## 📄 License

This project is for learning and portfolio purposes.
