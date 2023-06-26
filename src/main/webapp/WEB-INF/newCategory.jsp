<%--
  Created by IntelliJ IDEA.
  User: dejvi
  Date: 6/23/2023
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
<h1>New Category</h1>
<p><a href="/">Home</a></p>


        <form:form action="/category/new" method="post" modelAttribute="category">

            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
            <form:errors path="name"/>

        <button>Submit!</button>

        </form:form>
</body>
</html>
