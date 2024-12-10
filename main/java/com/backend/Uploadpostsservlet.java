package com.backend;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
@WebServlet("/uploadpost")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,maxFileSize = 1024 * 1024 * 10,maxRequestSize = 1024 * 1024 * 50)
public class Uploadpostsservlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String username = User.Getloggedinusername(sessionId);
        Part postpart = request.getPart("postImage");
        String postsPath = processProfilePic(postpart, request);
        User.addposts(postsPath, username);
        response.sendRedirect("/profile");
    }
    public String processProfilePic(Part profilePicPart,HttpServletRequest request) throws IOException{
        if (profilePicPart!=null){
            long fileSize = profilePicPart.getSize();
            if (fileSize>0){
                String fileName = profilePicPart.getSubmittedFileName();
                if (fileName != null && isValidImage(fileName)){
                    String uniqueFileName = UUID.randomUUID().toString() + "-" + fileName;
                    String uploadDir = request.getServletContext().getRealPath("/") + "images"; 
                    File directory = new File(uploadDir);
                    if (!directory.exists()){
                        directory.mkdirs();
                    }
                    String filePath = uploadDir + File.separator + uniqueFileName;
                    profilePicPart.write(filePath);
                    return "images/" + uniqueFileName;
                } 
                else{
                    System.out.println("Invalid image file type: " + fileName);
                }
            } 
            else{
                System.out.println("Uploaded file has zero size.");
            }
        } 
        else{
            System.out.println("No file part received in the request.");
        }
        return "images/default-profile.png";
    }

    public boolean isValidImage(String fileName){
        String lowerCaseFileName = fileName.toLowerCase();
        return lowerCaseFileName.endsWith(".png") || lowerCaseFileName.endsWith(".jpg") || lowerCaseFileName.endsWith(".jpeg");
    }
}


