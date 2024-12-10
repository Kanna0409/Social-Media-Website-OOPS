package com.backend;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addfriend")
public class Addfriendservlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        int num;
        num = Integer.parseInt(request.getParameter("userId"));
        String selectedusername = User.idstousernames.get(num);
        Node selectedprofile = User.map.get(selectedusername);
        String srchedname;
        String srchedprofilepic;
        List<String> srchedposts; 
        String srchedbio;
        srchedname = selectedprofile.displayname();
        srchedprofilepic = selectedprofile.displayprofilepic();
        srchedposts = selectedprofile.displayposts();
        srchedbio = selectedprofile.displaybio();
        String username1 = User.idstousernames.get(num);
        String username2 = User.Getloggedinusername(sessionId);
        Node temp1 = User.map.get(username1);
        Node temp2 = User.map.get(username2);
        temp1.addfriend(username2);
        temp2.addfriend(username1);
        boolean isfriend = temp1.getfriends().contains(username2);
        request.setAttribute("isFriend", isfriend);
        request.setAttribute("profileName",srchedname);
        request.setAttribute("profilePic",srchedprofilepic);
        request.setAttribute("profileBio",srchedbio);
        request.setAttribute("profilePosts",srchedposts);
        request.setAttribute("userId",num);
        request.getRequestDispatcher("/WEB-INF/jsp/searchedprofile2.jsp").forward(request, response);
    }
}
