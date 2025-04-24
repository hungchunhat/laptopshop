<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <%--    <link rel="stylesheet" href="/css/demo.css">--%>
</head>
<body>
<h1>Hello World from jsp!!</h1>
<h1>
    <%= (new java.util.Date().toString())%>

</h1>
<h2>
</h2>

<p>
    ${hungdeptrai}
</p>
<p>
    ${hungdeptrai2}
</p>
<a class="btn btn-primary ms-2" href="admin/user">hello, let's go to user's list</a>
</body>
</html>