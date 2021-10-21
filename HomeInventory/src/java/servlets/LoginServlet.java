/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author liamm
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userValidType = null;
        if (username != null && !username.equals("") && password != null && !password.equals("")) {
            userValidType = userValidate(username, password);
            if (userValidType.equals("admin")) {
                response.sendRedirect("admin");
            }else if(userValidType.equals("user")){
                response.sendRedirect("inventory");
            }
            
        } else {
            request.setAttribute("errorMsg", "Invalid Login.");
            response.sendRedirect("login");
        }
        
    }

    /*
    We will check to see if the username and password are valid. If so return the level of user.
    Admin or User.
    If not return null;
     */
    private String userValidate(String username, String password) throws FileNotFoundException, IOException {

        //read in from txt file
        String path = getServletContext().getRealPath("/WEB-INF/users.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String content = br.readLine();
        String[] params = new String[2];
        while (content != null) {
            params = content.split(",");
            if (params[0].equals(username) && params[1].equals(password)) {
                if (params[0].equals("admin")) {
                    return "admin";
                } else {
                    return "user";
                }
            }
            content = br.readLine();
        }
        return null;
    }
    
}
