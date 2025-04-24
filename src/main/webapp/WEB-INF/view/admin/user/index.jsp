<%@ page import="com.example.laptopshop.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="d-flex justify-content-between mb-1">
        <h3>User Table</h3>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/user/create"><b>Create User</b></a>
    </div>
    <hr/>
    <div>
        <table class="table table-hover table-bordered table-striped">
            <thead>
            <tr>
                <th>Id:</th>
                <th>Email:</th>
                <th>Full Name:</th>
                <th>Action:</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.fullName}</td>
                    <td>
                        <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                        <a href="/admin/user/update/${user.id}" class="btn btn-warning">Update</a>
                        <a href="" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
