<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Login</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="loginServlet" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="txtname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="txtpass"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>

	</form>
</body>
</html>