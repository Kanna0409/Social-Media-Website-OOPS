
# Social Media Web Application

## Project Overview
This project is a social media web application implemented in Java using Spring Boot and servlet-based web development. Key features include user authentication, profile management, and search functionalities.

---

## Features
1. **User Authentication**:
   - **Login**: Handled by `Loginservlet`. Validates user credentials and creates a session on success.
   - **Registration**: Managed by `Registerservlet`. Ensures username uniqueness and password matching before registering a new user.

2. **Profile Management**:
   - Users can view and update their profiles, likely facilitated by servlets like `Updateprofileservlet`.

3. **Search Functionality**:
   - Enables users to search for profiles or other content, with the `Searchservlet` forwarding requests to a JSP page (`search.jsp`).

4. **Dynamic Content Rendering**:
   - JSP files (e.g., `profile.jsp`, `search.jsp`) provide dynamic content rendering.

---

## Design
1. **Architecture**:
   - Built on **Spring Boot** for simplified dependency management and bootstrapping.
   - Servlets handle specific tasks (e.g., login, registration, search).
   - Uses JSP for rendering dynamic content on the client side.

2. **Configuration**:
   - `application.properties` sets up basic application properties:
     - Application runs on port `8081`.
     - JSP files are served from the `/WEB-INF/jsp/` directory.

3. **Session Management**:
   - User sessions are managed via `HttpSession` for login and session persistence.

4. **Static and Dynamic Content**:
   - Static files (`index.html`, `login.html`) are stored in `src/main/resources/static/`.
   - JSP files handle server-side rendering for dynamic pages.

---

## Implementation
1. **Main Application**:
   - `SocialmediawebsiteApplication` serves as the entry point for the Spring Boot application.
   - Annotated with `@SpringBootApplication` and `@ServletComponentScan` for servlet scanning.

2. **Login Logic** (`Loginservlet.java`):
   - Handles POST requests.
   - Calls a `User.login()` method to verify credentials.
   - Redirects to the profile page on success; shows an error message on failure.

3. **Registration Logic** (`Registerservlet.java`):
   - Handles POST requests for user registration.
   - Checks password confirmation and ensures username uniqueness by invoking `User.registeruser()`.

4. **Search Functionality** (`Searchservlet.java`):
   - Handles GET requests.
   - Forwards users to a search JSP (`search.jsp`) for entering search queries.

---

