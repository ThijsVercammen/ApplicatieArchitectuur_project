<%-- 
    Document   : loginError
    Created on : 17-nov-2020, 13:21:28
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
        <h1>Login Error Page</h1>
        <p>Kan niet inloggen met gegeven gebruikersnaam en wachtwoord.</p>
        <form action="/Contact-Tracing-war/Controller" method="POST">
            <input type="submit" name="submit" value="Terug naar startpagina">
        </form>
    </body>
</html>
