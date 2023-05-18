<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="model.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados Funcionário</title>
</head>

<body>

<h1>Funcionário: <i>${ employee.firstName } ${ employee.lastName }</i></h1>
<h2>Dados:</h2>
<table border="1" style="with: 80%">
	<tr>
		<td>Username</td>
		<td>${ employee.username }</td>
	</tr>
	<tr>
		<td>Password</td>
		<td>${ employee.password }</td>
	</tr>
	<tr>
		<td>Address</td>
		<td>${ employee.address }</td>
	</tr>
	<tr>
		<td>Contact</td>
		<td>${ employee.contact }</td>
	</tr>
</table>

</body>
</html>