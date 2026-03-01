package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("user_name");
        String email = request.getParameter("user_email");
        String password = request.getParameter("user_password");
        Part part = request.getPart("image");
        String fileName = part.getSubmittedFileName();
        
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/insta", "root", "2003@lokesh");
            
         
            String query = "insert into user(name,password,email,imageName) values(?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, fileName);
           
            
            pstmt.executeUpdate();           
           
            InputStream is = part.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            String uploadPath = request.getServletContext().getRealPath("/") + "img";
            
            File uploadDir = new File(uploadPath);
            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }
            
            String path = uploadPath + File.separator + fileName;
           // out.println("File Path: " + path);
            
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(data);
            fos.close();
            is.close(); 
            
            out.println("done");
            
            pstmt.close();
            con.close();
            
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<h1>Error : " + e.getMessage() + "</h1>");
        }
    }
}