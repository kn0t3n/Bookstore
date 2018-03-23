<%--
  Created by IntelliJ IDEA.
  User: Philipp Schweiger
  Date: 23.03.2018
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bücherliste</title>
</head>
<body>
<h1>Bücherliste</h1>
<p>Ihre Bücher sind:</p>
<table>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>
                    ${book.ISBN}
            </td>
            <td>
                    ${book.title}
            </td>
            <td>
                    ${book.author}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
