<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h1>Login usuário</h1>
	<form action="<%= request.getContextPath() %>/Login" method="post">
	Usuario:
	<input type="text" name="username" /><br>
	Senha:
	<input type="text" name="password" /><br>
	<input type="submit" value="Submit" />
	</form>

</body>
</html>