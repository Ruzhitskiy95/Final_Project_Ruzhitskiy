<%--
  Created by IntelliJ IDEA.
  User: Николай
  Date: 17.08.2022
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table,td,tr,th {
        border: blue 2px solid;
        padding: 5px;
    }
</style>
<body>
<div>
    <h1>System User ${userName}</h1>
</div>
<div>
    <table>
        <tr>
            <td>User Id</td>
            <td>User Name</td>
            <td>User Surname</td>
            <td>Birth date</td>
            <%--            <td>Gender</td>--%>
            <td>Is Deleted</td>
        </tr>
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.surName}</td>
                <td><fmt:formatDate value="${user.birthDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${user.isDeleted}</td>
                <td>
                    <button>Edit</button>
                </td>
                <td>
                    <button>Delete</button>
                </td>
            </tr>
    </table>
</div>
</body>
</html>
