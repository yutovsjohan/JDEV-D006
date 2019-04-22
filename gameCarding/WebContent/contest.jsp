<%@page import="entities.contest"%>
<%@page import="model.contestModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Contest</title>
</head>
<body>

<h1>Contest</h1>
<br>

<%
	
	contestModel ctm = new contestModel();
	ArrayList<contest> list = ctm.getList();	

	if(request.getAttribute("msg")!=null){
%>
	<div class="alert alert-<%= request.getAttribute("flag") %>" role="alert">
	  <%= request.getAttribute("msg") %>
	</div>
	<br>
<% }

%>
<h3><a href="index.jsp">Index</a> || <a href="contest.jsp">Reload</a></h3>

<table>
<tr>
	<td style="padding:0 30px">
		<div class="panel-group">
		  <div class="panel panel-primary">
		    <div class="panel-heading">Add new contest</div>
		  </div>
		  <div class="panel panel-primary">
		    <div class="panel-body">
		    	<form action="contestServlet?action=add" method="post">
				<table>
					<tr>
						<td><label for="inputName">Name</label></td>
				   		<td><input type="text" class="form-control" id="inputName" placeholder="input name" name="name"></td>
					</tr>
					<tr>
						<td><label for="inputPrize">Prize</label></td>
						<td><input type="text" name="prize" id="inputPrize" placeholder="input prize" class="form-control"></td>
					</tr>
					<tr>
						<td><label for="inputMoney">Money</label></td>
				   		<td><input type="number" class="form-control" id="inputMoney" placeholder="input Money" name="money" value="0"></td>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit" class="btn btn-primary">Add</button></td>
					</tr>
				</table>
				</form>
		    </div>
		  </div>
		</div>
	</td>
</tr>
</table>
<%
	if(list.isEmpty()){
%>
	<p>nothing</p>
<%
	}
	else{
%>
<h3>List contest: <%=ctm.count() %> contests</h3>
<br>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Name</th>
      <th scope="col">Amount</th>
      <th scope="col">Winner</th>
      <th scope="col">Prize</th>
      <th scope="col">Money</th>
      <th scope="col">Note</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <% 
  	for(contest p: list) { 
  		if(p.getId()!=0){
  %>
    <tr>
      <td scope="row"><%=p.getId() %></td>
      <td scope="row"><%=p.getName() %></td>
      <td scope="row"><%=p.getSoluong() %></td>
      <td scope="row"><%=p.getWinner() %></td>
      <td scope="row"><%=p.getPrize() %></td>
      <td scope="row"><%=p.getMoney() %></td>
      <td scope="row"><%=p.getNote() %></td>
      <td>
      	<a href="contestDetail.jsp?id=<%= p.getId() %>">Details</a> |
      	<a href="contestServlet?action=delete&id=<%= p.getId() %>">Delete</a>
      </td>
    </tr>
  <% 
  		}
  	}
  %>
  </tbody>
</table>
<%
	}
%>


<script type="text/javascript">
$(document).ready(function(){	
	
	

})
</script>

</body>
</html>