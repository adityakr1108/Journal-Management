# 📝 Journal Management System

A secure **Journal Management System** built with Spring Boot that allows users to create and manage private journal entries with secure authentication.

---

## 🔐 Features

- ✅ **Secure Authentication** using Basic Auth
- 🔒 **Private Journal** access restricted to authenticated users
- 📦 **Stateless Authentication** – no sessions, ideal for REST APIs
- 🔐 **Password Encryption** using BCrypt
- 🧠 **Custom UserDetailsService** for loading users/roles from the database
- 🌐 **REST API** for journal entry management

---

## ⚙️ Technologies Used

- **Spring Boot** – Backend application framework
- **Spring Security** – Authentication and Authorization
- **Spring Data JPA** – ORM for database interactions
- **BCrypt** – Password hashing
- **H2 Database** – In-memory DB for development *(can be replaced with MySQL/PostgreSQL)*
- **Lombok** – Boilerplate code reduction

---

## 🧰 Requirements

- **Java 17** or above
- **Maven**
- **Spring Boot 2.x** or later
- **IDE** like IntelliJ IDEA or Eclipse

---

## 🚀 Setup Instructions

### 1. Clone the Repository

git clone https://github.com/yourusername/journal-management.git
2. Navigate to Project Directory
bash
Copy
Edit
cd journal-management
3. Install Dependencies
bash
Copy
Edit
mvn clean install
4. Run the Application
bash
Copy
Edit
mvn spring-boot:run
🔗 Visit: http://localhost:8080

📁 Project Structure
swift
Copy
Edit
journal-management/
│
├── src/
│   └── main/
│       ├── java/com/edigest/journal/
│       │   ├── app/
│       │   │   ├── config/
│       │   │   │   └── SpringSecurity.java
│       │   │   ├── controller/
│       │   │   │   └── JournalController.java
│       │   │   ├── entity/
│       │   │   │   └── UserEntry.java
│       │   │   ├── repository/
│       │   │   │   └── UserRepository.java
│       │   │   ├── service/
│       │   │   │   └── UserDetailsServiceImpl.java
│       │   │   └── JournalApplication.java
│       └── resources/
│           ├── application.properties
│           └── static/
├── pom.xml
📡 API Endpoints
🔑 POST /login
Authenticates users using Basic Auth.

Request Body:

json
Copy
Edit
{
  "username": "your_username",
  "password": "your_password"
}
📖 GET /journal/entries
Retrieves all journal entries of the authenticated user.

Authorization: Basic Auth
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
📝 POST /journal/entries
Creates a new journal entry.

Authorization: Basic Auth
Request Body:

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
🛠️ Database Configuration
Default (H2 In-Memory)
No setup needed. Accessible at:
http://localhost:8080/h2-console

Switch to MySQL (Example)
Update application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/journal_db
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🔐 Security Considerations
Basic Auth: Used for simplicity. For production, consider using JWT or OAuth2.

Password Hashing: All user passwords are hashed with BCrypt.

🤝 Contribution
Fork the repository

Create a new branch:

bash
Copy
Edit
git checkout -b feature-branch
Commit your changes:

bash
Copy
Edit
git commit -am 'Add new feature'
Push to GitHub:

bash
Copy
Edit
git push origin feature-branch
Create a Pull Request

📜 License
This project is licensed under the MIT License.
See the LICENSE file for details.

🙌 Acknowledgements
Spring Boot

Spring Security

BCrypt

Lombok

H2 Database

Built with ❤️ by Aditya Kumar

yaml
Copy
Edit

---

Let me know if you'd like to add GitHub badges, API documentation with Swagger, or a UI component (e.g., using Thymeleaf or React).
