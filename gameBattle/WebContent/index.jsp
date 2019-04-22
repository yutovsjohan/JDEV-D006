<%@page import="model.playerModel"%>
<%@page import="entities.player"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Trang chủ</title>
</head>
<body>

<%
	player p = new playerModel().getPlayerById(1);
%>
<table class="table table-striped">
<tr><td>
<div>
	<div class="panel-group" >
	  <div class="panel panel-info">
	    <div class="panel-heading">Information</div>
	  </div>
	  <div class="panel panel-info">
	    <div class="panel-body">
			<table class="table table-striped">
			  <tbody>
			    <tr>
			      <th scope="row">Name</th>
			      <td><%= p.getName() %></td>
			    </tr>
			    <tr>
			      <th scope="row">Level</th>
			      <td><%= p.getLevel() %></td>
			    </tr>
			    <tr>
			      <th scope="row">Exp</th>
			      <td><%= p.getExp() %></td>
			    </tr>
				<tr>
				  <th scope="row">Money</th>
				  <td><%= p.getMoney() %></td>
				</tr>
			  </tbody>
			</table>
		  </div>
	   	</div>
	</div>
</div>
</td>

<td>
<div>
	<div class="panel-group" >
	  <div class="panel panel-info">
	    <div class="panel-heading">Quest main</div>
	  </div>
	  <div class="panel panel-info">
	    <div class="panel-body">
			<table class="table table-striped">
			  <tbody>
			    <tr>
			      <th scope="row">Name</th>
			      <td><%= p.getName() %></td>
			    </tr>
			    <tr>
			      <th scope="row">Level</th>
			      <td><%= p.getLevel() %></td>
			    </tr>
			    <tr>
			      <th scope="row">Atk</th>
			      <td><%= p.getExp() %></td>
			    </tr>
				<tr>
				  <th scope="row">Hp</th>
				  <td><%= p.getMoney() %></td>
				</tr>
			  </tbody>
			</table>
		  </div>
	   	</div>
	</div>
</div>
</td></tr>
</table>

<script type="text/javascript">

</script>

</body>
</html>