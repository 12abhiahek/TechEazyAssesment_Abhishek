Basic
Basic Spring Project with MVC, Security, and Spring Data Support This project demonstrates a basic Spring application using Spring MVC, Spring Security with JWT, and Spring Data JPA. The application manages Student and Subject entities and supports a REST API layer for CRUD operations. The project also includes in-memory database support with H2 to simplify setup and testing.

Table of Contents
Technologies Used
Project Structure
Prerequisites
Setup
Usage
API Endpoints
Security
Running the Application
Technologies Used
Spring Boot
Spring MVC
Spring Security (JWT)
Spring Data JPA
H2 Database
Maven
JDK 19+
Project Structure
src/ ├── main/ │ ├── java/ │ │ └── com/ │ │ └── example/ │ │ ├── config/ │ │ ├── controller/ │ │ ├── entity/ │ │ ├── repository/ │ │ ├── security/ │ │ └── service/ │ └── resources/ │ ├── application.properties │  └── test/

Prerequisites
JDK 19 or higher Maven 3.6 or higher

Setup
clone the Repository
Usage
Start Application mvn spring-boot:run
Access the H2 console
URL: 'http://localhost:8758/h2-console'
JDBC URL: 'jdbc:h2:mem:testdb'
Username: sa
Password: password or esle you can leave this part
API Endpoints
For Student
GET: http://localhost:8758/students (/students ) To get all the details of students
POST: http://localhost:8758/students/addStudentWithSubjects (/addStudentWithSubjects) to add the student and subject
For Subject
GET: http://localhost:8758/subjects (/subjects) to get all the subject
UPDATE: http://localhost:8758/subjects/id (id) to update specific subject name
DELETE: http://localhost:8758/subjects/id (id) to delete specific subject
GET: http://localhost:8758/subjects/id (/id) to get specific subject
Running the Application
mvn spring-boot: run

Note:
Spring security part code is not working properly that's why i am not adding those part of code.
