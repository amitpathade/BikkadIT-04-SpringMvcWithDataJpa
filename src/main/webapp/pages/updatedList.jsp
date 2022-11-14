<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>

<table>
		<thead>
			<tr>
				<td>User Id</td>
				<td>User Name</td>
				<td>User UName</td>
				<td>User Passward</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="user">
			<tr>
				<td>${user.uid}</td>
				<td>${user.name }</td>
				<td>${user.uname }</td>
				<td>${user.passward }</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>