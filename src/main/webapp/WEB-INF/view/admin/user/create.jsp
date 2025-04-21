<%--
  Created by IntelliJ IDEA.
  User: hungthuhai
  Date: 4/21/2025
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hungdeptrai</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <h1 class="border-bottom my-3">Create User</h1>
    <form>
        <div class="mb-3">
            <label for="InputEmail1" class="form-label">Email address</label>
            <input type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
            <label for="InputPassword1" class="form-label">Password:</label>
            <input type="password" class="form-control" id="InputPassword1">
        </div>
        <div class="mb-3">
            <label for="InputPhone" class="form-label">Phone Number:</label>
            <input type="email" class="form-control" id="InputPhone">
        </div>
        <div class="mb-3">
            <label for="InputName" class="form-label">Full Name:</label>
            <input type="email" class="form-control" id="InputName">
        </div>
        <div class="mb-3">
            <label for="InputAddress" class="form-label">Address:</label>
            <input type="email" class="form-control" id="InputAddress">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
