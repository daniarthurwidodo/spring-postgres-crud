# Spring Boot PostgreSQL CRUD Application

A Spring Boot REST API with PostgreSQL database that demonstrates CRUD operations and pagination.

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── ecommerce
│   │               ├── EcommerceApplication.java
│   │               ├── controller
│   │               │   └── ProductController.java
│   │               ├── model
│   │               │   └── Product.java
│   │               ├── repository
│   │               │   └── ProductRepository.java
│   │               └── service
│   │                   └── ProductSeeder.java
│   └── resources
│       ├── application.properties
│       └── application-test.properties
├── test
│   └── java
│       └── com
│           └── example
│               └── ecommerce
│                   ├── controller
│                   │   └── ProductControllerTest.java
│                   └── repository
│                       └── ProductRepositoryTest.java
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md
```

## Prerequisites

- Java 21
- Docker & Docker Compose
- Maven

## Getting Started

1. Start PostgreSQL database:

```bash
docker-compose up -d
```

2. Build the application:

```bash
mvn clean package
```

3. Run the application:

```bash
mvn spring-boot:run
```

## API Endpoints

### Products API

Base URL: `/api/products`

#### List Products

```http
GET /api/products
```

Query parameters:

- `page` (default: 0)
- `size` (default: 10)
- `category` (optional)
- `minPrice` (optional)
- `maxPrice` (optional)

Response:

```json
{
    "content": [
        {
            "id": 1,
            "name": "Product Name",
            "description": "Description",
            "price": 99.99,
            "category": "Electronics",
            "stock": 100
        }
    ],
    "totalElements": 100,
    "totalPages": 10,
    "number": 0,
    "size": 10
}
```

#### Get Product

```http
GET /api/products/{id}
```

#### Create Product

```http
POST /api/products
Content-Type: application/json

{
    "name": "New Product",
    "description": "Product Description",
    "price": 99.99,
    "category": "Electronics",
    "stock": 100
}
```

#### Update Product

```http
PUT /api/products/{id}
Content-Type: application/json

{
    "name": "Updated Product",
    "description": "Updated Description",
    "price": 149.99,
    "category": "Electronics",
    "stock": 200
}
```

#### Delete Product

```http
DELETE /api/products/{id}
```

## Testing

Run unit tests:

```bash
mvn test
```

## Database Seeding

Seed the database with 2000 sample products:

```bash
java -jar target/spring-postgres-crud-0.0.1-SNAPSHOT.jar --seed
```

## Docker Support

Build Docker image:

```bash
docker build -t spring-postgres-app .
```

Run with Docker Compose:

```bash
docker-compose up -d
```

## Environment Variables

Configure in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Push to branch
5. Open a Pull Request

## License

This project is under the MIT License.
