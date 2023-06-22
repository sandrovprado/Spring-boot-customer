API Endpoints
The project exposes the following RESTful API endpoints:

@RequestMapping("/api/v1/customers")

Method	Endpoint	Description
GET	/api/customers	Retrieve all customers
GET	/api/customers/{customerID}	Retrieve a customer by ID
POST	/api/customers	Create a new customer
PUT	/api/customers/{customerID}	Update an existing customer
DELETE	/api/customers/{customerID}	Delete a customer by ID

