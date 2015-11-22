
package toba.customer;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import toba.data.UserDB;
import toba.business.User;

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
           
                       
            // validate
            String message = "";
            if (firstName == null || lastName == null || phone == null || address == null || city == null || 
                    state == null || zip == null || email == null || firstName.isEmpty() || lastName.isEmpty() || 
                    phone.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || zip.isEmpty() || email.isEmpty()) {
                message = "Please fill out all form fields.";
                url = "/New_customer.jsp";
            }
            else {
                message = "";
                url = "/Success.jsp";
                UserDB.insert(user);
            }
            
          
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}