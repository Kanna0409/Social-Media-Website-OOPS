
# Social Media Web Application

This project is a Java-based web application designed for managing user profiles, uploading posts, and performing social media functionalities like searching for and adding friends.

## Project Structure

### 1. **Source Code (`main/java/com/backend/`)**
- **Addfriendservlet.java**: Handles the addition of friends.
- **Displayprofileservlet.java**: Displays user profiles.
- **Loginservlet.java**: Manages user authentication.
- **Matchedprofilesservlet.java**: Shows matched profiles based on certain criteria.
- **Node.java**: A utility class (likely used in a data structure or algorithm context).
- **Profileredirectservlet.java**: Redirects to the profile page.
- **Registerservlet.java**: Handles user registration.
- **Search.java**: Implements the logic for user search functionality.
- **Searchservlet.java**: Servlet for handling search operations.
- **Signup.java**: Manages the signup process.
- **SocialmediawebsiteApplication.java**: The main application class.
- **Updateprofileservlet.java**: Updates user profiles.
- **Uploadpostsservlet.java**: Handles post uploads.
- **User.java**: Represents the user model.

### 2. **Configuration (`main/resources/`)**
- **application.properties**: Contains application configurations.

### 3. **Frontend (`src/main/resources/static/`)**
- **index.html**: Homepage.
- **login.html**: Login page.
- **register.html**: User registration page.
- **updateprofile.html**: Update profile page.

### 4. **Images ('main/webapp/images/`)**
- A collection of user-uploaded images and assets for the application.

### 5. **Views (`main/webapp/WEB-INF/jsp/`)**
- **profile.jsp**: Displays the user profile.
- **search.jsp**: Search results page.
- **searchedprofile.jsp**, **searchedprofile2.jsp**: Different layouts for searched profiles.

### 6. **Tests (`test/java/com/backend/`)**
- **SocialmediawebsiteApplicationTests.java**: Contains tests for the application.

## Features

- **User Authentication**: Login and signup functionality.
- **Profile Management**: Update and view user profiles.
- **Social Features**: Search for users, view matched profiles, and add friends.
- **Media Uploads**: Upload and display user posts and profile pictures.

## Technologies Used

- **Java Servlets**: Backend logic and request handling.
- **JSP (Java Server Pages)**: Dynamic web content generation.
- **HTML/CSS**: Frontend user interface.
- **Spring Boot**: Application framework.
- **Maven**: Dependency management and build tool.

## Setup Instructions

1. Clone the repository.
2. Navigate to the project root directory.
3. Configure the database connection in `application.properties`.
4. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Access the application at `http://localhost:8080`.



