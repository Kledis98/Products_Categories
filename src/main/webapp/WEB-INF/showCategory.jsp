<%--
  Created by IntelliJ IDEA.
  User: dejvi
  Date: 6/23/2023
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><c:out value="${category.name}"></c:out> </h1>
<p><a href="/">Home</a></p>


<h3>Products:</h3>
<ul>
    <c:forEach var="product" items="${assignedProducts}">
        <li><c:out value="${product.name}"></c:out></li>
    </c:forEach>
</ul>
<hr>
<form action="/categories/${id}" method="post">
    <h4>Add Product:</h4>
    <select name="productId" id="productId" class="input">
        <c:forEach var="product" items="${unassignedProducts}">
            <option value="${product.id}">${product.name}</option>
        </c:forEach>
    </select>
    <button>Submit</button>
</form>



</body>
</html>
