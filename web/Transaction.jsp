<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Ready to make a transfer?</h1>
        <c:if test = "${user == null}">
            <p>Hey There! You're not logged in. You can't transfer money until we know who you are!</p>
            <p><a class="btn btn-primary btn-lg" href="New_customer.jsp" role="button">Login</a></p>
        </c:if>
        <c:if test = "${user != null}">
            <p>Howdy ${sessionScope.user.firstName} ${sessionScope.user.lastName}, you are logged in!</p>
        </c:if>
        <p></p>
    </div>
</div>


<div class="container border">
    <p class="error"><i>${message}</i></p>

    <h1>Transfer Funds</h1>
    <p>Please enter in the amount of funds to transfer.</p>

    <form action="transfer" method="post">
        <input type="hidden" name="action" value="transferFunds">
        <div class="form-group">
            <p>Checking:  ${checking.balance}</p>
            <p>Savings:  ${savings.balance}</p>

            <div class="form-group form-inline">
                Transfer from:
                <select name="transferFrom" class="form-control">
                    <option value="checking">Checking</option>
                    <option value="savings">Savings</option>
                </select>
                Transfer to:
                <select name="transferTo" class="form-control">
                    <option value="checking">Checking</option>
                    <option value="savings">Savings</option>
                </select>
                <label class="sr-only" for="transferAmount">Amount (in dollars)</label>
                <div class="input-group">
                    <div class="input-group-addon">$</div>
                    <input type="text" class="form-control" name="transferAmount" placeholder="Amount">
                    <div class="input-group-addon">.00</div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Transfer cash</button><br><br>
            </form>
        </div>

</div> <!-- /container -->          

<c:import url="/includes/footer.jsp" />
