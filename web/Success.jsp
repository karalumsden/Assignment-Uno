<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        
        <c:if test = "${sessionScope.user.firstName == null}">
        <h1>What? No Account?</h1>
        <p>Hey There! You don't have an account yet. Sign up!</p>
        <p><a class="btn btn-primary btn-lg" href="New_customer.jsp" role="button">Sign me up! &raquo;</a></p>
        </c:if>
        <c:if test = "${user != null}">
            <h1>Hooray!</h1>
        <p>${sessionScope.user.firstName}, your account has officially been created!</p>
        </c:if>
        
      </div>
    </div>

    <div class="container border">
     <div class="table-responsive">
      <table class="table table-hover">
          <caption>Please make sure all information below is accurate.</caption>
          <tr>
              <th>First Name: </th><td>${sessionScope.user.firstName}</td>
          </tr>
          <tr>
              <th>Last Name: </th><td>${sessionScope.user.lastName}</td>
          </tr>
          <tr>
              <th>Phone: </th><td>${sessionScope.user.phone}</td>
          </tr>
          <tr>
              <th>Address: </th><td>${sessionScope.user.address}</td>
          </tr>
          <tr>
              <th>City: </th><td>${sessionScope.user.city}</td>
          </tr>
          <tr>
              <th>State: </th><td>${sessionScope.user.state}</td>
          </tr>
          <tr>
              <th>Zip: </th><td>${sessionScope.user.zip}</td>
          </tr>
          <tr>
              <th>Email: </th><td>${sessionScope.user.email}</td>
          </tr>
          <tr>
              <th>Username: </th><td>${sessionScope.user.username}</td>
          </tr>
          <tr>
              <th>Password: </th><td>${sessionScope.user.password}</td>
          </tr>
     </table>
     </div>
    </div> <!-- /container -->
      
<c:import url="/includes/footer.jsp" />
