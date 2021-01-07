<%-- 
    Document   : arts_overview
    Created on : 17-nov-2020, 14:12:45
    Author     : Thijs Vercammen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overview</title>
    </head>
    <body>
        <h1>Arts Overview</h1>
        <c:if test="${requestScope.error != null}">
            <p style="color: red;">${requestScope.error}</p>
        </c:if>
        <form method="POST" action="/Contact-Tracing-war/Controller">
            <label>Test ID:</label>
            <input name="test_id" type="number">
            <br>
            <label>Status :</label>
            <select name="status">
                <option value="Positief">Positief</option>
                <option value="Negatief">Negatief</option>
            </select>
            <br>
            <input type="submit" name="submit" value="Voeg test toe">
        </form>
        <br>
        <form action="/Contact-Tracing-war/Controller" method="POST">
            <input type="submit" name="submit" value="Afmelden">
        </form>
    </body>
</html>
