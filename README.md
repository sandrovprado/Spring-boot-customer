# Spring Boot Customer

This is a full stack application that utilizes React and Spring Boot. Demonstrates a basic implementation of a customer management system. The project provides RESTful APIs for creating, retrieving, updating, and deleting customer information. 

## API Endpoints

The project exposes the following RESTful API endpoints:

| Method | Endpoint                | Description                                  |
| ------ | ----------------------- | -------------------------------------------- |
| GET    | `/api/customers`        | Retrieve all customers                        |
| GET    | `/api/customers/{customerID}`   | Retrieve a customer by ID                     |
| POST   | `/api/customers`        | Create a new customer                         |
| PUT    | `/api/customers/{customerID}`   | Update an existing customer                   |
| DELETE | `/api/customers/{customerID}`   | Delete a customer by ID      


## Running the Project Locally

To run the `Spring-boot-customer` project on your local machine, follow these steps:

1. **Prerequisites:**
   - Java Development Kit (JDK) installed on your machine (Java 8 or higher)
   - Maven build tool installed (version 3.6.0 or higher)
   - Git installed

2. **Clone the Repository:**
   - Open a terminal or command prompt.
   - Clone the repository using Git:
     ```
     git clone https://github.com/sandrovprado/Spring-boot-customer.git
     ```

3. **Build the Project:**
   - Navigate to the project directory:
     ```
     cd Spring-boot-customer/backend
     ```
   - Build the project using Maven:
     ```
     ./mvnw clean install
     ```

4. **Run the Application:**
   - Start the Spring Boot application:
     ```
     ./mvnw spring-boot:run
     ```
   - Once the application is running, you can access it in your web browser at: `http://localhost:8080/api/customers`

5. **Testing:**
   - To run the tests, use the following command:
     ```
     ./mvnw test
     ```
   - The tests will be executed, and the results will be displayed in the console.




