<%--
  Created by IntelliJ IDEA.
  User: dejvi
  Date: 6/23/2023
  Time: 7:43 PM
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
<h1>New Product</h1>

<p><a href="/">Home</a></p>

    <form:form action="/product/new" method="post" modelAttribute="product">

      <form:label path="name">Name :</form:label>
      <form:input path="name"/>
      <form:errors path="name"/>

      <form:label path="description">Description :</form:label>
      <form:input path="description"/>
      <form:errors path="description"/>

      <form:label path="price">Price :</form:label>
      <form:input path="price"/>
      <form:errors path="price"/>

    <button>Submit!</button>
    </form:form>
</body>
</html>
