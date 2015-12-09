<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>New Customer Form</h1>
        <p>Because we think you're cool so we want to know more about you.</p>
    </div>
</div>

<div class="container formpadding">
    <p class="error"><i>${message}</i></p>
    <form class="form-horizontal" action="newcustomer" method="post">
        <input type="hidden" name="action" value="newCustomer">
        <div class="form-group">
            <label for="firstName" class="control-label col-sm-2">First Name</label>
            <div class="col-sm-4">
                <input type="text" name="firstName" class="form-control" id="firstName" value="${user.firstName}" placeholder="First name">
            </div>
        </div>
        <div class="form-group">
            <label for="lastName" class="control-label col-sm-2">Last Name</label>
            <div class="col-sm-4">
                <input type="text" name="lastName" class="form-control" id="lastName" value="${user.lastName}" placeholder="Last name">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="control-label col-sm-2">Phone</label>
            <div class="col-sm-4">
                <input type="tel" name="phone" class="form-control" id="phone" value="${user.phone}" placeholder="000-000-0000">
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="control-label col-sm-2">Address</label>
            <div class="col-sm-4">
                <input type="text" name="address" class="form-control" id="address" value="${user.address}" placeholder="Address">
            </div>
        </div>
        <div class="form-group">
            <label for="city" class="control-label col-sm-2">City</label>
            <div class="col-sm-4">
                <input type="text" name="city" class="form-control" id="city" value="${user.city}" placeholder="City">
            </div>
        </div>
        <div class="form-group">
            <label for="state" class="control-label col-sm-2">State</label>
            <div class="col-sm-4">
                <input type="text" name="state" class="form-control" id="state" value="${user.state}" placeholder="ST">
            </div>
        </div>
        <div class="form-group">
            <label for="zip" class="control-label col-sm-2">Zip</label>
            <div class="col-sm-4">
                <input type="text" name="zip" class="form-control" id="zip" value="${user.zip}" placeholder="00000">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="control-label col-sm-2">Email</label>
            <div class="col-sm-4">
                <input type="email" name="email" class="form-control" id="email" value="${user.email}" placeholder="first.last@domain.com">
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-med">Submit</button>
    </form>
</div>

<c:import url="/includes/footer.jsp" />
