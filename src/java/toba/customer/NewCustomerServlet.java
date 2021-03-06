package toba.customer;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;

import toba.business.User;
import toba.data.UserDB;
import toba.account.Account;
import toba.account.AccountDB;
import toba.password.PasswordUtil;

public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/New_customer.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "submit"; // default action
        }

        if (action.equals("submit")) {
            url = "/New_customer.jsp";
        } else if (action.equals("newCustomer")) {
            // get properties
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String email = request.getParameter("email");

            // store data in User object
            User user = new User(firstName, lastName, phone, address, city, state, zip, email);
            Account checking = new Account(user, Account.AccountType.CHECKING, 0.00);
            Account savings = new Account(user, Account.AccountType.SAVINGS, 25.00);

            // validate
            String message = "";
            if (firstName == null || lastName == null || phone == null || address == null || city == null
                    || state == null || zip == null || email == null || firstName.isEmpty() || lastName.isEmpty()
                    || phone.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || zip.isEmpty() || email.isEmpty()) {
                message = "Please fill out all form fields.";
                url = "/New_customer.jsp";
            } else {
                message = "";
                String hashedPassword;
                String salt = "";
                String saltedAndHashedPassword;
                try {
                    salt = PasswordUtil.getSalt();
                    saltedAndHashedPassword = PasswordUtil
                                                .hashPassword(user.getPassword() + salt);
                    user.setSalt(salt);

                } catch (NoSuchAlgorithmException ex) {
                    hashedPassword = ex.getMessage();
                    saltedAndHashedPassword = ex.getMessage();
                }

                user.setPassword(saltedAndHashedPassword);
                url = "/Success.jsp";
                UserDB.insert(user);
                AccountDB.insert(checking);
                AccountDB.insert(savings);
            }

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
