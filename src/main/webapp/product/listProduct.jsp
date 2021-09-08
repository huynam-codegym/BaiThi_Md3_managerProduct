<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/8/2021
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
  <a href="/products?action=create">Add new product</a>
  <input type="hidden" name="action" value="search">
  <input type="text" name="name">
  <button>Search</button>
  <table border="1px solid black">
    <tr>
      <td colspan="7">Product list</td>
    </tr>
    <tr>
      <td>#</td>
      <td>Product Name</td>
      <td>Price</td>
      <td>Quantity</td>
      <td>Color</td>
      <td>Category</td>
      <td>Action</td>
    </tr>
    <c:forEach items="${products}" var="product">
      <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.quantity}</td>
        <td>${product.color}</td>
        <td><c:forEach items="${categories}" var="category">
          <c:if test="${product.categoryId == category.id}">
            ${category.name}
          </c:if>
        </c:forEach> </td>
        <td><a href="/products?action=edit&id=${product.id}">Edit</a>|<a href="/products?action=delete&id=${product.id}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</form>

</body>
</html>
