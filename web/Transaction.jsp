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
    <div class="table-responsive">
        <table class="table table-hover">
            <caption>Account Balance</caption>
            <tr>
                <th>Checking: $</th><td>${sessionScope.account.checking}</td>
            </tr>
            <tr>
                <th>Savings: $</th><td>${sessionScope.account.savings}</td>
            </tr>
            <tr>
                <th>Balance: $</th><td>${sessionScope.account.balance}</td>
            </tr>
        </table>
        </div>   
  </div> <!-- /container -->          
            <p class="error"><i>${message}</i></p>
            <form class="form-horizontal" action="transfer" method="post">
                <input type="hidden" name="action" value="transfer">
                <div class="form-group">
                    <label for="transferAmount" class="control-label col-sm-2">Transfer Amount</label>
                    <div class="col-sm-4">
                        <input type="text" name="transferAmount" class="form-control" id="transferAmount" value="" placeholder="$0.00"><button type="submit" class="btn btn-primary btn-med">Transfer</button>
                    </div>
                </div>
            </form>

<c:import url="/includes/footer.jsp" />
