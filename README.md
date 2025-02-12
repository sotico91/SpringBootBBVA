# SpringBootSpringBootBBVABBVA
App for this test in BBVA - API

## Description
This is a simple Spring Boot application that exposes a REST API to manage a list of users. The application is built using Maven and uses an in-memory H2 database to store the data.

## Requirements
- Java 17
- Maven 3.8.3
- Postman
- Git
- IDE (IntelliJ IDEA, Eclipse, etc.)
- Lombok plugin for your IDE
- Spring Boot plugin for your IDE


## Installation
1. Clone the repository using the following command:
    - https://github.com/sotico91/SpringBootBBVA.git
2. Open the project in your IDE.
3. Import the project as a Maven project.
4. Run the application using the Spring Boot plugin or the following command:
   - mvn spring-boot:run
5. The application will start on port 8090.


## Usage
The application exposes the following endpoints:

http://localhost:8090/swagger-ui/index.html#/

- GET http://localhost:8090/api/clients/{documentType}/{documentNumber}?withAddress=false Get user by documentType And documentNumber
- PUT http://localhost:8090/api/clients/{documentType}/{documentNumber} - body: {
  "firstName": "John",
  "lastName": "Doe",
  "phone": "+1234567890",
  "address": "123 Main St",
  "city": "New York",
  "email": "john.doe@example.com"
  }
- Update user by documentType And documentNumber




