package com.backend;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Loginservlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        boolean islogged = User.login(username,password,sessionId);
        if(islogged==true){
            response.sendRedirect("/profile");
        } 
        else{
            response.getWriter().println("Try again, wrong credentials or this user was not registered!");
        }
    }
}
