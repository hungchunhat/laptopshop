<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
                <h1 class="mt-4">Manager Product</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item active">Product</li>
                </ol>
            </div>
            <div class="container mt-5">
                <div class="row">
                    <div class="col-lg-6 col-sm-12 mx-auto">
                        <h1 class="my-3">Update Product</h1>
                        <hr/>
                        <form:form method="post" action="/admin/product/update" enctype="multipart/form-data"
                                   modelAttribute="product">
                            <div class="row">
                                <form:input type="hidden" class="form-control" path="id"/>
                                <div class="mb-3 col-6">
                                    <c:set var="nameErr">
                                        <form:errors path="name" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <form:label for="name" class="form-label" path="name">Name:</form:label>
                                    <form:input type="text" class="form-control ${not empty nameErr?'is-invalid':''}"
                                                id="name" path="name"/>
                                        ${nameErr}
                                </div>
                                <div class="mb-3 col-6">
                                    <c:set var="priceErr">
                                        <form:errors path="price" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label for="price" class="form-label">Price:</label>
                                    <form:input type="text" class="form-control ${not empty priceErr?'is-invalid':''}"
                                                path="price" id="price"/>
                                        ${priceErr}
                                </div>
                                <div class="mb-3 col-12">
                                    <c:set var="detailDescErr">
                                        <form:errors path="detailDesc" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label for="Detail" class="form-label">Detail Description:</label>
                                    <form:textarea class="form-control ${not empty detailDescErr?'is-invalid':''}"
                                                   path="detailDesc" id="Detail"/>
                                        ${detailDescErr}
                                </div>
                                <div class="mb-3 col-6">
                                    <c:set var="shortDescErr">
                                        <form:errors path="shortDesc" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label for="shortDesc" class="form-label">Short Description</label>
                                    <form:input type="text"
                                                class="form-control ${not empty shortDescErr?'is-invalid':''}"
                                                path="shortDesc" id="shortDesc"/>
                                        ${shortDescErr}
                                </div>
                                <div class="mb-3 col-6">
                                    <c:set var="quantityErr">
                                        <form:errors path="quantity" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label for="quantity" class="form-label">Quantity:</label>
                                    <form:input type="text"
                                                class="form-control ${not empty quantityErr?'is-invalid':''}"
                                                path="quantity" id="quantity"/>
                                        ${quantityErr}
                                </div>
                                <div class="mb-3 col-6">
                                    <c:set var="factoryErr">
                                        <form:errors path="factory" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label for="factory" class="form-label">Factory:</label>
                                    <form:select class="form-select ${not empty factoryErr?'is-invalid':''}"
                                                 id="factory" path="factory">
                                        <form:option value="APPLE">Apple</form:option>
                                        <form:option value="ASUS">Asus</form:option>
                                        <form:option value="LENOVO">Lenovo</form:option>
                                        <form:option value="DELL">Dell</form:option>
                                        <form:option value="LG">LG</form:option>
                                        <form:option value="ACER">Acer</form:option>
                                    </form:select>
                                        ${factoryErr}
                                </div>
                                <div class="mb-3 col-6">
                                    <c:set var="targetErr">
                                        <form:errors path="target" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label for="target" class="form-label">Target:</label>
                                    <form:select class="form-select ${not empty targetErr?'is-invalid':''}" id="target"
                                                 path="target">
                                        <form:option value="GAMING">Gaming</form:option>
                                        <form:option value="SINHVIEN-VANPHONG">Sinh viên - văn phòng</form:option>
                                        <form:option value="THIET-KE-DO-HOA">Thiết kế đồ họa</form:option>
                                        <form:option value="MONG-NHE">Mỏng nhẹ</form:option>
                                        <form:option value="DOANH-NHAN">Doanh nhân</form:option>
                                    </form:select>
                                        ${targetErr}
                                </div>
                                <div class="mb-3 col-12">
                                    <label for="avatarFile" class="form-label">Image:</label>
                                    <input type="file" class="form-control" name="file" id="avatarFile"
                                           accept=".png,.jpeg,.jpg"/>
                                </div>
                                <div class="mb-3 col-12 d-flex justify-content-center">
                                    <img style="max-height: 250px;display: none;" alt="avatar preview"
                                         id="avatarPreview"/>
                                </div>
                                <div class="mb-3 col-6">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                    <a href="/admin/product" class="btn btn-success">Back</a>
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
        const orgImg = "${product.image}";
        if(orgImg){
            $("#avatarPreview").attr("src", '/images/product/' + orgImg).css({"display": "block"});
        }
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