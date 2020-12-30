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
        <title>Resultaat Test Bevestigen</title>
    </head>
    <body>
        <h1>Bevestig Status.</h1>
        <ul>
            <li>Burger: ${requestScope.burger}</li>
            <li>Status: ${requestScope.status}</li>
        </ul>
        <form action="/Contact-Tracing-war/Controller" method="POST">
            <input type="hidden" name="burger" value="${requestScope.burger}" hidden>
            <input type="hidden" name="status" value="${requestScope.status}" hidden>
            <input type="hidden" name="test_id" value="${requestScope.test_id}" hidden>
            <input type="submit" name="submit" value="Annuleer">
            <input type="submit" name="submit" value="Bevestig">
        </form>
    </body>
</html>
