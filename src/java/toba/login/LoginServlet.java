package toba.login;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.business.User;
import toba.data.UserDB;
import toba.password.PasswordUtil;

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
            User actualUser = UserDB.selectUser(username);
            String saltedPwd = "";
            try {
                saltedPwd = PasswordUtil.hashPassword(password + actualUser.getSalt());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (username.equals(actualUser.getUsername()) 
                    && saltedPwd.equals(actualUser.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", actualUser);
                url = "/index.jsp";
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
