<%-- 
    Document   : login
    Created on : Apr 23, 2017, 1:28:07 AM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="content">
        <div class="header">
            <img src="./img/companyLogo.jpg" width="100px"  />
            <span class="header-text">COMPANY NAME</span>
        </div>
        <div id="whole">
	<div class="col-2">
	</div>
	<div id="stuff" class="col-8">
        <div class="row">
            <div id="myNiceForm" class="col-12">
            <h1>Login form</h1>   
            <form method="POST" action="loginController">
                
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname">
                </div>
                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">
                </div>
                
                <div class="form-element">
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>  
                      
                    
            </form>
            </div>
            </div>
        </div>
        <div class="col-2">
	</div>
        </div>
    </body>
</html>
