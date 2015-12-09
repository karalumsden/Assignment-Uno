<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Stop being so forgetful would you?</h1>
        <p>We know, we know, your only human.</p>
        <p><a class="btn btn-primary btn-lg" href="index.jsp" role="button">Home &raquo;</a></p>
    </div>
</div>

<div class="container">
    <p class="error"><i>${message}</i></p>
    <form class="form-inline" action="resetpassword" method="post">
        <input type="hidden" name="action" value="resetPassword">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="password" class="col-sm-5 control-label">Enter a new password:</label>
                <div class="col-sm-4">
                     <input type="password" name="password" class="form-control" id="password" value="" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2">
                    <button type="submit" class="btn btn-primary btn-med">Reset</button>
                </div>
            </div>   
    </form>
</div> <!--end of container-->

<c:import url="/includes/footer.jsp" />