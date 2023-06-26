<%--
  Created by IntelliJ IDEA.
  User: dejvi
  Date: 6/23/2023
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Home Page</h1>

<h3><a href="/product/new" >New Product</a></h3>

<h3><a href="/category/new">New Category</a></h3>


    <table>
        <thead>
        <tr>
            <th>Products</th>
            <th>Categories</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <ul>
                    <c:forEach var="product" items="${allProducts}">
                        <li><a href="products/<c:out value="${product.id}"/>"><c:out value="${product.name}"/></a></li>
                    </c:forEach>
                </ul>
            </td>
            <td>
                <ul>
                    <c:forEach var="category" items="${allCategories}">
                        <li><a href="categories/<c:out value="${category.id}"/>"><c:out value="${category.name}"/></a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        </tbody>
    </table>
</body>
</html>
