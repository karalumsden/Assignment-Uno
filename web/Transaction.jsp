<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Transactions</h1>
        <p></p>
    </div>
</div>


<div class="container border">
    <p class="error"><i>${message}</i></p>

    <h1>Account Balance</h1>
    <p>Please enter in the amount of funds to transfer.</p>

    <form action="transfer" method="post">
        <input type="hidden" name="action" value="transferFunds">
        <div class="form-group">
            <p>Checking:  ${account.aName.getBalance()}</p>
            <p>Savings:  ${account.aName.getBalance()}</p>
            <p>Balance:  ${account.balance}</p>
            
        <div class="form-group form-inline">
            <label class="sr-only" for="transferAmount">Amount (in dollars)</label>
            <div class="input-group">
                <div class="input-group-addon">$</div>
                <input type="text" class="form-control" name="transferAmount" id="transferAmount" placeholder="Amount">
                <div class="input-group-addon">.00</div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Transfer cash</button><br><br>
    </form>

</div> <!-- /container -->          

<c:import url="/includes/footer.jsp" />
