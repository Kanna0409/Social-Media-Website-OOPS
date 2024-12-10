package com.backend;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Registerservlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if(!password.equals(confirmPassword)){
            response.getWriter().println("Passwords do not match.");
            return;
        }
        boolean isRegistered = User.registeruser(username,password);
        if(isRegistered==true){
            response.sendRedirect("login.html");
        } 
        else{
            response.getWriter().println("Username already exists. Please try again.");
            request.getRequestDispatcher("register.html").forward(request, response);
        }
    }
}