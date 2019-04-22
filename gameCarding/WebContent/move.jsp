<%@page import="java.util.ArrayList"%>
<%@page import="entities.move"%>
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

<title>Move</title>
</head>
<body>

<h1>Move</h1>
<br>
<%	
	moveModel mm = new moveModel();	
	ArrayList<move> list = mm.getList();
	if(request.getAttribute("msg")!=null){
%>
	<div class="alert alert-<%= request.getAttribute("flag") %>" role="alert">
	  <%= request.getAttribute("msg") %>
	</div>
	<br>
<% } %>

<h3><a href="index.jsp">Back</a> || <a href="move.jsp">Reload</a></h3>
<br>

<%
	if(list.size()==0){
%>
<p>No move</p>
<%
	}
	else{
%>

<table>
<tr>
	<td style="padding:0 30px">
		<div class="panel-group">
		  <div class="panel panel-primary">
		    <div class="panel-heading">Add new move</div>
		  </div>
		  <div class="panel panel-primary">
		    <div class="panel-body">
		    	<form enctype="multipart/form-data" action="moveServlet?action=add" method="post">
				<table>
					<tr>
						<td><label for="inputName">Name</label></td>
				   		<td><input type="text" class="form-control" id="inputName" placeholder="input name" name="name"></td>
					</tr>
					<tr>
						<td><label for="selectPower">Power</label></td>
						<td><input type="number" class="form-control" id="selectPower" placeholder="input power" name="power" value="0"></td>
					</tr>
					<tr>
						<td><label for="inputEnergy">Energy</label></td>
				   		<td><input type="number" class="form-control" id="inputEnergy" placeholder="input energy" name="energy" value="0"></td>
					</tr>
					<tr>
						<td><label for="inputType">Type</label></td>
				   		<td><input type="text" class="form-control" id="inputType" placeholder="input type" name="type"></td>
					</tr>
					<tr>
						<td><label for="selectAcc">Acc</label></td>
						<td><input type="number" class="form-control" id="selectAcc" placeholder="input acc" name="acc" value="100"></td>
					</tr>
					<tr>
						<td><label for="inputEff1">Effect 1</label></td>
				   		<td>
				   			<select name="eff1" id="inputEff1">
				   				<option value="none">none</option>
				   				<option value="atk">atk</option>
				   				<option value="hp">hp</option>
				   				<option value="de">de</option>
				   				<option value="ct">ct</option>
				   				<option value="cd">cd</option>
				   				<option value="ev">ev</option>
				   				<option value="bl">bl</option>
				   				<option value="blpoint">blpoint</option>
				   				<option value="att">att</option>
				   				<option value="energy">energy</option>
				   			</select>
				   		</td>
					</tr>
					<tr>
						<td><label for="selectPoint1">Point 1</label></td>
						<td><input type="number" class="form-control" id="selectPoint1" placeholder="input point 1" name="point1" value="0"></td>
					</tr>
					<tr>
						<td><label for="inputObj1">Obj 1</label></td>
				   		<td>
				   			<select name="obj1" id="inputObj1">
				   				<option value="none">none</option>
				   				<option value="self">self</option>
				   				<option value="opposite">opposite</option>				   				
				   			</select>
				   		</td>
					</tr>
					<tr>
						<td><label for="inputPerEff1">Percent Effect 1</label></td>
						<td><input type="number" class="form-control" id="inputPerEff1" placeholder="input per eff 1" name="perEff1" value="0"></td>
					</tr>
					<tr>
						<td><label for="inputEff2">Effect 2</label></td>
				   		<td>
				   			<select name="eff2" id="inputEff2">
				   				<option value="none">none</option>
				   				<option value="atk">atk</option>
				   				<option value="hp">hp</option>
				   				<option value="de">de</option>
				   				<option value="ct">ct</option>
				   				<option value="cd">cd</option>
				   				<option value="ev">ev</option>
				   				<option value="bl">bl</option>
				   				<option value="blpoint">blpoint</option>
				   				<option value="att">att</option>
				   				<option value="energy">energy</option>
				   			</select>
				   		</td>
					</tr>
					<tr>
						<td><label for="selectPoint2">Point 2</label></td>
						<td><input type="number" class="form-control" id="selectPoint2" placeholder="input point 2" name="point2" value="0"></td>
					</tr>
					<tr>
						<td><label for="inputObj2">Obj 2</label></td>
				   		<td>
				   			<select name="obj2" id="inputObj2">
				   				<option value="none">none</option>
				   				<option value="self">self</option>
				   				<option value="opposite">opposite</option>				   				
				   			</select>
				   		</td>
					</tr>
					<tr>
						<td><label for="inputPerEff2">Percent Effect 2</label></td>
						<td><input type="number" class="form-control" id="inputPerEff2" placeholder="input per eff 2" name="perEff2" value="0"></td>
					</tr>
					<tr>
						<td><label for="inputStatus">Status</label></td>
				   		<td><input type="text" class="form-control" id="inputStatus" placeholder="input status" name="status"></td>
					</tr>
					<tr>
						<td><label for="inputPerStatus">Percent Status </label></td>
						<td><input type="number" class="form-control" id="inputPerStatus" placeholder="input per status 2" name="perStatus" value="0"></td>
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
					move m = mm.getMoveById(id);
					%>
						<td><label for="inputid">ID</label></td>
						<td>
			    			<select name="id" id="inputid">
			    			<% 
						  	for(move p: list) { 						  		
						  	%>
			    					<option value="<%=p.getId() %>" name="<%=p.getName() %>" <% if(p.getId()==id) {%>selected<%}%> ><%=p.getId() %></option>
			    			<% 
						  	}
						  	%>
			    			</select>
			    		</td>
					</tr>
					<tr>
						<td><label for="inputName">Name</label></td>
				   		<td><input type="text" class="form-control" id="inputName" placeholder="input name" name="name" value="<%=m.getName()%>"></td>
					</tr>
					<tr>
						<td><label for="selectPower">Power</label></td>
						<td><input type="number" class="form-control" id="selectPower" placeholder="input power" name="power" value="<%=m.getPower()%>"></td>
					</tr>
					<tr>
						<td><label for="inputEnergy">Energy</label></td>
				   		<td><input type="number" class="form-control" id="inputEnergy" placeholder="input energy" name="energy" value="<%= m.getEnergy() %>"></td>
					</tr>
					<tr>
						<td><label for="inputType">Type</label></td>
				   		<td><input type="text" class="form-control" id="inputType" placeholder="input type" name="type" value="<%= m.getType() %>" ></td>
					</tr>
					<tr>
						<td><label for="selectAcc">Acc</label></td>
						<td><input type="number" class="form-control" id="selectAcc" placeholder="input acc" name="acc" value="<%= m.getAcc() %>"></td>
					</tr>
					<tr>
						<td><label for="inputEff1">Effect 1</label></td>
				   		<td>
				   			<select name="eff1" id="inputEff1">
				   				<option value="none">none</option>
				   				<option value="atk">atk</option>
				   				<option value="hp">hp</option>
				   				<option value="de">de</option>
				   				<option value="ct">ct</option>
				   				<option value="cd">cd</option>
				   				<option value="ev">ev</option>
				   				<option value="bl">bl</option>
				   				<option value="blpoint">blpoint</option>
				   				<option value="att">att</option>
				   				<option value="energy">energy</option>
				   			</select>
				   		</td>
					</tr>
					<tr>
						<td><label for="selectPoint1">Point 1</label></td>
						<td><input type="number" class="form-control" id="selectPoint1" placeholder="input point 1" name="point1" value="<%= m.getPoint1() %>"></td>
					</tr>
					<tr>
						<td><label for="inputObj1">Obj 1</label></td>
				   		<td>
				   			<select name="obj1" id="inputObj1">
				   				<option value="none">none</option>
				   				<option value="self">self</option>
				   				<option value="opposite">opposite</option>				   				
				   			</select>
				   		</td>
					</tr>
					<tr>
						<td><label for="inputPerEff1">Percent Effect 1</label></td>
						<td><input type="number" class="form-control" id="inputPerEff1" placeholder="input per eff 1" name="perEff1" value="<%= m.getPerEff1() %>"></td>
					</tr>
					<tr>
						<td><label for="inputEff2">Effect 2</label></td>
				   		<td>
				   			<select name="eff2" id="inputEff2">
				   				<option value="none">none</option>
				   				<option value="atk">atk</option>
				   				<option value="hp">hp</option>
				   				<option value="de">de</option>
				   				<option value="ct">ct</option>
				   				<option value="cd">cd</option>
				   				<option value="ev">ev</option>
				   				<option value="bl">bl</option>
				   				<option value="blpoint">blpoint</option>
				   				<option value="att">att</option>
				   				<option value="energy">energy</option>
				   			</select>
				   		</td>
					</tr>
					<tr>
						<td><label for="selectPoint2">Point 2</label></td>
						<td><input type="number" class="form-control" id="selectPoint2" placeholder="input point 2" name="point2" value="<%= m.getPoint2() %>"></td>
					</tr>
					<tr>
						<td><label for="inputObj2">Obj 2</label></td>
				   		<td>
				   			<select name="obj2" id="inputObj2">
				   				<option value="none">none</option>
				   				<option value="self">self</option>
				   				<option value="opposite">opposite</option>				   				
				   			</select>
				   		</td>
					</tr>
					<tr>
						<td><label for="inputPerEff2">Percent Effect 2</label></td>
						<td><input type="number" class="form-control" id="inputPerEff2" placeholder="input per eff 2" name="perEff2" value="<%= m.getPerEff2() %>"></td>
					</tr>
					<tr>
						<td><label for="inputStatus">Status</label></td>
				   		<td><input type="text" class="form-control" id="inputStatus" placeholder="input status" name="status" value="<%= m.getStatus() %>"></td>
					</tr>
					<tr>
						<td><label for="inputPerStatus">Percent Status </label></td>
						<td><input type="number" class="form-control" id="inputPerStatus" placeholder="input per status 2" name="perStatus" value="<%= m.getPerStatus() %>"></td>
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



<h3>List player: <%=mm.count() %> moves</h3>
<br>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Name</th>
      <th scope="col">Type</th>
      <th scope="col">Power</th>
      <th scope="col">Energy</th>
      <th scope="col">Effect</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <% 
  	for(move p: list) { 
  %>
    <tr>
      <td scope="row"><%=p.getId() %></td>
      <td scope="row"><%=p.getName() %></td>
      <td scope="row"><%=p.getType() %></td>
      <td scope="row"><%=p.getPower() %></td>
      <td scope="row"><%=p.getEnergy() %></td>
      <td scope="row">
		<%
			String str="none";
			if(!p.getEff1().equals("none")){
				str = p.getPerEff1() + "%, "+ p.getPoint1() + " " + p.getEff1(); 		
			}
			else if(!p.getEff1().equals("none")){
				str = p.getPerEff2() + "%, "+ p.getPoint2() + p.getEff2();		
			}
			else if(!p.getStatus().equals("none")){
				str = p.getPerStatus() + "% "+ p.getStatus();
			}
		%>
		<%=str %>
	  </td>
      <td>
      	<a href="moveDetail.jsp?id=<%= p.getId() %>">Details</a> |
      	<a href="moveServlet?action=delete&id=<%= p.getId() %>">Delete</a>
      </td>
    </tr>
  <%   		
  	}
  %>
  </tbody>
</table>

<% } %>

</body>
</html>