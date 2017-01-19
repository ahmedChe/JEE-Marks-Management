<%-- 
    Document   : Alert.jsp
    Created on : 11 mai 2016, 22:58:43
    Author     : !l-PazZ0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <br>Vous ne pouvez pas se connecter pour des raisons de sécurité
    <% response.setHeader("Refresh", "30;URL=Authentification.jsp"); %>
    </body>
</html>
