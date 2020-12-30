<%-- 
    Document   : risico
    Created on : 18-nov-2020, 15:15:08
    Author     : Thijs Vercammen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Huidig Risico</title>
    </head>
    <body>
        <h1>Risico Pagina</h1>
        <h2>Huidig Risico: ${sessionScope.risico}</h2>
        <c:if test="${sessionScope.risico == 'ROOD'}">
            <form action="/Contact-Tracing-war/Controller" method="POST">
                <input type="submit" name="submit" value="nieuwe test">
                <br>
            </form>
        </c:if>
        <h3>Nauwe Contacten: ${sessionScope.aantnauw}</h3>
        <table>
            <tr>
                <th>Naam</th>
                <th>Soort Contact</th>
            </tr>
            <c:forEach var="c" items="${sessionScope.nauw}">
                <tr>
                    <td>${c.contact.naam}</td>
                    <td>${c.soortContact}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <h3>Gewone Contacten: ${sessionScope.aantgewoon}</h3>
        <table>
            <tr>
                <th>Naam</th>
                <th>Soort Contact</th>
            </tr>
            <c:forEach var="c" items="${sessionScope.gewoon}">
                <tr>
                    <td>${c.contact.naam}</td>
                    <td>${c.soortContact}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <h3>Veilige Contacten: ${sessionScope.aantveilig}</h3>
        <table>
            <tr>
                <th>Naam</th>
                <th>Soort Contact</th>
            </tr>
            <c:forEach var="c" items="${sessionScope.veilig}">
                <tr>
                    <td>${c.contact.naam}</td>
                    <td>${c.soortContact}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action="/Contact-Tracing-war/Controller" method="POST">
            <input type="submit" name="submit" value="Overzicht">
        </form>
    </body>
</html>
