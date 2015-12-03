package toba.transaction;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import toba.business.User;
import toba.data.UserDB;
import toba.account.Account;
import toba.account.AccountDB;
import toba.transaction.Transaction;

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
            String transferFrom = request.getParameter("transferFrom");
            String transferTo = request.getParameter("transferTo");
            Date date = new Date();
            
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Account account = (Account) session.getAttribute("account");
            Transaction transaction = new Transaction(user, account, amt, date);
            
            // transfer using the credit/debit methods 
            String message;
            if (amt == 0) {
                message = "Please enter in a transfer amount.";
                url = "/Transaction.jsp";
            }
            else if (amt < 0) {
                message = "Your debit transfer was successful.";
                url = "/Account_activity.jsp";
                account.debit(amt);
                
            } else {
                message = "Your credit transfer was successful.";
                url = "/Account_activity.jsp";
                account.credit(amt);
            }
            session.setAttribute("user", user);
            session.setAttribute("account", account);
            session.setAttribute("transaction", transaction);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
}