<%-- 
    Document   : gebruiker_overview
    Created on : 3-nov-2020, 16:29:01
    Author     : Thijs Vercammen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url var="nieuw_contact" value="Controller" scope="session">
            <c:param name="submit" value="nieuw_contact"/>
        </c:url>
        <c:url var="test_aanvragen" value="Controller" scope="session">
            <c:param name="submit" value="test_aanvragen"/>
        </c:url>
        <title>Overview</title>
    </head>
    <body>
        <h1>Burger Overview</h1>
        <!--h1>Goedendag ${sessionScope.burger.naam}</h1>
        <h2>Menu: </h2>
        <ul>
            <li><a href="${nieuw_contact}">nieuw contact</a></li>
            <li><a href="${test_aanvragen}">niewe test aanvragen</a></li>
        </ul>
        <h2>Besmettings risico</h2>
        <p>uw huidig besmettingsrisico is: ${sessionScope.burger.risicostatus.naam}</p-->
    </body>
</html>
