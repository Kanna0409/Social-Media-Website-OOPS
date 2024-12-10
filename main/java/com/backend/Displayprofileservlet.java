package com.backend;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class Displayprofileservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String username = User.Getloggedinusername(sessionId);
        if (username!=null){
            String name = User.Displayname(username);
            String bio = User.Displaybio(username);
            String profilePic = User.Displayprofilepic(username); 
            List<String> posts = User.Displayposts(username); 
            request.setAttribute("name", name);
            request.setAttribute("bio", bio);
            request.setAttribute("profilePic", profilePic);
            if (posts!=null && posts.size()!=0){
                request.setAttribute("posts", posts);
            }
            if (name!=null && bio!=null){
                request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(request, response);
            } 
            else{
                response.sendRedirect("updateprofile.html");
            }
        } else {
            response.sendRedirect("login.html");
        }
    }
}