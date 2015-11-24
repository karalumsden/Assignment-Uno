package toba.transaction;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import toba.business.User;
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
            String transferAmount = request.getParameter("transferAmount");
            Double amt = Double.parseDouble(transferAmount);
            
            // retrieve account objects for the user using Account DB????
            // how to get and define the user?
            Transaction transaction = new Transaction();
            
            // transfer using the credit/debit methods 
            String message;
            if (transferAmount == null || transferAmount.isEmpty()) {
                message = "Please enter in a transfer amount.";
                url = "/Transaction.jsp";
            }
            else if (amt < 0) {
                message = "Your debit transfer was successful.";
                url = "/Account_activity.jsp";
                // Can't figure out how to pass amt to the method keep getting an error?
                // I don't understand how to pass the type that the user selected a checkbox for?
                // Account.debit(amt);
                // AccountDB.insert(checking, savings);
                // Transaction.setTransactionItems(transaction);
                // Transaction.setTransactionDate(Transaction.getTransactionDate());
            } else {
                message = "Your credit transfer was successful.";
                url = "/Account_activity.jsp";
                // Can't figure out how to pass amt to the method keep getting an error?
                // I don't understand how to pass the type that the user selected a checkbox for?
                // AccountDB.credit();
                // AccountDB.insert(checking, savings);
                // Transaction.setTransactionItems(transaction);
                // Transaction.setTransactionDate(Transaction.getTransactionDate());
            }
            
            
            HttpSession session = request.getSession();
            // session.setAttribute("user", user);
            // session.setAttribute("account", checking);
            // session.setAttribute("account", savings);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
}