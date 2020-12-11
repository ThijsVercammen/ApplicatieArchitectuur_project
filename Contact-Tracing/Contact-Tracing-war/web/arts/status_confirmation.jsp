<%-- 
    Document   : status_confirmation
    Created on : 11-dec-2020, 16:41:11
    Author     : Thijs Vercammen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bevestig Status.</h1>
        <ul>
            <li>Burger: ${sessionScope.burger}</li>
            <li>Status: ${sessionScope.status}</li>
        </ul>
        <form action="/Contact-Tracing-war/Controller" method="POST">
            <input type="submit" name="submit" value="Anuleer">
            <input type="submit" name="submit" value="Bevestig">
        </form>
    </body>
</html>
