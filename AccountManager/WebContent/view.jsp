<%@page import="entites.account"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>View page</title>
</head>
<body>

<br>
<% if(request.getAttribute("thongbao")!=null){ %>
<div class="alert alert-<%=request.getAttribute("flag") %>" role="alert">
  <%=request.getAttribute("thongbao") %>
</div>
<br>
<% } %>

<h3>
	<a href="insertAccount.jsp">Insert new account</a>
</h3>
<br>

<table class="table" style="width:50% ;margin-top:20px">
  <thead>
    <tr>
      <th scope="col">Username</th>
      <th scope="col">Password</th>
      <th scope="col">Action</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <% 
  ArrayList list = (ArrayList) session.getAttribute("accountList");
  for(Object a:list){
	  account acc = (account) a;
  %>  
    <tr>
      <td><%= acc.getUsername() %></td>
      <td><%= acc.getPassword() %></td>
      <td><a href="updateAccount.jsp?username=<%= acc.getUsername()%>&password=<%= acc.getPassword()%>">Update</a></td>
      <td><a href="AccountServlet?task=delete&username=<%= acc.getUsername()%>">Delete</a></td>
    </tr>
  <%
  }
  %>
  </tbody>
</table>

</body>
</html>