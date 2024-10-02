# Flight Reservation System
## Diagram
[View the project example diagram on Pinterest](https://i.pinimg.com/736x/ac/99/e2/ac99e2271ba26d0f0500803116942f85.jpg)



## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [System Architecture](#system-architecture)
- [Database Schema](#database-schema)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)


## Project Overview
The Flight Reservation System is a web-based application developed to facilitate flight booking, management, and payment functionalities for users, while providing administrators the ability to manage flights, airports, and schedules. The project is built using modern technologies, with separate services for users and admins.

Users can search for available flights, book tickets, and make secure payments. Administrators can manage flight details, monitor bookings, and perform CRUD operations on airports and flights. The system includes features like PDF ticket generation, real-time email/SMS notifications, and API documentation using OpenAPI.

## Technologies Used
### Frontend:
- React.js
- HTML, CSS, Bootstrap

### Backend:
- Java with Spring Boot (User service)
- ASP.NET Core (Admin service)
- Hibernate (Java ORM)

### Database:
- MySQL

### Additional Tools:
- JWT for secure user authentication
- GitHub for version control
- Docker for containerization
- OpenAPI (Swagger) for API documentation

## Features
### User Features:
- User registration, login, and authentication
- Flight search and booking
- View, update, and cancel bookings
- Receive PDF tickets via email after successful booking
- Real-time email and SMS notifications for booking updates
- Secure payments with transaction confirmation

### Admin Features:
- Admin login for role-based access
- Manage flights: add, update, delete, and view flight details
- Manage airports: add, update, delete, and view airport information
- Monitor and manage user bookings
- Generate reports and view analytics

### Additional Features:
- PDF ticket generation
- Real-time notifications via email/SMS
- Role-based access control (Users vs Admins)
- API documentation using OpenAPI (Swagger)

## System Architecture
The Flight Reservation System is divided into two main backend services:

### User Service:
- Developed using Java (Spring Boot) and responsible for user functionalities like flight booking, user management, and payments.

### Admin Service:
- Developed using ASP.NET Core to manage admin-related functionalities like flight management, airport operations, and user data handling.

**High-level System Design:**
- **Frontend (React.js):** Provides an interactive and responsive user interface.
- **Backend (Java, ASP.NET):** Handles business logic, REST APIs, and database interactions.
- **Database (MySQL):** Stores user, flight, booking, and airport data.
- **REST APIs:** Used for communication between the frontend and backend services.

## Database Schema
The main entities in the system are:
- **User:** Stores user information like user_id, name, email, password, role (User/Admin).
- **Flight:** Contains flight details like flight_id, departure_time, arrival_time, and airline_name.
- **Airport:** Contains information about airports, such as airport_code, city, country.
- **Booking:** Tracks bookings made by users, including booking_id, flight_id, user_id, and status.
- **Scheduled Flight:** Tracks the availability and scheduling of specific flights.
- **Payment:** Manages payment details such as payment_id, amount, payment_status.
- **Ticket:** Contains ticket information post-booking, including ticket_number, seat_number, and class.

## Installation
### Backend (User Service):
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/flight-reservation-system.git
2. Navigate to the user-service directory.
3. Configure the MySQL database in the application.properties file.
4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run

### Backend (Admin Service):
1. Navigate to the admin-service directory.
2. Ensure that ASP.NET Core is installed.
3. Run the admin service:
    ```bash
    dotnet run

### Frontend:
1. Navigate to the react-frontend directory.
2. Install the required dependencies:
   ```bash
   npm install

3. Start the React development server:
   ```bash
   npm start

## Usage
1. Open the frontend in your browser at [http://localhost:3000](http://localhost:3000).
2. Users can register, log in, search for flights, and manage their bookings.
3. Admins can log in and manage flights, airports, and view user bookings.
4. Payment confirmations and PDF tickets will be sent to users via email.

## API Documentation
### Sample API Endpoints:
- Get all flights (GET): `/flight/allFlights`
- Book a flight (POST): `/booking/bookFlight`
- Admin add airport (POST): `/admin/addAirport`

## Future Enhancements
- Implement seat selection during the booking process.
- Integration with third-party payment gateways.
- Add support for multiple languages.
- Introduce loyalty reward programs for frequent flyers.
- Implement real-time flight tracking.

## Contributing
We welcome contributions! Follow these steps to contribute:
1. Fork the repository.
2. Create a new branch for your feature.
3. Make changes and commit your code.
4. Create a pull request explaining your changes.



