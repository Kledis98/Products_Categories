<%--
  Created by IntelliJ IDEA.
  User: dejvi
  Date: 6/23/2023
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<h1><c:out value="${product.name}"></c:out> </h1>
<p><a href="/">Home</a></p>

<ul>
    <c:forEach var="category" items="${assignedCategories}">
        <li><c:out value="${category.name}"></c:out></li>
    </c:forEach>

    <form:form action="/products/${id}" method="post">
        <h4>Add Category:</h4>
        <select name="categoryId" id="categoryId">
            <c:forEach var="category" items="${unassignedCategories}">
                <option value="${category.id}">${category.name}</option>

            </c:forEach>

        </select>

        <button>Submit</button>
    </form:form>
</ul>

</body>
</html>
