<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
--><%-- 
    Document   : register
    Created on : Mar 13, 2017, 10:21:09 AM
    Author     : Ana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div id="content">
        <div class="header">
            <img src="./img/companyLogo.jpg" width="100px"  />
            <span class="header-text">COMPANY NAME</span>
        </div>
        <!-- <//%=request.getServletContext().getAttribute("nav")%> -->
            <h1>Registration form</h1>   
         <!--  <form method="post" action="registrationController"> -->
                <div class="form-element">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" size="40">
                </div>
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname">
                </div>
                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">
                </div>
                <div class="form-element">
                    <label for="rPassword">Repeat password</label>
                    <input type="password" id="rPassword">
                </div>
                <div class="form-element">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email">
                </div>
                <div class="form-element">
                    <label for="gender">Gender</label>
                    Male<input type="radio" name="gender" value="male"> 
                    Female<input type="radio" name="gender" value="female"> 
                </div>
                <div class="form-element">
                    <label for="spam">Subscribe to maillist</label>
                    <input type="checkbox" name="spam" id="spam">
                </div> 
                  <div class="form-element">
                      <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>  
                      
                    
            </form>
        </div>
    </body>
</html>

