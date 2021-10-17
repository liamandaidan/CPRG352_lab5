<%-- 
    Document   : loginPage
    Created on : 16-Oct-2021, 9:50:09 PM
    Author     : liamm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <label for="username">Username: </label>
            <input type="text" name="username" value=""><br>
            <label for="password">Password: </label>
            <input type="text" name="password" value=""><br>
            <input type="submit" value="Log in"><br>
        </form>
    </body>
</html>
