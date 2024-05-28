<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<head>

<meta charset="ISO-8859-1">
<style type="text/css">
hr{
width:100%;
height:5px;
background: navy;
}
</style>
</head>
<body>
<div>
<c:if test="${not empty sessionScope.user}">
<h3>
Hii,
<c:out value="${sessionScope.user.firstName }"></c:out>
<br>
<a href="<c:url value ="/ctl/UserCtl"/>"> Add User</a>|
<a href="<c:url value ="/ctl/UserCtl/Search"/>"> User List</a>|
<a href="<c:url value ="LoginCtl?operation=logout"/>"> Logout</a>|

</h3>
</c:if>

<c:if test="${empty  sessionScope.user}">
<h3>Hii Guest</h3>
<a href="LoginCtl">Login</a> | <a href="WelcomeCtl">Welcome</a>
</c:if>
</div>
<hr>
</body>
</html>