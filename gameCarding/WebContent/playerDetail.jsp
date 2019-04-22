<%@page import="entities.pkm"%>
<%@page import="model.statModel"%>
<%@page import="entities.stat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.player"%>
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

<title>Player Detail</title>
</head>
<body>
<% 
	int id = Integer.parseInt(request.getParameter("id"));
%>
<h3><a href="player.jsp">Back</a> || <a href="playerDetail.jsp?id=<%=id %>">Reload</a></h3>
<%
	if(request.getAttribute("msg")!=null){
%>
	<div class="alert alert-<%=request.getAttribute("flag")%>" role="alert">
	  <%=request.getAttribute("msg")%>
	</div>
	<br>
<%
	} 

	
	playerModel plm = new playerModel();
	pkmModel pkm = new pkmModel();
	moveModel cm = new moveModel();
	
	player pl = plm.getPlayerById(id);
	ArrayList<player> list = plm.getList();
%>	
	<div class="panel-group">
	  <div class="panel panel-primary">
	    <div class="panel-heading">Update player</div>
	  </div>
	  <div class="panel panel-primary">
	    <div class="panel-body">
	    	<form enctype="multipart/form-data" action="playerServlet?action=updateDetail" method="post">
			<table>
				<tr>
					<td><label for="inputid">ID</label></td>
					<td><input type="text" class="form-control" id="inputid" name="id" value="<%=id %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td><label for="inputName">Name</label></td>
			   		<td><input type="text" class="form-control" id="inputName" placeholder="input name" name="name" value="<%= pl.getName() %>"></td>
				</tr>
				<tr>
					<td><label for="selectImg">Image</label></td>
					<td><img src="img/<%= pl.getImg() %>" width="50px" height="50px" >  </td>
					<td><input type="file" name="file" id="selectImg"></td>
				</tr>
				<tr>
					<td><label for="inputMoney">Money</label></td>
			   		<td><input type="number" class="form-control" id="inputMoney" placeholder="input Money" name="money" value="<%= pl.getMoney() %>"></td>
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
	<br><br>
	
<div class="panel-group">
  <div class="panel panel-info">
    <div class="panel-heading">Information</div>
  </div>
  <div class="panel panel-info">
    <div class="panel-body">
    	<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">id</th>
		      <td><%=pl.getId() %></td>	      
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="col">name</th>
			  <td><%=pl.getName() %></td>
		    </tr>
		    <tr>
		      <th scope="col">img</th>
		      <td><img src="img/<%= pl.getImg() %>" width="50px" height="50px" ></td>
		    </tr>
		     <tr>
		      <th scope="col">Level</th>
		      <td>lv <%=pl.getLevel() %> (<%=pl.getExp() %>/)</td>
		    </tr>
		    <tr>
		      <th scope="col">money</th>
		      <td><%=pl.getMoney() %></td>
		    </tr>
		    <tr>
		      <th scope="col">Win-Lose</th>
		      <td><%=pl.getWin() %> - <%= pl.getLose() %></td>
		    </tr>
		    <tr>
		      <th scope="col">Guild</th>
		      <td><%= pl.getGuild() %></td> 
		    </tr>
		  </tbody>
		</table>
    </div>
  </div>
</div>
	
<%
ArrayList<pkm> pklist = new pkmModel().getListByIdplayer(pl.getId()); 

stat st = new stat();

for(pkm pk : pklist){
 st = new statModel().getStatById(pk.getId());
							

%>
	
<div class="panel-group">
  <div class="panel panel-info">
    <div class="panel-heading"><%= pk.getName() %></div>
  </div>
  <div class="panel panel-info">
    <div class="panel-body">
    	<table>
			<tr>
				<td style="padding:20px">
				<div class="panel-group">
				  <div class="panel panel-primary">
				    <div class="panel-heading">Infomation</div>
				  </div>
				  <div class="panel panel-primary">
				    <div class="panel-body">
				    	<table class="table table-striped" >
						  <tbody>
						    <tr>
						      <th scope="col">id</th>
						      <td><%=pk.getId() %></td>	
						    </tr>
						    <tr>
						      <th scope="col">name</th>
							  <td><a href="pkmDetail.jsp?id=<%= pk.getId() %>"><%=pk.getName() %></a></td>
						    </tr>
						    <tr>
						      <th scope="col">img</th>
						      <td><img src="img/<%= pk.getImg() %>" width="120px" height="120px" >   </td>
						    </tr>
						    <tr>
						      <th scope="col">level</th>
						      <td><%=pk.getLevel() %></td>
						    </tr>
						    <tr>
						      <th scope="col">type</th>
						      <td><%=pk.getType() %></td>
						    </tr>
						    <tr>
						      <th scope="col">ability</th>
						      <td><%=pk.getAbility() %></td>
						    </tr>
						    <tr>
						      <th scope="col">posses</th>
						      <td>
						      	<%
						      		pl = plm.getPlayerById(pk.getIdplayer());
						      		if(pl.getId()!=0){
						      	%>
						      			<%= pl.getName()%>
						      	<%
						      		}
						      	%> 
							  </td> 
						    </tr>	
						    <tr>
						      <th scope="col">friendship</th>
						      <td><%=pk.getFriendship() %></td> 
						    </tr>			   
						  </tbody>
						</table>
				    </div>
				  </div>
				</div>
				</td>
				
				<td style="padding:20px">
					<div class="panel-group">
					  <div class="panel panel-primary">
					    <div class="panel-heading">Stat</div>
					  </div>
					  <div class="panel panel-primary">
					    <div class="panel-body">
					    	<table class="table table-striped" >
							  <tbody>
							    <tr>
							      <th scope="col">atk</th>
							      <td><%=st.getAtk() %></td>	      
							    </tr>
							    <tr>
							      <th scope="col">hp</th>
								  <td><%=st.getHp() %></td>
							    </tr>
							    <tr>
							      <th scope="col">de</th>
							      <td><%=st.getDe() %></td>
							    </tr>
							    <tr>
							      <th scope="col">ct</th>
							      <td><%=st.getCt() %></td>
							    </tr>
							    <tr>
							      <th scope="col">cd</th>
							      <td><%=st.getCd() %></td>
							    </tr>
							    <tr>
							      <th scope="col">ev</th>
							      <td><%=st.getEv() %></td>
							    </tr>
							    <tr>
							      <th scope="col">bl</th>
							      <td><%=st.getBl() %></td>
							    </tr>
							    <tr>
							      <th scope="col">bl point</th>
							      <td><%=st.getBlpoint() %></td>
							    </tr>
							    <tr>
							      <th scope="col">att</th>
							      <td><%=st.getAtt() %></td>	      
							    </tr>
							    <tr>
							      <th scope="col">energy</th>
							      <td><%=st.getEnergy() %></td>
							    </tr>
							  </tbody>
							</table>
					    </div>
					  </div>
					</div>
				</td>
			</tr>
		</table>
    </div>
  </div>
</div>


<%
}
%>


</body>
</html>