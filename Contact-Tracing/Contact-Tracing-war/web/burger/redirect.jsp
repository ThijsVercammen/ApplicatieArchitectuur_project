<%-- 
    Document   : redirect
    Created on : 30-dec-2020, 14:43:17
    Author     : arnog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirect</title>
    </head>
    <body>
        <h1>Hallo, ${pageContext.request.remoteUser}</h1>
        <h2>Je bent succesvol ingelogd, klik op doorgaan om naar de applicatie te gaan.</h2>
        <form method="POST" action="/Contact-Tracing-war/Controller">
            <input type="submit" name="submit" value="Doorgaan">
        </form>
    </body>
</html>
