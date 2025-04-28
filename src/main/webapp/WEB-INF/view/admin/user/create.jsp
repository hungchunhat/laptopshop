<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content="Hỏi Dân IT - Dự án laptopshop"/>
    <meta name="author" content="Hỏi Dân IT"/>
    <title>Dashboard - Hỏi Dân IT</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet"/>
    <link href="/resources/css/styles.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
<jsp:include page="../layout/header.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="../layout/sidenav.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Manager User</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item active">User</li>
                </ol>
            </div>
            <div class="container mt-5">
                <div class="row">
                    <div class="col-lg-6 col-sm-12 mx-auto">
                        <h1 class="my-3">Create User</h1>
                        <hr/>
                        <form:form method="post" action="/admin/user/create" enctype="multipart/form-data"
                                   modelAttribute="newUser">
                            <div class="row">
                                <div class="mb-3 col-6">
                                    <form:label for="Email" class="form-label" path="email">Email address</form:label>
                                    <form:input type="email" class="form-control" id="Email" path="email"
                                                aria-describedby="emailHelp"/>
                                </div>
                                <div class="mb-3 col-6">
                                    <label for="Password" class="form-label">Password:</label>
                                    <form:input type="password" class="form-control" path="password" id="Password"/>
                                </div>
                                <div class="mb-3 col-6">
                                    <label for="Phone" class="form-label">Phone Number:</label>
                                    <form:input type="text" class="form-control" path="phone" id="Phone"/>
                                </div>
                                <div class="mb-3 col-6">
                                    <label for="Name" class="form-label">Full Name:</label>
                                    <form:input type="text" class="form-control" path="fullName" id="Name"/>
                                </div>
                                <div class="mb-3">
                                    <label for="Address" class="form-label">Address:</label>
                                    <form:input type="text" class="form-control" path="address" id="Address"/>
                                </div>
                                <div class="mb-3 col-6">
                                    <label for="role" class="form-label">Role:</label>
                                    <form:select class="form-select" id="role" path="role.name">
                                        <form:option value="ADMIN">ADMIN</form:option>
                                        <form:option value="USER">USER</form:option>
                                    </form:select>
                                </div>
                                <div class="mb-3 col-6">
                                    <label for="avatarFile" class="form-label">Avatar:</label>
                                    <input type="file" class="form-control" name="file" id="avatarFile"
                                           accept=".png,.jpeg,.jpg"/>
                                </div>
                                <div class="mb-3 col-12 d-flex justify-content-center">
                                    <img style="max-height: 250px;display: none;" alt="avatar preview"
                                         id="avatarPreview"/>
                                </div>
                                <div class="mb-3 col-6">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                    <a href="/admin/user" class="btn btn-success">Back</a>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>
<script>
    $(document).ready(() => {
        const avatarFile = $("#avatarFile");
        avatarFile.change(function (e) {
            const imgURL = URL.createObjectURL(e.target.files[0]);
            $("#avatarPreview").attr("src", imgURL).css({"display": "block"});
        });
    });
</script>
<script src="/resources/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="/resources/js/chart-area-demo.js"></script>
<script src="/resources/js/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>
</body>

</html>