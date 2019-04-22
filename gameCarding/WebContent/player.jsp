<%@page import="entities.player"%>
<%@page import="java.util.ArrayList"%>
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

<title>Player</title>
</head>
<body>

<h1>Player</h1>
<br>
<h3><a href="index.jsp">Back</a> || <a href="player.jsp">Reload</a></h3>
<br>

<% 
	playerModel plm = new playerModel();
	ArrayList<player> list = plm.getList();
	if(request.getAttribute("msg")!=null){
%>
	<div class="alert alert-<%= request.getAttribute("flag") %>" role="alert">
	  <%= request.getAttribute("msg") %>
	</div>
	<br>
<% } %>

<%
	if(list.size()==0){
%>
<p>No player</p>
<%
	}
	else{
%>

<table>
	<tr>
		<td style="padding:0 30px">
			<div class="panel-group">
			  <div class="panel panel-primary">
			    <div class="panel-heading">Add new player</div>
			  </div>
			  <div class="panel panel-primary">
			    <div class="panel-body">
			    	<form enctype="multipart/form-data" action="playerServlet?action=add" method="post">
					<table>
						<tr>
							<td><label for="inputName">Name</label></td>
					   		<td><input type="text" class="form-control" id="inputName" placeholder="input name" name="name"></td>
						</tr>
						<tr>
							<td><label for="selectImg">Image</label></td>
							<td><input type="file" name="file" id="selectImg"></td>
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
		<td style="padding:0 30px">
			<div class="panel-group">
			  <div class="panel panel-primary">
			    <div class="panel-heading">Update player</div>
			  </div>
			  <div class="panel panel-primary">
			    <div class="panel-body">
			    	<form enctype="multipart/form-data" action="playerServlet?action=update" method="post">
					<table>
						<tr>
						<%
						int id=1;
						if(request.getParameter("id")!=null){
							id= Integer.parseInt(request.getParameter("id"));
						}
						player pl = plm.getPlayerById(id);
						%>
							<td><label for="inputid">ID</label></td>
							<td>
				    			<select name="id" id="inputid">
				    			<% 
							  	for(player p: list) { 
							  		if(p.getId()!=0){
							  	%>
				    					<option value="<%=p.getId() %>" name="<%=p.getName() %>" <% if(p.getId()==id) {%>selected<%}%> ><%=p.getId() %></option>
				    			<% 
				    				}
							  	}
							  	%>
				    			</select>
				    		</td>
						</tr>
						<tr>
							<td><label for="inputName">Name</label></td>
					   		<td><input type="text" class="form-control" id="inputName" placeholder="input name" name="name" value="<%=pl.getName()%>"></td>
						</tr>
						<tr>
							<td><label for="selectImg">Image</label></td>							
							<td><input type="file" name="file" id="selectImg"></td>
						</tr>						
						<tr>
							<td></td>
							<td><button type="submit" class="btn btn-primary">Update</button></td>
						</tr>
					</table>
					</form>
			    </div>
			  </div>
			</div>
		</td>
	</tr>
</table>



<h3>List player: <%=plm.count() %> players</h3>
<br>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Name</th>
      <th scope="col">Image</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <% 
  	for(player p: list) { 
  		if(p.getId()!=0){
  %>
    <tr>
      <th scope="row"><%=p.getId() %></th>
      <th scope="row"><%=p.getName() %></th>
      <td>
   		<img src="img/<%= p.getImg() %>" width="50px" height="50px" >      	
      </td>
      <td>
      	<a href="playerDetail.jsp?id=<%= p.getId() %>">Details</a> |
      	<a href="playerServlet?action=delete&id=<%= p.getId() %>">Delete</a>
      </td>
    </tr>
  <% 
  		}
  	}
  %>
  </tbody>
</table>

<% } %>

<script type="text/javascript">
$("#inputid").change(function () {
    var name = "";
    var id="";
   
    $("select option:selected").each(function() {
    	id = $(this).text();
    	name = $(this).attr("name");
    });
    
    
    $.ajax({
		url : "playerServlet?action=selectPlayer",
		type : 'GET',
		data : {
			id : id
		},
		success: function(data){
			$("#inputName").html(name);
		}
	})
  
})
</script>

</body>
</html>