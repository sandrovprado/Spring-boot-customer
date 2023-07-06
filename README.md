# Spring Boot Customer

This is a sample project called "Spring Boot Customer" that demonstrates a basic implementation of a customer management system using Spring Boot. The project provides RESTful APIs for creating, retrieving, updating, and deleting customer information.

## API Endpoints

The project exposes the following RESTful API endpoints:

| Method | Endpoint                | Description                                  |
| ------ | ----------------------- | -------------------------------------------- |
| GET    | `/api/customers`        | Retrieve all customers                        |
| GET    | `/api/customers/{customerID}`   | Retrieve a customer by ID                     |
| POST   | `/api/customers`        | Create a new customer                         |
| PUT    | `/api/customers/{customerID}`   | Update an existing customer                   |
| DELETE | `/api/customers/{customerID}`   | Delete a customer by ID      



# Customer Table 

| Column    | Data Type | Constraints                             | Description                            |
|-----------|-----------|-----------------------------------------|----------------------------------------|
| id        | Integer   | Primary key (auto-increments by 1)      | Unique identifier for the customer     |
| name      | String    | Not null                                | Name of the customer                   |
| email     | String    | Not null, Unique                        | Email address of the customer          |
| age       | Integer   | Not null                                | Age of the customer                    |


