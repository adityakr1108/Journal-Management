# Journal Management System

This is a **Journal Management System** that allows users to maintain a private journal. Users can securely authenticate, create, and manage journal entries.

---

## Features

- **Secure Authentication**: Users can log in to the system with username and password using Basic Authentication.
- **Private Journal**: Access to journal entries is restricted to authenticated users.
- **Stateless Authentication**: The system does not store sessions, making it suitable for stateless applications.
- **Password Encryption**: All user passwords are securely stored using BCrypt encryption.
- **Custom Authentication**: Uses a custom UserDetailsService to load users and roles from the database.

---

## Technologies Used

- **Spring Boot**: For creating the backend application.
- **Spring Security**: For managing authentication and authorization.
- **Spring Data JPA**: To interact with the database.
- **BCrypt Password Encoder**: For securing user passwords.
- **H2 Database (Optional)**: A simple in-memory database for development (can be replaced with any database like MySQL or PostgreSQL).
- **Lombok**: To reduce boilerplate code.
- **REST API**: Exposes secure endpoints for accessing journal entries.

---

## Requirements

- **Java 17** or above
- **Maven** (for building and managing dependencies)
- **Spring Boot 2.x** or later
- **IDE** (e.g., IntelliJ IDEA, Eclipse)

---

## Setup

### Clone the Repository
```bash
git clone https://github.com/yourusername/journal-management.git
  Set up the project
Navigate to the project directory:

bash
Copy
Edit
cd journal-management
Install dependencies using Maven:

bash
Copy
Edit
mvn clean install
Run the application:

bash
Copy
Edit
mvn spring-boot:run
By default, the application will run on http://localhost:8080.

Folder Structure
arduino
Copy
Edit
journal-management/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── edigest/
│   │   │   │   │   ├── journal/
│   │   │   │   │   │   ├── app/
│   │   │   │   │   │   │   ├── config/
│   │   │   │   │   │   │   │   ├── SpringSecurity.java
│   │   │   │   │   │   │   ├── service/
│   │   │   │   │   │   │   │   ├── UserDetailsServiceImpl.java
│   │   │   │   │   │   │   ├── entity/
│   │   │   │   │   │   │   │   ├── UserEntry.java
│   │   │   │   │   │   │   ├── repository/
│   │   │   │   │   │   │   │   ├── UserRepository.java
│   │   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   │   ├── JournalController.java
│   │   │   │   │   │   │   ├── JournalApplication.java
│   │   │   ├── resources/
│   │   │   │   ├── application.properties
│   │   │   │   └── static/
│   │   │   └── pom.xml
Endpoints
1. POST /login
Authentication Endpoint
Used for authenticating users with username and password.

Request body:

json
Copy
Edit
{
    "username": "your_username",
    "password": "your_password"
}
Response: A token or successful login response.

2. GET /journal/entries
Retrieve Journal Entries
This endpoint is accessible only to authenticated users.

Authorization: Basic Auth (provide username and password).

Response:

json
Copy
Edit
[
    {
        "id": 1,
        "date": "2025-04-01",
        "title": "My first journal",
        "content": "This is my first journal entry"
    }
]
3. POST /journal/entries
Create a new journal entry
This endpoint allows users to create new journal entries.

Authorization: Basic Auth (provide username and password).

Request body:

json
Copy
Edit
{
    "title": "My new journal entry",
    "content": "This is the content of the journal entry"
}
Response:

json
Copy
Edit
{
    "id": 2,
    "date": "2025-04-02",
    "title": "My new journal entry",
    "content": "This is the content of the journal entry"
}
Database Configuration
This application uses an in-memory H2 database for development purposes. You can configure your own database (e.g., MySQL, PostgreSQL) by updating the application.properties file.

Example for MySQL:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/journal_db
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Security Considerations
Basic Authentication: The application uses basic authentication for simplicity. For production, consider switching to JWT-based authentication or OAuth2.

Password Security: Passwords are stored securely with BCrypt hashing.

Contribution
Fork the repository.

Create a new branch (git checkout -b feature-branch).

Make your changes.

Commit your changes (git commit -am 'Add new feature').

Push to the branch (git push origin feature-branch).

Create a new pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgements
Spring Boot: For rapid application development.

Spring Security: For authentication and authorization.

BCrypt: For password hashing.

pgsql
Copy
Edit
