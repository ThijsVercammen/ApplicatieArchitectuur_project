<%-- 
    Document   : index
    Created on : 3-nov-2020, 9:45:42
    Author     : Thijs Vercammen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Contact-Tracing Covid-19</h1>
        <h2>Gelieve u hieronder aan te melden voor u verder gaat.</h2>
        <form action="Controller" method="POST">
            <label for="rol">Ik wil inloggen als: </label>
            <select id="rol" name="rol">
                <option value="burger">Burger</option>
                <option value="arts">Arts</option>
            </select>
            <br/>
            <label for="gebruikersnaam">Gebruikersnaam: </label>
            <input type="text" id="gebruikersnaam" name="gebruikersnaam">
            <br>
            <label for="wachtwoord">Wachtwoord </label>
            <input type="password" id="wachtwoord" name="wachtwoord">
            <br>
            <input type="submit" name="submit" value="Meld aan">
        </form>
    </body>
</html>
