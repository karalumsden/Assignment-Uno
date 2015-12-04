package toba.transaction;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import toba.business.User;
import toba.data.UserDB;
import toba.account.Account;

public class TransactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Transaction.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "submit";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("submit")) {
            url = "/Transaction.jsp"; 
        } 
        else if (action.equals("transferFunds")) {
            // get parameters from the request
            String transactionAmt = request.getParameter("transferAmount");
            Double amt = Double.parseDouble(transactionAmt);
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String transferFrom = request.getParameter("transferFrom");
            String transferTo = request.getParameter("transferTo");
            
            if (transferFrom.equals("checking")) {
                Account from = user.getChecking();
                Account to = user.getSavings();
                from.debit(amt);
                to.credit(amt);
            } else {
                Account from = user.getSavings();
                Account to = user.getChecking();
                from.debit(amt);
                to.credit(amt);
            }
                        
            // transfer using the credit/debit methods 
            String message;
            if (amt == 0) {
                message = "Please enter in a transfer amount.";
                url = "/Transaction.jsp";
            } else {
                message = "Your transfer was successful.";
                UserDB.update(user);
                url = "/Account_activity.jsp";
            }
            
            session.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
}