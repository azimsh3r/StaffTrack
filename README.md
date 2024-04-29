### Employees Service Configuration

#### Description
This package contains the configuration files for the Employees Service. It includes security configuration and Spring Bean definitions.

#### Security Configuration
- **Class:** `SecurityConfig`
  - **Description:** Configures security settings for HTTP requests. Any request is permitted, and CSRF protection is disabled.

#### Spring Beans
- **Class:** `EmployeesServiceApplication`
  - **Description:** Main entry point of the Employees Service application. It initializes the Spring Boot application and defines necessary beans.
  - **Beans:**
    - `modelMapper`: Provides a ModelMapper bean for mapping objects.
    - `webClient`: Configures a load-balanced WebClient bean for making HTTP requests.

### Employees Service Controllers

#### Description
This package contains controller classes responsible for handling HTTP requests related to employees.

- **Class:** `EmployeeController`
  - **Description:** Manages CRUD operations for employees. Exposes RESTful API endpoints for retrieving all employees, retrieving an employee by ID, creating new employees, and handling exceptions.
  - **Endpoints:**
    - `GET /employee`: Retrieves all employees.
    - `GET /employee/{id}`: Retrieves an employee by ID.
    - `POST /employee`: Creates a new employee.
  - **Exception Handling:**
    - `EmployeeNotFoundException`: Handles exceptions when an employee is not found.
    - `EmployeeInvalidDataException`: Handles exceptions for invalid employee data.

### Employees Service Feign Client

#### Description
This package contains a Feign client for communicating with the Address Microservice.

- **Interface:** `AddressClient`
  - **Description:** Declares methods for accessing address-related endpoints in the Address Microservice using Feign.
  - **Methods:**
    - `getByEmpId(int id)`: Retrieves address information by employee ID.

### Employees Service Repositories

#### Description
This package contains the repository interface for interacting with the database.

- **Interface:** `EmployeeRepository`
  - **Description:** Extends JpaRepository for CRUD operations on the Employee entity.

### Employees Service Application

#### Description
This class serves as the main entry point for the Employees Service application.

- **Class:** `EmployeesServiceApplication`
  - **Description:** Initializes the Spring Boot application and enables service discovery with Eureka. It also configures necessary beans like ModelMapper and WebClient for making HTTP requests.

#### Dependencies
- **Spring Cloud OpenFeign**: Facilitates communication with other microservices via Feign clients.
- **Spring Cloud Discovery Client**: Integrates the service with Eureka for service discovery.
- **Spring Data JPA**: Simplifies database interactions using JPA.
- **ModelMapper**: Facilitates object mapping between DTOs and entities.
- **Spring Boot Web**: Provides tools for building web applications.
- **Spring WebFlux**: Provides reactive programming support for making non-blocking HTTP requests.
