<%@page import="Models.User"%>
<%@page import="Models.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@include file="Header.jsp" %>

    <div>
        <script type="text/javascript" src="script.js"></script>
            <h3>My Recipes</h3>
              <c:forEach var="recipe" items="${recipes}">
                <p> ----------------------------------------------------<br/>
                    <label>Name: &emsp;</label> ${recipe.getName()}<br/>
                    <label>Time: &emsp;</label> ${recipe.getTime()}<br/>
                    <label>Difficulty: &emsp;</label> ${recipe.getDifficulty()}<br/>
                    <label> <img src=${recipe.getPath()}/><br/>
                    <label>Description: &emsp;</label> ${recipe.getDescription()}<br/>
                        
                
                </p>
            </c:forEach>

    </form>

<%@include file="Footer.jsp" %>
