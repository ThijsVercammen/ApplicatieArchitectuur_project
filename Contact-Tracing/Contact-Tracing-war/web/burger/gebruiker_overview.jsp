<%-- 
    Document   : gebruiker_overview
    Created on : 3-nov-2020, 16:29:01
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
        <h1>Burger Overview</h1>
        <h2>Hallo ${pageContext.request.remoteUser}</h2>
        
        <c:choose>
            <c:when test = "${sessionScope.notice == 1}">
                <div style="background-color: green; width: 40%; color: white; padding: 20px; font-size: 20px; border-radius: 20px; text-align: center">
                    Jouw testresultaat is beschikbaar!<br>
                    <form action="/Contact-Tracing-war/Controller" method="POST">
                        <input type="submit" name="submit" value="[x] Gelezen">
                    </form>
                </div>
            </c:when>
            <c:when test = "${sessionScope.notice == 2}">
                <div style="background-color: #990033; width: 40%; color: white; padding: 20px; font-size: 20px; border-radius: 20px; text-align: center">
                    Jouw besmettingsrisico is gewijzigd naar hoog!<br>
                    <form action="/Contact-Tracing-war/Controller" method="POST">
                        <input type="submit" name="submit" value="[x] Gelezen">
                    </form>
                </div>
            </c:when>
        </c:choose>
    
        <h2>Menu: </h2>
        <form action="/Contact-Tracing-war/Controller" method="POST">
            <input type="submit" name="submit" value="nieuw contact">
            <br>
            <input type="submit" name="submit" value="nieuwe test">
            <br>
            <input type="submit" name="submit" value="Overzicht contacten">
        </form>
        <h2>Besmettingsrisico</h2>
        <c:choose>
            <c:when test = "${sessionScope.burger.risicostatus.naam == 'Positief'}">
                <div style="background-color: #990033; width: 20%; color: white; padding: 20px; font-size: 20px; border-radius: 20px; text-align: center">
                    <b>HOOG</b><br><br>
                    Vraag zo snel mogelijk een test aan om jouw omgeving te beschermen!<br>
                    <form action="/Contact-Tracing-war/Controller" method="POST">
                        <input style='font-size: 20px' type="submit" name="submit" value="Test Aanvragen">
                    </form>
                </div>
            </c:when>
            <c:when test = "${sessionScope.burger.risicostatus.naam == 'Negatief'}">
                <div style="background-color: green; width: 20%; color: white; padding: 20px; font-size: 20px; border-radius: 20px; text-align: center">
                    <b>LAAG</b>
                </div>
            </c:when>
            <c:otherwise>
                <div style="background-color: #ff9900; width: 20%; color: white; padding: 20px; font-size: 20px; border-radius: 20px; text-align: center">
                    <b>In uitvoering</b>
                </div>
            </c:otherwise>
        </c:choose>
        <br>
        <form action="/Contact-Tracing-war/Controller" method="POST">
            <input type="submit" name="submit" value="Afmelden">
        </form>
    </body>
</html>
