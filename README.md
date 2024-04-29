### Employees Service README

#### Introduction
The Employees Service microservice manages employee-related operations and integrates with other services. It is built using Spring Boot and functions as a discovery client with Eureka for service discovery. This README provides an overview of the components, functionalities, and setup instructions for the Employees Service.

#### Components

##### 1. Security Configuration
- **Package:** `com.example.employeesservice.config`
- **Description:** Configures security for HTTP requests. Defines a security filter chain to permit all requests and disables Cross-Site Request Forgery (CSRF) protection.

##### 2. Employee Controller
- **Package:** `com.example.employeesservice.controllers`
- **Description:** Handles HTTP requests related to employee management. Provides endpoints to retrieve all employees, get an employee by ID, create a new employee, and handles exceptions such as employee not found or invalid data.

##### 3. Address Feign Client
- **Package:** `com.example.employeesservice.feignClient`
- **Description:** Integrates with the Address service using Feign client. Provides a method to fetch address data by employee ID.

##### 4. Employee Repository
- **Package:** `com.example.employeesservice.repositories`
- **Description:** Interfaces with the database using Spring Data JPA. Provides methods for CRUD (Create, Read, Update, Delete) operations on the Employee entity.

##### 5. Main Application
- **Package:** `com.example.employeesservice`
- **Description:** Configures the main Spring Boot application. Enables service discovery with Eureka, sets up Feign clients, and defines beans for ModelMapper and WebClient.

#### Setup Instructions
To set up and run the Employees Service:

1. **Clone the Repository:** Clone the repository containing the microservice code.
2. **Build the Project:** Build the project using Maven or Gradle.
3. **Configure Database:** Configure the database connection properties in the `application.properties` file.
4. **Start Eureka Server:** If not already running, start the Eureka server for service discovery.
5. **Run the Application:** Start the Spring Boot application.
6. **Access the API:** Access the RESTful API endpoints for employee management.

#### Dependencies
- **Spring Boot**: Framework for creating stand-alone, production-grade Spring-based applications.
- **Spring Cloud**: Provides tools and libraries for building cloud-native applications.
- **Spring Data JPA**: Simplifies the implementation of data access layers.
- **Feign Client**: Declarative web service client used to integrate with other services.
- **Eureka Client**: Integrates with the Eureka server for service discovery.
- **ModelMapper**: Facilitates object mapping between DTOs and entities.
- **WebClient**: Non-blocking, reactive HTTP client for making requests to other services.

#### Contributing
Contributions to the Employees Service are welcome. Please fork the repository, make changes, and submit a pull request.

#### Contact
For any inquiries or support regarding the Employees Service, please contact azimjon.works@gmail.com.

#### License
This project is licensed under MIT Lincense. See the LICENSE file for more details.
