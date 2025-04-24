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
<div class="mt-5">
    <h3 class="text-center">
        User's details
    </h3>
    <hr/>
    <div class="card mx-auto" style="width: 50%;">
        <div class="card-header">
            ${user.fullName}
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Email: ${user.email}</li>
            <li class="list-group-item">Address: ${user.address}</li>
            <li class="list-group-item">Phone: ${user.phone}</li>
        </ul>
    </div>
    <div class="d-flex justify-content-center mt-2">
        <a href="${pageContext.request.contextPath}/admin/user" class="btn btn-success text-center">Back</a>
    </div>
</div>
</body>
</html>
