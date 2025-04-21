<%--
  Created by IntelliJ IDEA.
  User: hungthuhai
  Date: 4/21/2025
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>hungdeptrai</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-lg-6 col-sm-12 mx-auto">
            <h1 class="border-bottom my-3">Create User</h1>
            <form:form method="post" action="/admin/user/create" modelAttribute="newUser">
                <div class="mb-3">
                    <form:label for="Email" class="form-label" path="email">Email address</form:label>
                    <form:input type="email" class="form-control" id="Email" path="email" aria-describedby="emailHelp"/>
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="Password" class="form-label">Password:</label>
                    <form:input type="password" class="form-control" path="password" id="Password"/>
                </div>
                <div class="mb-3">
                    <label for="Phone" class="form-label">Phone Number:</label>
                    <form:input type="email" class="form-control" path="phone" id="Phone"/>
                </div>
                <div class="mb-3">
                    <label for="Name" class="form-label">Full Name:</label>
                    <form:input type="email" class="form-control" path="fullName" id="Name"/>
                </div>
                <div class="mb-3">
                    <label for="Address" class="form-label">Address:</label>
                    <form:input type="email" class="form-control" path="address" id="Address"/>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
