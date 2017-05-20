<%@page import="Models.User"%>
<%@page import="Models.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@include file="Header.jsp" %>

    <div>
            <table>
                        <tr>
                            <td>Name</td>
                            <td>Difficulty</td>
                            <td>Time</td>                            
                            <td></td>
                            <td>Description</td>
                            
                        </tr>
                        <c:forEach var="rec" items="${applicationScope.recipes.values()}">
                            <tr>
                                <td>${rec.getName()}</td>
                                <td>${rec.getDifficulty()}</td>
                                <td>${rec.getTime()}</td>
                                <td>${rec.getPath()}</td>
                                <td>${rec.getDescription()}</td>
                             </tr>  
                        </c:forEach>


<%@include file="Footer.jsp" %>
