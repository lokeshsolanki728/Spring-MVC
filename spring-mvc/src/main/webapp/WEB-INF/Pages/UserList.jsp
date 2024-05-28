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
<title>UserList</title>
<%@include file="Header.jsp"%>
</head>
<body>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">User List</h1>
			<c:if test="${not empty list }">
				<h3 style="color: red">
					<c:if test="${not empty deletemsg }">
						<c:out value="${deletemsg}"></c:out>
					</c:if>
				</h3>
				<table>
					<tr>
						<th>FirstName</th>
						<td><sf:input path="firstName" /> <input type="submit"
							name="operation" value="search"></td>
					</tr>
				</table>
		</div>
		<sf:hidden path="pazeNo" />
		<%
			int index = 1;
		%>
		<table class="table table-bordered table-info table-hover">
			<tr align="center">
				<th>S.No</th>
				<th>Select</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>Dob</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr align="center">
					<td><%=index++%></td>
					<td><sf:checkbox path="ids" value="${user.id}" /></td>
					<td><c:out value="${user.firstName }"></c:out></td>
					<td><c:out value="${user.lastName }"></c:out></td>
					<td><c:out value="${user.loginId }"></c:out></td>
					<td><c:out value="${user.password }"></c:out></td>
					<td><c:out value="${user.dob }"></c:out></td>
					<td><c:out value="${user.address }"></c:out></td>
					<td><a href="<c:url value="/UserCtl?id=${user.id}"/>">edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<th></th>
				<td align="center"><input type="submit" name="operation"
					value="delete"> 
					
					
						<input type="submit" name="operation" value="previous"
						 ${form.pazeNo==1?'disabled="disabled"':'' }>
					
					 <c:if test="${nextlist==0}">
						<input type="submit" name="operation" value="next"
							disabled="disabled">
					</c:if> <c:if test="${nextlist!=0}">
						<input type="submit" name="operation" value="next"></td>
				</c:if>
			</tr>
		</table>
		</c:if>
		<c:if test="${empty list }">
			<div align="center">
				<h3>
					No Record Found please Go Back <input type="submit"
						name="operation" value="Back" class="btn btn-info" />
				</h3>

			</div>
		</c:if>
	</sf:form>
</body>
</html>