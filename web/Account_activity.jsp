<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Account Activity</h1>
        <c:if test = "${user == null}">
            <p>Hey There! You're not logged in. Don't have an account yet? Sign up!</p>
            <p><a class="btn btn-primary btn-lg" href="New_customer.jsp" role="button">Sign me up! &raquo;</a></p>
        </c:if>
        <c:if test = "${user != null}">
            <p>Howdy ${sessionScope.user.firstName} ${sessionScope.user.lastName}, you are logged in!</p>
        </c:if>
    </div>
</div>

<div class="container">

    <h1>Your Recent Activity</h1>

    <table class="table">
        <tr>
            <th>Date</th>
            <th>Transaction Type</th>
            <th>Amount</th>
        </tr>

        <c:forEach var="item" items="${user.transactionHistory}">
            <tr>
                <td>${item.date}</td>
                <td>${item.type}</td>
                <td>${item.transAmtCurrencyFormat}</td>
            </tr>
        </c:forEach>
    </table>

</div> <!--end of container-->

<c:import url="/includes/footer.jsp" />
