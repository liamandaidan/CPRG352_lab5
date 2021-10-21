<%-- 
    Document   : login
    Created on : 20-Oct-2021, 8:21:51 PM
    Author     : liamm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Inventory Login</title>
    </head>
    <body>
        <h1>Home Inventory</h1>
        <h2>Login</h2>
        <form action="login" method="POST">
            <label>User name:</label>
            <input type="text" value="" name="username"><br>
            <label>Password:</label>
            <input type="text" value="" name="password"><br>
            <input type="submit">
        </form> 
        <p>${errorMsg}</p>
    </body>
</html>
