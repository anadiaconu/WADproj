<%-- 
    Document   : login
    Created on : Apr 23, 2017, 1:28:07 AM
    Author     : Diana
--%>

<%@include file="Header.jsp" %>

<form method="post" action="loginController" id="form-submit" data-toggle="validator">
    <h2 class="form-headline">Please Login:</h2>
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="name-label">Username</span>
            <input type="text" maxlength="255" class="form-control" aria-describedby="name-label" name="name" id="name" required>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors"></div>
    </div>
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="password-label">Password</span>
            <input type="password" maxlength="255" class="form-control" aria-describedby="password-label" name="password" id="password" required>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors"></div>
    </div>
    
    <div class="row text-center">
        <button type="submit" class="btn btn-primary" name="send">Login</button>
        <button type="reset" class="btn btn-warning" name="clear">Reset</button>
    </div>
</form>

<%@include file="Footer.jsp" %>
