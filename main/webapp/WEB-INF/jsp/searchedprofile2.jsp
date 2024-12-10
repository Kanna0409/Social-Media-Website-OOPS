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
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .profile-container {
            max-width: 700px;
            margin: 40px auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .profile-pic {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            object-fit: cover;
            margin-bottom: 25px;
            border: 3px solid #ddd;
        }
        .profile-name {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 15px;
            color: #333;
        }
        .profile-bio {
            font-size: 18px;
            color: #555;
            margin-bottom: 25px;
            line-height: 1.6;
        }
        .profile-id {
            font-size: 18px;
            color: #777;
            margin-bottom: 20px;
            font-style: italic;
        }
        .posts {
            margin-top: 30px;
        }
        .posts h3 {
            font-size: 22px;
            color: #333;
            margin-bottom: 15px;
        }
        .post-item {
            font-size: 16px;
            color: #333;
            padding: 15px;
            background-color: #f9f9f9;
            border-radius: 8px;
            margin-bottom: 15px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease;
        }
        .post-item:hover {
            background-color: #f1f1f1;
        }
        .add-friend-btn {
            display: inline-block;
            padding: 12px 25px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 18px;
            margin-top: 25px;
            transition: background-color 0.3s ease;
        }
        .add-friend-btn:hover {
            background-color: #45a049;
        }
        .post-image {
            width: 100%;
            max-width: 500px;
            height: auto;
            border-radius: 8px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="profile-container">
        <img src="${profilePic}" alt="Profile Picture" class="profile-pic">
        <div class="profile-name">${profileName}</div>
        <div class="profile-id">ID: ${userId}</div>  <!-- Displaying the user ID -->
        <div class="profile-bio">${profileBio}</div>
        <div class="posts">
            <h3>Posts</h3>
            <c:forEach var="post" items="${profilePosts}">
                <div class="post-item">
                    <!-- Displaying the image for each post -->
                    <img src="${post}" alt="Post Image" class="post-image">
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
