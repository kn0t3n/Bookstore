<%--
  Created by IntelliJ IDEA.
  User: Philipp Schweiger
  Date: 09.03.2018
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Benutzerregistrierung</title>
</head>
<body>
    <form method="post" action="/registrieren">
        Benutzername: <input type="text" name="username">
        Passwort: <input type="password" name="password">
        <input type="submit" value="registrieren">
    </form>

</body>
</html>
