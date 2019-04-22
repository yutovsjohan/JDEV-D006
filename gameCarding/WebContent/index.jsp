<%@page import="java.util.Random"%>
<%@page import="model.contestModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.pkm"%>
<%@page import="model.moveModel"%>
<%@page import="model.pkmModel"%>
<%@page import="model.playerModel"%>
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

<h1>Trang chủ</h1>
<br>

<%
	playerModel plm = new playerModel();
	pkmModel pkm = new pkmModel();
	moveModel mm = new moveModel();
	contestModel ctm = new contestModel();
	
	
	if(request.getAttribute("msg")!=null){
%>
	<div class="alert alert-<%= request.getAttribute("flag") %>" role="alert">
	  <%= request.getAttribute("msg") %>
	</div>
	<br>
<% } %>

<form action="BattleServlet?action=init" method="get">
pk1: 
<input type="number" id="idpk1" name="idpk1" /> 
<input type="text" id="name1" readonly="readonly" /> <br>

pk2: 
<input type="number" id="idpk2" name="idpk2" />
<input type="text" id="name2" readonly="readonly" /> <br>

<button type="submit" id="btn">test</button>
</form>

<br>
<a href="test.jsp">test</a>
<br>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Count</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Player</th>
      <td><%= plm.count() %></td>
      <td><a href="player.jsp">List</a></td>
    </tr>
    <tr>
      <th scope="row">Pokemon</th>
      <td><%= pkm.count() %></td>
      <td><a href="pkm.jsp">List</a></td>
    </tr>
    <tr>
      <th scope="row">Move</th>
      <td><%= mm.count() %></td>
      <td><a href="move.jsp">List</a></td>
    </tr>
    <tr>
	  <th scope="row">Contest</th>
	  <td><%= ctm.count() %></td>
	  <td><a href="contest.jsp">List</a></td>
	</tr>
  </tbody>
</table>

<script type="text/javascript">
$(document).ready(function(){	
	
	$("#idpk1").keyup(function(){
		var idpk1 = $("#idpk1").val();
		$.ajax({
			url : "pkmServlet?action=selectpkm",
			type : 'GET',
			data : {
				id:idpk1
			},
			success: function(data){
				$("#name1").val(data);
				console.log(data);
			}
		})
	})
	
	$("#idpk2").keyup(function(){
		var idpk2 = $("#idpk2").val();
		$.ajax({
			url : "pkmServlet?action=selectpkm",
			type : 'GET',
			data : {
				id:idpk2
			},
			success: function(data){
				$("#name2").val(data);
				console.log(data);
			}
		})
	})
	
//	$("#btn").click(function(){
//		var idpk1 = $("#idpk1").val();
//		var idpk2 = $("#idpk2").val();
//		
//		alert('id1: '+idpk1 + ', id2: '+idpk2);
//	})

})
</script>

</body>
</html>