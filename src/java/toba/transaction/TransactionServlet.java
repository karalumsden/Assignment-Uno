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
        } else if (action.equals("transferFunds")) {
            // get parameters from the request
            String transactionAmt = request.getParameter("transferAmount");
            Double amt = Double.parseDouble(transactionAmt);
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String transferFrom = request.getParameter("transferFrom");
            String transferTo = request.getParameter("transferTo");
            String message = "";

            if (transferFrom.equals("checking")) {                
                Account from = AccountDB.findByUserId(user.getUserId(), "CHECKING");
                Account to = AccountDB.findByUserId(user.getUserId(), "SAVINGS");
                from.debit(amt);
                to.credit(amt);
                AccountDB.update(to);
                AccountDB.update(from);
                url = "/Account_activity.jsp";
            } else if (transferFrom.equals("savings")) {
                Account from = AccountDB.findByUserId(user.getUserId(), "SAVINGS");
                Account to = AccountDB.findByUserId(user.getUserId(), "CHECKING");
                from.debit(amt);
                to.credit(amt);
                AccountDB.update(to);
                AccountDB.update(from);
                url = "/Account_activity.jsp";
            } else if (transferFrom.isEmpty() || transferTo.isEmpty()) {
                message = "Please select which accounts you would like to transfer from and to in order to proceed.";
                url = "/Transaction.jsp";
            } else {
                message = "Please enter a transfer amount.";
                url = "/Transaction.jsp";
            }
        session.setAttribute("user", user);
        request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
