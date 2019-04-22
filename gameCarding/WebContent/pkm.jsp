<%@page import="entities.pkm"%>
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

<title>Pkm</title>
</head>
<body>

<h1>Pkm</h1>
<br>
<h3><a href="index.jsp">Back</a> || <a href="pkm.jsp">Reload</a></h3>
<br>

<% 
	pkmModel pkm = new pkmModel();
	ArrayList<pkm> list = pkm.getList();	
	
	player pl = new player();
	playerModel plm = new playerModel();
	ArrayList<player> player = plm.getList();
		
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
<p>No pkm</p>
<%
	}
	else{
%>

<table>
	<tr>
		<td style="padding:0 30px">
			<div class="panel-group">
			  <div class="panel panel-primary">
			    <div class="panel-heading">Add new pkm</div>
			  </div>
			  <div class="panel panel-primary">
			    <div class="panel-body">
			    	<form enctype="multipart/form-data" action="pkmServlet?action=add" method="post">
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
							<td><label for="inputType">Type</label></td>
					   		<td><input type="text" class="form-control" id="inputType" placeholder="input type" name="type"></td>
						</tr>
						<tr>
							<td><label for="inputAbility">Ability</label></td>
					   		<td><input type="text" class="form-control" id="inputAbility" placeholder="input ability" name="ability"></td>
						</tr>
						<tr>
							<td><label for="inputIDplayer">Player</label></td>
							<td>
				    			<select name="idplayer" id="inputIDplayer">
				    			<% 
							  	for(player p: player) { 
							  		if(p.getId()!=0){
							  	%>
				    					<option value="<%=p.getId() %>" ><%=p.getName() %></option>
				    			<% 
				    				}
							  	}
							  	%>
				    			</select>
				    		</td>
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
			    <div class="panel-heading">Update pkm</div>
			  </div>
			  <div class="panel panel-primary">
			    <div class="panel-body">
			    	<form enctype="multipart/form-data" action="pkmServlet?action=update" method="post">
					<table>
						<tr>
							<%
							int id=1;						
							pkm pk = pkm.getPkmById(id);
							%>
							<td><label for="idpk">ID</label></td>
							<td>
				    			<select name="id" id="idpk">
				    			<% 
							  	for(pkm p: list) { 
							  		if(p.getId()!=0){
							  	%>
				    					<option id="pkmList" value="<%=p.getId() %>" <% if(p.getId()==id) {%>selected<%}%> ><%=p.getId() %></option>
				    			<% 
				    				}
							  	}
							  	%>
				    			</select>
				    		</td>
						</tr>
						<tr>
							<td><label for="inputName">Name</label></td>
					   		<td><input type="text" class="form-control" id="inputName" placeholder="input name" name="name" value="<%= pk.getName() %>"></td>
						</tr>
						<tr>
							<td><label for="selectImg">Image</label></td>							 
							<td><input type="file" name="file" id="selectImg"></td>
						</tr>						
						<tr>
							<td><label for="inputIDplayer">ID Player </label></td>
							<td>
				    			<select name="idplayer" id="inputIDplayer">
				    			<% 
							  	for(player p: player) { 
							  		if(p.getId()!=0){
							  	%>
				    					<option value="<%=p.getId() %>" <% if(p.getId()==pk.getId()) {%>selected<%}%> ><%=p.getName() %></option>
				    			<% 
				    				}
							  	}
							  	%>
				    			</select>
				    		</td>
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



<h3>List pkm: <%=pkm.count() %> pkms</h3>
<br>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Name</th>
      <th scope="col">Image</th>
      <th scope="col">Possess</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <% 
  	
  	for(pkm p: list) { 
  		if(p.getId()!=0){
  %>
    <tr>
      <th scope="row"><%=p.getId() %></th>
      <th scope="row"><%=p.getName() %></th>
      <td>
   		<img src="img/<%= p.getImg() %>" width="100px" height="100px" >      	
      </td>
      <td>
      	<%
      		pl = plm.getPlayerById(p.getIdplayer());
      		if(pl.getId()!=0){
      	%>
      			<a href="playerDetail.jsp?id=<%= pl.getId() %>"><%= pl.getName()%></a> 
      	<%
      		}
      	%> 
      </td>
      <td>
      	<a href="pkmDetail.jsp?id=<%= p.getId() %>">Details</a> |
      	<% if(pl.getId()!=0){ %>
      	<a href="pkmServlet?action=noone&id=<%= p.getId() %>">Noone</a> |
      	<% } %> 
      	<a href="pkmServlet?action=delete&id=<%= p.getId() %>">Delete</a>
      </td>
    </tr>
  <% 
  		}
  	}
  %>
  </tbody>
</table>

<% } %>

</body>
</html>