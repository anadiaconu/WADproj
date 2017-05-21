<%@include file="Header.jsp" %>

<form method="post" action="registrationController" name="regform" id="form-submit" data-toggle="validator" role="form">
    <h2 class="form-headline">Register for free:</h2>
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="name-label">Name</span>
            <input type="text" maxlength="255" class="form-control" aria-describedby="name-label" name="name" id="name" required>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors"></div>
    </div>
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="username-label">Username</span>
            <input type="text" maxlength="255" class="form-control" aria-describedby="username-label" name="username" id="username" required>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors">${requestScope.usernameerror}</div>
    </div>
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="email-label">Email</span>
            <input type="email" maxlength="255" class="form-control" aria-describedby="email-label" name="email" id="email" required>
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
    
    <div class="form-group has-feedback">
        <div class="input-group">
            <span class="input-group-addon" id="repassword-label">Re-enter Password</span>
            <input type="password" maxlength="255" class="form-control" aria-describedby="repassword-label" name="repassword" id="repassword" required>
        </div>
        <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        <div class="help-block with-errors"></div>
    </div>
    
    <div class="input-group">
        <label for="gender">Gender:</label>
        <div class="radio-space"><input type="radio" name="gender" id="male" value="male" checked><label for="male">Male</label></div>
        <div class="radio-space"><input type="radio" name="gender" id="female" value="female"><label for="female">Female</label></div>
    </div>
    
    <div class="input-group check-space">
        <input type="checkbox" name="maillist" id="maillist" checked><label for="mailist">I want to subscribe to your newsletter!</label>
    </div>
    
    <div class="row text-center">
        <button type="submit" class="btn btn-success" name="send">Register</button>
        <button type="reset" class="btn btn-warning" name="clear">Reset</button>
    </div>
</form>

<%@include file="Footer.jsp" %>