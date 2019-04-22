<%@page import="model.statModel"%>
<%@page import="entities.stat"%>
<%@page import="entities.pkm"%>
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

<title>Pkm Detail</title>
</head>
<body>

<%
	int id = Integer.parseInt(request.getParameter("id"));
%>

<h3><a href="pkm.jsp">Back</a> || <a href="pkmDetail.jsp?id=<%=id%>">Reload</a></h3>
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
	ArrayList<player> playerList = plm.getList();
	
	pkm pk = pkm.getPkmById(id);
	ArrayList<pkm> list = pkm.getList();
	
	stat st = new statModel().getStatById(id);
%>	
		
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
					  <td><%=pk.getName() %></td>
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
				      			<a href="playerDetail.jsp?id=<%= pl.getId() %>"><%= pl.getName()%></a>
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
	
	
<div class="panel-group">
  <div class="panel panel-info">
    <div class="panel-heading">Update pkm</div>
  </div>
  <div class="panel panel-info">
    <div class="panel-body">
    <form method="post" action="pkmServlet?action=detail&id=<%=id %>" enctype="multipart/form-data">
    	<table>
   		<tr>
 		<td style="padding:20px">
		 <div class="panel panel-info">
		    <div class="panel-body">
		    	<table class="table table-striped" >
				  <tbody>							   
				    <tr>				     
				      <th scope="col"><label for="inputName">Name</label></th>
					  <td><input type="text" class="form-control" id="inputName" placeholder="input name" name="name" value="<%= pk.getName() %>"></td>					  
				    </tr>
				    <tr>
						<td><label for="selectImg">Image</label></td>
						<td>
							<img src="img/<%= pk.getImg() %>" width="165px" height="223px">						 
							<input type="file" name="file" id="selectImg">
						</td>
					</tr>	
				    <tr>
				      <th scope="col"><label for="inputlv">Level</label></th>
				      <td><input type="number" class="form-control" id="inputlv" placeholder="input level" name="level" value="<%= pk.getLevel() %>"></td>
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputtype">type</label></th>
				      <td><input type="text" class="form-control" id="inputtype" placeholder="input type" name="type" value="<%= pk.getType() %>"></td>				      
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputability">ability</label></th>
				      <td><input type="text" class="form-control" id="inputability" placeholder="input ability" name="ability" value="<%= pk.getAbility() %>"></td>	
				    </tr>
				    <tr>
						<td><label for="inputIDplayer">ID Player </label></td>
						<td>
			    			<select name="idplayer" id="inputIDplayer">
			    			<% 
						  	for(player p: playerList) { 
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
				  </tbody>
				</table>
		    </div>
		  </div>
   		</td>
   		
   		<td>
   			<div class="panel panel-info">
		    <div class="panel-body">
		    	<table class="table table-striped" >
				  <tbody>							   
				    <tr>				     
				      <th scope="col"><label for="inputatk">atk</label></th>
					  <td><input type="number" class="form-control" id="inputatk" placeholder="input atk" name="atk" value="<%= st.getAtk() %>"></td>					  
				    </tr>
				   <tr>				     
				      <th scope="col"><label for="inputhp">hp</label></th>
					  <td><input type="number" class="form-control" id="inputhp" placeholder="input hp" name="hp" value="<%= st.getHp() %>"></td>					  
				    </tr>	
				    <tr>
				      <th scope="col"><label for="inputde">de</label></th>
				      <td><input type="number" class="form-control" id="inputde" placeholder="input de" name="de" value="<%= st.getDe() %>"></td>
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputct">ct</label></th>
				      <td><input type="number" class="form-control" id="inputct" placeholder="input ct" name="ct" value="<%= st.getCt() %>"></td>				      
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputcd">cd</label></th>
				      <td><input type="number" class="form-control" id="inputcd" placeholder="input cd" name="cd" value="<%= st.getCd() %>"></td>	
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputev">ev</label></th>
				      <td><input type="number" class="form-control" id="inputev" placeholder="input ev" name="ev" value="<%= st.getEv() %>"></td>	
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputbl">bl</label></th>
				      <td><input type="number" class="form-control" id="inputbl" placeholder="input bl" name="bl" value="<%= st.getBl() %>"></td>	
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputblpoint">blpoint</label></th>
				      <td><input type="number" class="form-control" id="inputblpoint" placeholder="input blpoint" name="blpoint" value="<%= st.getBlpoint() %>"></td>	
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputatt">att</label></th>
				      <td><input type="number" class="form-control" id="inputatt" placeholder="input att" name="att" value="<%= st.getAtt() %>"></td>	
				    </tr>
				    <tr>
				      <th scope="col"><label for="inputenergy">energy</label></th>
				      <td><input type="number" class="form-control" id="inputenergy" placeholder="input energy" name="energy" value="<%= st.getEnergy() %>"></td>	
				    </tr>
				  </tbody>
				</table>
		    </div>
		  </div>
   		</td>
   		</tr>
   		
   		<tr>
   			<td><button type="submit" class="btn btn-success">Update</button></td>
   		</tr>
    	</table>
    
    </form>
    </div>
  </div>
</div>


</body>
</html>