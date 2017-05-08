
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>WAD proj</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css">
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
        <!-- FONTS-->

        <link href='https://fonts.googleapis.com/css?family=Great+Vibes' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">-->

        <!-- Latest compiled and minified JavaScript -->
        <script src="bootstrap.min.js"></script>
    </head>
    <body>
        <div id="container" >
            <div>
                <img src="./img/welcome.jpg" height="100px">
                <h1 id="main-title">to my cooking blog</h1>
            </div>
            <br>
            <div align="center">
                <a href="login.jsp" class="btn btn-primary btn-sm"> LOGIN</a>
                <a href="Register.jsp" class="btn btn-primary btn-sm"> Register</a>
                <a href="Products.jsp" class="btn btn-primary btn-sm"> View Recipes</a>
                <a href="ShoppingCart.jsp" class="btn btn-primary btn-sm"> My Recipes</a>
                <a href="logoutController" class="btn btn-primary btn-sm"> LOGOUT</a>
            </div>