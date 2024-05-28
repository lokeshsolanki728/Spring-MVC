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
<title>User View</title>
<%@include file="Header.jsp"%>
</head>
<body>
	<div align="center" style="padding-top: 60px;">
		<sf:form method="post" modelAttribute="form">
			<c:if test="${form.id>0}">
				<h1 style="color: navy">Update User</h1>
				<br>
			</c:if>
			<c:if test="${form.id==0}">
				<h1 style="color: navy">Add User</h1>
			</c:if>
			<table>
				<tr>
					<th align="left">FirstName : <span style="color: red">*</span></th>
					<td><sf:input path="firstName" /></td>
					<sf:errors path="firstName"></sf:errors>
				</tr>

				<tr>
					<th align="left">LastName : <span style="color: red">*</span></th>
					<td><sf:input path="lastName" /></td>
					<sf:errors path="lastName"></sf:errors>

				</tr>

				<tr>
					<th align="left">LoginId : <span style="color: red">*</span></th>
					<td><sf:input path="loginId" /></td>
					<sf:errors path="loginId"></sf:errors>
				</tr>

				<tr>
					<th align="left">Password : <span style="color: red">*</span></th>
					<td><sf:input path="password" /></td>
					<sf:errors path="password"></sf:errors>
				</tr>

				<tr>
					<th align="left">Dob : <span style="color: red">*</span></th>
					<td><sf:input path="dob" /></td>
					<sf:errors path="dob"></sf:errors>
				</tr>

				<tr>
					<th align="left">Address : <span style="color: red">*</span></th>
					<td><sf:input path="address" /></td>
					<sf:errors path="address"></sf:errors>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="Save">
						<input type="reset" value="Resat"></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>