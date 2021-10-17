/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author liamm
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //logout of user
        String logout = request.getParameter("logout");

        if (logout != null) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("errorMsg", "Logged out now!");
            System.out.println("Logged out now!");
        }
        if (session.getAttribute("username") != null) {
            response.sendRedirect("home");
            return;

        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //process submission of form
        //validate data first
        HttpSession session = request.getSession();
        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !username.equals("") && password != null && !password.equals("")) {
            //pass info into login
            user = new AccountService().login(username, password);
        }
        //store username in session if NN
        if (user != null) {
            session.setAttribute("username", user.getUsername());
            //redirect user to home url
            response.sendRedirect("home");
            return;
        } else {
            //if invlaid display an appropriate error msg also keep txtboxes filled in
            session.setAttribute("errorMsg", "Invalid Credentials");
            response.sendRedirect("login");
            return;
        }

    }

}
