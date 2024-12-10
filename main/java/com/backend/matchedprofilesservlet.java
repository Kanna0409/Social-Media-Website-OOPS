package com.backend;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/search")
public class matchedprofilesservlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String query = request.getParameter("query");
        Map<String,Node> matchedprofiles = Search.searchprofile(query);
        List<Integer> userids = new ArrayList<>();
        List<String> profilepics = new ArrayList<>();
        List<String> usernames = new ArrayList<>(matchedprofiles.keySet());
        Node temp;
        String usrn;
        for(int i=0;i<matchedprofiles.size();i++){
            usrn = usernames.get(i);
            temp = matchedprofiles.get(usrn);
            userids.add(temp.getId());
            profilepics.add(temp.displayprofilepic());
        }
        request.setAttribute("userIds", userids);
        request.setAttribute("profilePics", profilepics);
        request.setAttribute("usernames", usernames);
        request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
    }
}

