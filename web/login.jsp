<%-- 
    Document   : login
    Created on : Apr 23, 2017, 1:28:07 AM
    Author     : Diana
--%>

<%@include file="Header.jsp" %>
    <div class="login-form">
        <form method="post" action="loginController" id="form-submit">
            <h3>Login form</h3>
            <br>
            <label for="username">Username</label>
                
                <input type="text" id="name" name="name" placeholder="Enter Name" onchange='isAlphabet()' onfocus='onFocName()' required aria-required="true" aria-describedby="name-format"/> 
            <br>
            <label for="password">Password</label>
               
                <input type="password" id="password" name="password" placeholder="Enter password" onchange='isAlphabet()' onfocus='passCheck()' required aria-required="true"/> 
            <br>
            <input type="submit" value="Submit" name="send" class="btn btn-default btn-sm">
            <input type="reset" value="Reset" name="clear" class="btn btn-default btn-sm">
        </form>
    </div>


   
<%@include file="Footer.jsp" %>
