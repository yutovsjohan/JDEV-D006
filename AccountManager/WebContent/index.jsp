<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Trang chủ</title>
</head>
<body>

<h2>LOGIN</h2>
<br>
<% if(request.getAttribute("thongbao")!=null){ %>
<div class="alert alert-danger" role="alert">
  <%=request.getAttribute("thongbao") %>
</div>
<br>
<% } %>

<form action="AccountServlet?task=login" method="post">
	<table>
		<tr>
			<td><label for="exampleInputUsername">Username</label></td>
    		<td><input type="text" class="form-control" id="exampleInputUsername" placeholder="Enter username" name="username"></td>
		</tr>
		<tr>
			<td><label for="exampleInputPassword">Password</label></td>
    		<td><input type="password" class="form-control" id="exampleInputPassword" placeholder="Enter Password" name="password"></td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit" class="btn btn-primary">Login</button></td>
		</tr>
	</table>
  
</form>

</body>
</html>