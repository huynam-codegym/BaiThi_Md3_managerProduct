<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/8/2021
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%--Thử cho bootstraps vào nhưng chưa xử lý được--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>--%>
<%--<head>--%>
<%--    <title>Thêm mới sản phẩm vào </title>--%>
<%--    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">--%>
<%--    <style>--%>
<%--        .create{--%>
<%--            margin-top: 75px;--%>
<%--            max-height: 600px;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<nav class="navbar navbar-dark bg-dark fixed-top">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand btn btn-outline-info" href="/products">Thoát ra ngoài</a>--%>

<%--    </div>--%>
<%--</nav>--%>


<%--<div class="create col-sm-5  border border-secondary border-5 rounded">--%>
<%--    <p>${message}</p>--%>
<%--    <form method="post">--%>
<%--        <input name="name"  class="form-control" type="text" placeholder=" nhập tên sản phẩm">--%>
<%--        <input name="price" class="form-control"  type="text" placeholder="giá sản phậm">--%>
<%--        <input name="quantity" class="form-control"  type="text" placeholder="số lượng sản phậm">--%>
<%--        <input name="color" class="form-control"  type="text" placeholder="màu sắc sản phẩm">--%>
<%--        <input name="description" class="form-control"  type="text" placeholder="thông tin sản phẩm">--%>
<%--        <select name="categoryId" class="form-select">--%>
<%--            <c:forEach items="${categoryList}" var="category">--%>
<%--                <option value="${category.id}">${category.name}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--        <button  class="btn btn-danger" type="submit"> Add </button>--%>
<%--    </form>--%>

<form method="post">
    <h3>Add new product</h3>
    <label>Name</label>
    <br>
    <input type="text" name="name">
    <br>
    <label>Price</label>
    <br>
    <input type="text" name="price">
    <br>
    <label>Quantity</label>
    <br>
    <input type="text" name="quantity">
    <br>
    <label>Color</label>
    <br>
    <input type="text" name="color">
    <br>
    <label>Description</label>
    <br>
    <input type="text" name="description">
    <br>
    <label>Category</label>
    <br>
    <select name="category">
        <br>
        <c:forEach items="${categories}" var="category">
            <option value="${category.name}">${category.name}</option>
        </c:forEach>
    </select>
    <br>
    <button>Create</button>
    |<a href="/products">Back</a>
</form>


</div>
</body>
</html>
