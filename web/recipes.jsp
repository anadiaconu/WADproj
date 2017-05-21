<%@page import="Models.User"%>
<%@page import="Models.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@include file="Header.jsp" %>

    <h3>Our Recipes</h3>
    <c:forEach var="recipe" items="${recipes}">
                <p> ____________________________________________________________________________<br/><br/>
                    <label>Name: &emsp;</label> ${recipe.getName()}<br/>
                    <label>Time: &emsp;</label> ${recipe.getTime()}<br/>
                    <label>Difficulty: &emsp;</label> 
                    <c:if test="${recipe.getDifficulty()==0}">
                        Easy
                    </c:if>
                    <c:if test="${recipe.getDifficulty()==1}">
                        Difficult
                    </c:if>
                    <br/>
                    <label>Ingredients: &emsp;</label> ${recipe.getIngredients()}<br/>
                    <label> <img class="recimg" src="${recipe.getPath()}"/></label><br/><br/>
                    <label>Description: &emsp;</label> ${recipe.getDescription()}<br/><br/>
                    <label>Uploaded by: &emsp;</label> ${recipe.getOwner().getUsername()}<br/>
                        
                
                </p>
                        </c:forEach>


<%@include file="Footer.jsp" %>
