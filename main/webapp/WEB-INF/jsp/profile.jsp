<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        /* Global Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7f9;
            color: #333;
        }

        .container {
            width: 90%;
            max-width: 1200px;
            margin: 40px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        .profile-header {
            display: flex;
            align-items: center;
            justify-content: flex-start;
            margin-bottom: 30px;
            border-bottom: 2px solid #ddd;
            padding-bottom: 20px;
        }

        .profile-header img {
            width: 140px;
            height: 140px;
            border-radius: 50%;
            object-fit: cover;
            margin-right: 20px;
            border: 4px solid #4CAF50;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
        }

        .profile-info h2 {
            font-size: 30px;
            color: #4CAF50;
            margin-bottom: 10px;
        }

        .profile-info p {
            font-size: 18px;
            color: #777;
        }

        .form-section {
            background-color: #f9f9f9;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
            margin-top: 30px;
        }

        .form-section h4 {
            font-size: 22px;
            color: #4CAF50;
            text-align: center;
            margin-bottom: 20px;
        }

        input[type="text"],
        input[type="file"],
        textarea {
            padding: 16px;
            border: 2px solid #ddd;
            border-radius: 8px;
            font-size: 16px;
            width: 100%;
            margin-bottom: 20px;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="file"]:focus,
        textarea:focus {
            border-color: #4CAF50;
        }

        .upload-btn {
            padding: 12px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
            text-align: center;
        }

        .upload-btn:hover {
            background-color: #45a049;
        }

        .posts-gallery {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: space-evenly;
            margin-top: 30px;
        }

        .posts-gallery img {
            width: 250px;
            height: 250px;
            object-fit: cover;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            transition: transform 0.3s ease;
        }

        .posts-gallery img:hover {
            transform: scale(1.05);
        }

        h3 {
            font-size: 26px;
            color: #333;
            margin-top: 40px;
            text-align: center;
            font-weight: bold;
            letter-spacing: 2px;
        }

        footer {
            text-align: center;
            padding: 20px;
            background-color: #4CAF50;
            color: white;
            margin-top: 40px;
            border-radius: 10px;
            font-size: 16px;
        }

        footer a {
            color: white;
            text-decoration: none;
            font-weight: bold;
        }

        footer a:hover {
            text-decoration: underline;
        }

        /* New Button Styling for Search */
        .search-btn {
            position: absolute;
            top: 20px;
            right: 20px;
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .search-btn:hover {
            background-color: #0056b3;
        }

        @media (max-width: 768px) {
            .container {
                padding: 15px;
            }

            .profile-header {
                flex-direction: column;
                align-items: center;
                text-align: center;
            }

            .profile-header img {
                margin-bottom: 20px;
            }

            .posts-gallery {
                justify-content: center;
            }

            .posts-gallery img {
                width: 200px;
                height: 200px;
            }

            .form-section h4 {
                font-size: 18px;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <!-- Search Button -->
        <form action="/searchsrvlt" method="GET" style="display: inline;">
            <button class="search-btn" type="submit">Go to Search</button>
        </form>

        <div class="profile-header">
            <!-- Profile Picture -->
            <img src="<c:if test='${not empty profilePic}'>${profilePic}</c:if><c:if test='${empty profilePic}'>/default-profile.jpg</c:if>" alt="Profile Picture">

            <div class="profile-info">
                <h2><c:if test='${not empty name}'>${name}</c:if><c:if test='${empty name}'>User</c:if></h2>
                <p><c:if test='${not empty bio}'>${bio}</c:if><c:if test='${empty bio}'>No bio available.</c:if></p>
            </div>
        </div>

        <!-- Link to Update Profile -->
        <p style="text-align: center; font-size: 18px; font-weight: bold;">
            <a href="updateprofile.html" style="color: #4CAF50;">Update Profile</a>
        </p>

        <!-- Post Gallery -->
        <h3>Your Posts</h3>
        <div class="posts-gallery">
            <c:if test='${not empty posts}'>
                <c:forEach var="post" items="${posts}">
                    <img src="${post}" alt="Post Image">
                </c:forEach>
            </c:if>
            <c:if test='${empty posts}'>
                <p>No posts available.</p>
            </c:if>
        </div>

        <!-- Post Upload Section -->
        <div class="form-section">
            <h4>Upload a New Post</h4>
            <form action="/uploadpost" method="POST" enctype="multipart/form-data">
                <input type="file" name="postImage" required>
                <button class="upload-btn" type="submit">Upload Post</button>
            </form>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 YourWebsite | All Rights Reserved</p>
    </footer>
</body>

</html>
