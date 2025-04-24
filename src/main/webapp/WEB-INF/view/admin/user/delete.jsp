<%--
  Created by IntelliJ IDEA.
  User: hungthuhai
  Date: 4/25/2025
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container mt-5">
    <h1>Delete user with id = ${id}</h1>
    <div class="alert alert-danger">ARE YOU SURE?</div>
    <form:form action="/admin/user/delete" method="post" modelAttribute="user">
        <form:input type="hidden" path="id" value="${id}"/>
        <button type="submit" class="btn btn-danger">YES</button>
    </form:form>
    <a href="/admin/user" class="btn btn-success">BACK</a>
</div>
</body>
</html>
