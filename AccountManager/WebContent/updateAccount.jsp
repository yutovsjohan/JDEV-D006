<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Update account page</title>
</head>
<body>

<h2>Update account</h2>
<br>


<form action="AccountServlet?task=update" method="post">
	<table>
		<tr>
			<td><label for="exampleInputUsername">Username</label></td>
    		<td><input type="text" class="form-control" id="exampleInputUsername" placeholder="Enter username" name="username" value="<%= request.getParameter("username")%>"></td>
		</tr>
		<tr>
			<td><label for="exampleInputPassword">Password</label></td>
    		<td><input type="password" class="form-control" id="exampleInputPassword" placeholder="Enter Password" name="password" value="<%= request.getParameter("password")%>"></td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit" class="btn btn-primary">Update</button></td>
		</tr>
	</table>
  
</form>

</body>
</html>