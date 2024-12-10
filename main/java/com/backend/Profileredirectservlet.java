package com.backend;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/srchprf")
public class Profileredirectservlet extends HttpServlet{
    @Override
    protected synchronized void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String yourusername = User.Getloggedinusername(sessionId);
        Node yournode = User.map.get(yourusername);
        String prfid = request.getParameter("id");
        int number = Integer.parseInt(prfid);
        String selectedusername = User.idstousernames.get(number);
        Node selectedprofile = User.map.get(selectedusername);
        String srchedname;
        String srchedprofilepic;
        List<String> srchedposts; 
        String srchedbio;
        if(selectedprofile!=null){
            srchedname = selectedprofile.displayname();
            srchedprofilepic = selectedprofile.displayprofilepic();
            srchedposts = selectedprofile.displayposts();
            srchedbio = selectedprofile.displaybio();
            request.setAttribute("profileName",srchedname);
            request.setAttribute("profilePic",srchedprofilepic);
            request.setAttribute("profileBio",srchedbio);
            request.setAttribute("profilePosts",srchedposts);
            request.setAttribute("userId",number);
            if(yournode.getfriends().contains(selectedusername)){
                request.getRequestDispatcher("/WEB-INF/jsp/searchedprofile2.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("/WEB-INF/jsp/searchedprofile.jsp").forward(request, response);
            }
        }
        else{
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
        }
    }
}