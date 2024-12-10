<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
        .search-form {
            display: flex;
            justify-content: center;
            margin: 20px;
        }
        .search-form input[type="text"] {
            padding: 10px;
            font-size: 16px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .search-form button {
            padding: 10px 20px;
            margin-left: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .search-form button:hover {
            background-color: #45a049;
        }
        .results-container {
            max-width: 800px;
            margin: 20px auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .result-item {
            display: flex;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        .result-item:last-child {
            border-bottom: none;
        }
        .profile-pic {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            object-fit: cover;
            margin: 0 20px;
        }
        .username {
            font-size: 16px;
            color: #333;
            text-align: left;
            flex-grow: 1;
        }
        .id-display {
            font-size: 14px;
            color: #555;
            margin-left: 20px;
        }
        .profile-form {
            margin-top: 20px;
            text-align: center;
        }
        .profile-form input[type="text"] {
            padding: 8px;
            font-size: 14px;
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .profile-form button {
            padding: 8px 16px;
            font-size: 14px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 10px;
        }
        .profile-form button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Search Results</h1>
    </div>

    <!-- Search Form -->
    <form action="/search" method="POST" class="search-form">
        <input type="text" name="query" placeholder="Search by username" required>
        <button type="submit">Search</button>
    </form>

    <!-- Search Results -->
    <div class="results-container">
        <c:forEach var="i" items="${userIds}" varStatus="status">
            <div class="result-item">
                <!-- Displaying the ID as text, not as a link -->
                <div class="id-display">${userIds[status.index]}</div>
                <img src="${profilePics[status.index]}" alt="Profile Picture" class="profile-pic">
                <div class="username">${usernames[status.index]}</div>
            </div>
        </c:forEach>
    </div>

    <!-- Form to input ID and submit via POST -->
    <div class="profile-form">
        <form action="/srchprf" method="POST">
            <label for="profileId">Enter UserId:</label>
            <input type="text" name="id" id="profileId" placeholder="Enter UserId" required>
            <button type="submit">View Profile</button>
        </form>
    </div>
</body>
</html>

