<%-- 
    Document   : homePage
    Created on : 16-Oct-2021, 9:50:19 PM
    Author     : liamm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        
            <h1>Home Page</h1>
            <p><b>Hello ${user.name}.</b></p>
            <a href="/login?logout">Log Out</a>
        
    </body>
</html>
