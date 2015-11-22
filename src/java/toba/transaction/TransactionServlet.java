/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.transaction;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import toba.business.User;
import toba.data.UserDB;
import toba.account.Account;
import toba.account.AccountDB;

public class TransactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Transaction.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "transfer"; // default action
        }

        if (action.equals("transfer")) {
            url = "/Transaction.jsp"; 
        } else if (action.equals("transferFunds")) {
            // get properties
            
            
            
            // store data in object
            Account account = new Account (user, balance, checking, savings);
           
                       
            // validate
            String message = "";
          
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("account", account);
            request.setAttribute("message", message);
        }
        getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
    }
}

