# Bazar API

This repository contains a RESTful API for managing a Bazar, built using Spring Boot, Hibernate, and MySQL Workbench. Postman was employed for testing HTTP requests.

## Overview

The API provides services for managing Clients, Sales, and Products within a Bazar context. Basic CRUD operations are supported for all three entities. Additionally, there are several special endpoints available:

- Endpoint to retrieve the largest sale.
- Endpoint to summarize sales for a specific date.
- Endpoint to fetch products requiring restocking.

The project follows a multi-package architecture, including:

- Model: Contains entity classes for Hibernate mappings.
- Controller: Implements RESTful endpoints.
- DTO: Data Transfer Objects for transferring data between layers.
- Repository: Interfaces for database access using Spring Data JPA.
- Service: Contains business logic.

## Endpoints

### Customer
- `GET /customer/get/all`: Retrieve a list of all clients.
- `GET /customer/get/{id}`: Retrieve a client by ID.
- `POST /customer/create`: Create a new client.
- `PUT /customer/edit/{id}`: Update an existing client.
- `DELETE /customer/delete/{id}`: Delete a client by ID.

### Sales
- `GET /sale/create`: Retrieve a list of all sales.
- `GET /sale/get/{id}`: Retrieve a sale by ID.
- `POST /sale/create`: Create a new sale.
- `PUT /sale/edit/{id}`: Update an existing sale.
- `DELETE /sale/delete/{id}`: Delete a sale by ID.

### Products
- `GET /product/get/all`: Retrieve a list of all products.
- `GET /product/get/{id}`: Retrieve a product by ID.
- `POST /product/create`: Create a new product.
- `PUT /product/edit/{id}`: Update an existing product.
- `DELETE /product/delete/{id}`: Delete a product by ID.

### Additional Endpoints
- `GET /sale/biggest-sale`: Retrieve the largest sale.
- `GET /sale/summary/{date}`: Retrieve a summary of sales for a specific date.
- `GET /product/need_restock`: Retrieve products requiring restocking.

## Technologies Used

- **Spring Boot**: For creating RESTful APIs.
- **Hibernate**: For object-relational mapping.
- **MySQL Workbench**: For database design and management.
- **Postman**: For testing HTTP requests.

## Contributions

Contributions are welcome! If you find any issues or want to enhance the functionality, feel free to submit a pull request.
```
