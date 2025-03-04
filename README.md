# Demo Project: Member Management API with Spring Boot

This project is a Spring Boot-based REST API for managing member accounts. It provides functionalities for user registration, login, retrieving user information, and updating user details. It also incorporates security features using Spring Security and JWT (JSON Web Tokens).

## Features

*   **User Registration:**
    *   Allows new users to sign up by providing their login ID, password, name, birth date, gender, and email.
    *   Input validation is enforced for each field.
    *   Password must follow a specific pattern (alphanumeric with special characters, 8-20 characters long).
    *   Email format is validated.
    *   Birthdate format is validated (YYYY-MM-DD).
    * gender must be `MAN` or `WOMAN`
*   **User Login:**
    *   Enables existing users to log in using their login ID and password.
    *   Generates and returns a JWT upon successful authentication.
*   **Retrieve User Information:**
    *   Authenticated users can fetch their own user details.
    *   Includes the user's ID, login ID, name, birth date, gender, and email.
*   **Update User Information:**
    *   Authenticated users can modify their own information.
    *   Only the information given by user will be update.
*   **Security:**
    *   Uses Spring Security for authentication and authorization.
    *   Employs JWTs for secure token-based authentication.
    *   Password hashing is implemented.
* **Test:**
    * One test for sign up function was implemented.
*   **Data Validation:**
    *   Utilizes the `@Valid` annotation and various constraints (e.g., `@NotBlank`, `@Email`, `@Pattern`, `@ValidEnum`) to ensure data integrity.

## Technologies Used

*   **Java 17+:** The core programming language.
*   **Kotlin:** Core programing language.
*   **Spring Boot:** A framework for building stand-alone, production-grade Spring-based applications.
*   **Spring Security:** Provides comprehensive security services for Spring applications.
*   **Spring Web:** For building RESTful web services.
*   **Spring Data JPA:** Simplifies database interaction.
*   **H2 Database:** An in-memory relational database (for development/testing).
*   **JUnit 5:** For testing.
*   **Lombok:** Reduces boilerplate code with annotations.
*   **Jackson:** For JSON serialization/deserialization.
*   **Gradle:** Build automation tool.

## Project Structure

The project follows a standard Gradle directory structure:

*   `src/main/kotlin`: Contains the main Kotlin source code.
    *   `com.example.demo`: The root package for the application.
        *   `common`: Package for common code.
            * `annotation`: Custom annotation for `Enum` validation.
            *   `authority`:  Security-related classes (like JWT utility, TokenInfo etc).
            *   `dto`: Data transfer objects shared across the application.
            *   `service`: UserDetailsService.
            * `status`: `Enum` class are save here.
        *   `member`: Package related to member management.
            *   `controller`: REST controllers for handling HTTP requests.
            *   `dto`: Data transfer objects specific to members.
            *   `entity`: JPA entities representing member data.
            *   `repository`: Data access layer for members.
            *   `service`: Business logic for member management.
*   `src/test/kotlin`: Contains unit and integration tests.
*   `src/main/resources`: Configuration and resource files.
*   `build.gradle.kts`: The Gradle build file.
*   `settings.gradle.kts`: Configures project name.

## Setup and Installation

1.  **Prerequisites:**
    *   Java Development Kit (JDK) 17 or higher.
    *   Gradle (or you can use the Gradle wrapper included in the project).

2.  **Clone the Repository:**
    ```bash
    git clone <repository-url>
    cd demo
    ```

3.  **Build the Project:**
    ```bash
    ./gradlew build
    ```
    (Or `gradlew.bat build` on Windows)

4.  **Run the Application:**
    ```bash
    ./gradlew bootRun
    ```
    (Or `gradlew.bat bootRun` on Windows)

    The application will start on the default port (usually `8080`).

## API Endpoints

*   **`POST /api/member/signup`:** Register a new user.
    *   **Request Body:** `MemberDtoRequest` (JSON)
    ```json
    {
      "loginId": "newuser",
      "password": "StrongPassword123!",
      "name": "New User",
      "birthDate": "2000-01-01",
      "gender": "MAN",
      "email": "newuser@example.com"
    }
    ```
    *   **Response Body:** `BaseResponse` (JSON) with a success message.
*   **`POST /api/member/login`:** Log in an existing user.
    *   **Request Body:** `LoginDto` (JSON)
    ```json
    {
      "loginId": "existinguser",
      "password": "password"
    }
    ```
    *   **Response Body:** `BaseResponse<TokenInfo>` (JSON) with a JWT.
*   **`GET /api/member/info`:** Get the logged-in user's information.
    *   **Headers:** `Authorization: Bearer <JWT>`
    *   **Response Body:** `BaseResponse<MemberDtoResponse>` (JSON)
    ```json
    {
      "id": 1,
      "loginId": "existinguser",
      "name": "Existing User",
      "birthDate": "2000-01-01",
      "gender": "MAN",
      "email": "existinguser@example.com"
    }
    ```
*   **`PUT /api/member/info`:** Update the logged-in user's information.
    *   **Headers:** `Authorization: Bearer <JWT>`
    *   **Request Body:** `MemberDtoRequest` (JSON)
    ```json
        {
          "loginId": "existinguser",
          "password": "NewStrongPassword123!",
          "name": "New name",
          "birthDate": "2000-01-01",
          "gender": "WOMAN",
          "email": "newemail@example.com"
        }
    ```
    *   **Response Body:** `BaseResponse` (JSON) with a success message.

## Running Tests
