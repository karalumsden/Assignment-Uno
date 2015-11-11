package toba.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/login.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "login"; // default action
        }

        if (action.equals("login")) {
            url = "/login.html"; // the login page
        } else if (action.equals("loginUser")) {
            // get username and password
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Validate!
            if (username.equals("jsmith@toba.com") && password.equals("letmein")) {
                url = "/Account_activity.jsp";
            } else {
                url = "/Login_failure.jsp";
            }
            
            getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
