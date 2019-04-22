<%@page import="entities.player"%>
<%@page import="model.battleModel"%>
<%@page import="entities.battle"%>
<%@page import="entities.move"%>
<%@page import="model.statModel"%>
<%@page import="entities.stat"%>
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

<style type="text/css">
	.red{
		color: red;
	}
	.green{
		color: green;
	}
	.win{
		background-color: yellow;
	}
	.hp{
		font-size: 16px;
		color: red;
	}
</style>

<title>Battle</title>
</head>
<body>
<h3><a href="index.jsp">Index</a> || <a href="battle.jsp">Reload</a></h3>
<br>
<%
	battleModel bm = new battleModel();

	ArrayList<battle> list = new battleModel().getList();
	
	if(list.isEmpty()){
%>
	nothing
	<%
	}
	else{
	
	ArrayList<Integer> twoRow = bm.getTwoRows();
	
	battle b1 = new battleModel().getBattleById(twoRow.get(1));
	battle b2 = new battleModel().getBattleById(twoRow.get(0));
	
	int idpk1 = new pkmModel().getIdByName(b1.getName());
	int idpk2 = new pkmModel().getIdByName(b2.getName());
	
	pkm pk1 = new pkmModel().getPkmById(idpk1);
	pkm pk2 = new pkmModel().getPkmById(idpk2);
	
	stat st1 = new statModel().getStatById(idpk1);
	stat st2 = new statModel().getStatById(idpk2);
	
	int energy1 = st1.getEnergy();
	int energy2 = st2.getEnergy();
	
	player p1 = new playerModel().getPlayerById(pk1.getIdplayer());
	player p2 = new playerModel().getPlayerById(pk2.getIdplayer());
	
	if(request.getAttribute("msg")!=null){
%>
	<div class="alert alert-<%= request.getAttribute("flag") %>" role="alert">
	  <%= request.getAttribute("msg") %>
	</div>
	<br>
<% 
	} 	
%>

<table id="battle">
	<tr>
		<td style="padding:20px" id="pk1">			
			
			<table style="margin:20px">
				<tr>
					<td>player <span id="playername"><%=p1.getName() %></span> </td>
					<span id="playerid" hidden=""><%= p1.getId() %></span>
				</tr>
				<tr>
					<td id="idpk" hidden=""><%=pk1.getId() %></td>
					<td id="name"><%=pk1.getName() %></td>
				</tr>
				<td>
			   		<img src="img/<%= pk1.getImg() %>" width="203px" height="300px" >      	
			    </td>
				<tr>
					<td>lv: <span id="lv"><%=pk1.getLevel() %></span></td>
				</tr>
				<tr>
					<td>type: <span id="type"><%=pk1.getType() %></span> (+<span id="typePoint"><%=b1.getAtt() %></span>%)</td>
				</tr>
				<tr>
					<td>ATK: <span id="atk"> <%= b1.getAtk() %> </span></td>
				</tr>
				<tr>
					<td>HP: <span id="hp" class="hp"><%= b1.getHp() %></span></td>
				</tr>
				<tr>
					<td>DE: <span id="de"><%= b1.getDe() %></span></td>
				</tr>
				<tr>
					<td>CT: <span id="ct"><%= b1.getCt() %></span>%</td>
					<td><span id="perct" ></span></td>
				</tr>
				<tr>
					<td>CD: <span id="cd"><%= b1.getCd() %></span>%</td>
				</tr>
				<tr>
					<td>EV: <span id="ev"><%= b1.getEv() %></span>%</td>
					<td><span id="perev" ></span></td>
				</tr>
				<tr>
					<td>
						BL: <span id="bl"><%= b1.getBl() %></span>% - 
						<span id="blpoint" ><%= b1.getBlpoint() %></span>%
					</td>
					<td><span id="perbl" ></span></td>
				</tr>
				<tr>
					<td>status: <span id="status"><%= b1.getStatus() %></span></td>
					<td  id="sttime" hidden>0</td>
				</tr>
				<tr>
					<td><button class="btn btn-primary" id="attack" type="button" <% if(b1.getEnergy()<10){ %> disabled <%} %> >attack</button></td>
					<td>energy: 10</td>
				</tr>				
				<tr>
					<td>energy: <span id="energy"><%= b1.getEnergy() %></span>/<span id="energyMax"><%=energy1 %></span></td>
				</tr>
				<tr>
					<td><button class="btn btn-primary" id="tangenergy" type="button" >++</button></td>
					<td><button class="btn btn-primary" id="giamenergy" type="button" >--</button></td>
				</tr>
				<tr>
					<td>Energy times: <span id="et">0</span></td>
				</tr>
			</table> 
			
			<textarea rows="20" cols="50" id="txtThongBao" readonly="readonly" >
			</textarea>
		</td>		
				
		<td  style="padding:20px" id="pk2">						
			<table style="margin:20px">
				<tr>
					<td>player <span id="playername2"><%=p2.getName() %></span> </td>
					<span id="playerid2" hidden=""><%= p2.getId() %></span> 
				</tr>
				<tr>
					<td id="idpk2" hidden=""><%=pk2.getId() %></td>
					<td id="name2"><%=pk2.getName() %></td>
				</tr>				
				<td>
			   		<img src="img/<%= pk2.getImg() %>" width="203px" height="300px" >      	
			    </td>
				<tr>
					<td>lv: <span><%=pk2.getLevel() %></span></td>
				</tr>
				<tr>
					<td>type: <span id="type"><%=pk2.getType() %></span> (+<span id="typePoint2"><%=b2.getAtt() %></span>%)</td>
				</tr>
				<tr>
					<td>ATK: <span id="atk2"> <%= b2.getAtk() %> </span></td>
				</tr>
				<tr>
					<td>HP: <span id="hp2" class="hp"><%= b2.getHp() %></span></td>
				</tr>
				<tr>
					<td>DE: <span id="de2"><%= b2.getDe() %></span></td>
				</tr>
				<tr>
					<td>CT: <span id="ct2"><%= b2.getCt() %></span>%</td>
					<td><span id="perct2" ></span></td>
				</tr>
				<tr>
					<td>CD: <span id="cd2"><%= b2.getCd() %></span>%</td>
				</tr>
				<tr>
					<td>EV: <span id="ev2"><%= b2.getEv() %></span>%</td>
					<td><span id="perev2" ></span></td>
				</tr>
				<tr>
					<td>
						BL: <span id="bl2"><%= b2.getBl() %></span>% - 
						<span id="blpoint2" ><%= b2.getBlpoint() %></span>%
					</td>
					<td><span id="perbl2" ></span></td>
				</tr>
				<tr>
					<td>status: <span id="status2"><%= b2.getStatus() %></span></td>
					<td  id="sttime2" hidden>0</td>
				</tr>
				<tr>
					<td><button class="btn btn-primary" id="attack2" type="button" <% if(b2.getEnergy()<10){ %> disabled <% } %> >attack</button></td>
					<td>energy: 10</td>
				</tr>				
				<tr>
					<td>energy: <span id="energy2"><%= b2.getEnergy() %></span>/<span id="energyMax2"><%=energy2 %></span></td>
				</tr>
				<tr>
					<td><button class="btn btn-primary" id="tangenergy2" type="button" >++</button></td>
					<td><button class="btn btn-primary" id="giamenergy2" type="button" >--</button></td>
				</tr>
				<tr>
					<td>Energy times: <span id="et2">0</span></td>
				</tr>
			</table> 
			<textarea rows="20" cols="50" id="txtThongBao2" readonly="readonly" >
			</textarea>	
		</td>
		<td>
			<textarea rows="55" cols="50" id="txtTB" readonly="readonly" ></textarea>
		</td>
	</tr>
	<tr>
		<td>
		<div class="panel-group">
		  <div class="panel panel-primary">
		    <div class="panel-heading">Winner</div>
		  </div>
		  <div class="panel panel-primary">
		    <div class="panel-body">
		    	<input type="text" id="winner" readonly="readonly" />
		    	<span  id="winnerid" hidden=""></span> <span  id="loseid" hidden=""></span>
		    	<button type="button" id="btnWinner" disabled="disabled" class="btn btn-success">Confirm</button>
		    	<p id="tbWinner" class="red"></p>
		    </div>
		  </div>
		</div>
		</td> 
	</tr>	
</table>




<%
	}
%>

<script type="text/javascript">
$(document).ready(function(){	  
  
	$("#tangenergy").click(function(){
	  var energy = parseInt($("#energy").text());
	  var num = Math.floor(Math.random() * 10) + 1;
	  
	  energy += num;
	  
	  var txtThongBao = $("#txtThongBao").text();
	  txtThongBao = txtThongBao + "+ " + num + " energy \n";
	  $("#txtThongBao").text(txtThongBao);
	  
	  var energyTime = parseInt($("#et").text());
	  energyTime+=1;
	  $("#et").text(energyTime);
	  
	  var energyMax = parseInt($("#energyMax").text());
	  
	  if(energy>=10){
		$("#attack").removeAttr("disabled");
	  }
	  	  	
	  if(energy>=energyMax){
		  energy = energyMax;
	  }
	  
	  var id = $("#idpk").text();
	  
	  $.ajax({
			url : "BattleServlet?action=energy",
			type : 'POST',
			data : {
				id:id,
				energy:energy
			},
			success: function(data){
				$("#energy").text(data);
				console.log(data);
			}
		})
	 
 	})	
  
    $("#tangenergy2").click(function(){
      var energy = parseInt($("#energy2").text());
  	  var num = Math.floor(Math.random() * 10) + 1;
  	  
  	  energy += num;
  	  
  	  var txtThongBao = $("#txtThongBao2").text();
  	  txtThongBao = txtThongBao + "+ " + num + " energy \n";
  	  $("#txtThongBao2").text(txtThongBao);
  	  
  	  var energyTime = parseInt($("#et2").text());
  	  energyTime+=1;
  	  $("#et2").text(energyTime);
  	  
  	  var energyMax = parseInt($("#energyMax2").text());
  	  
  	  if(energy>=10){
  		$("#attack2").removeAttr("disabled");
  	  }
  	  	  	
  	  if(energy>=energyMax){
  		  energy = energyMax;
  	  }
  	  
  	  var id = $("#idpk2").text();	
  	  
  	  $.ajax({
  			url : "BattleServlet?action=energy",
  			type : 'POST',
  			data : {
  				id:id,
  				energy:energy
  			},
  			success: function(data){
  				$("#energy2").text(data);
  				console.log(data);
  			}
  		})
	  
    })
    
    $("#attack").click(function(){    	
    	var hp = parseInt($("#hp2").text());
    	var atk = parseInt($("#atk").text());
    	var energy = parseInt($("#energy").text());
    	
    	var ct = parseInt($("#ct").text());
    	var ctRandom = (Math.random() * 100) + 1; 
    	ctRandom = Math.round(ctRandom * 100) / 100;
    	
    	var cd = parseInt($("#cd").text());
    	var pointCD = 0;
    	
    	
    	var de = parseInt($("#de2").text());
    	var ev = parseInt($("#ev2").text());
    	var evRandom = (Math.random() * 100) + 1 ; 
    	evRandom = Math.round(evRandom * 100) / 100;
    	
    	var bl = parseInt($("#bl2").text());
    	var blperRandom = (Math.random() * 100) + 1; 
    	blperRandom = Math.round(blperRandom * 100)/100
    	
    	var blnumRandom = parseInt($("#blpoint2").text()); 
    	
    	var typePoint = parseInt($("#typePoint").text());
    	var atkgoc = atk;
    	
    	var txtThongBao = $("#txtThongBao").text();
    	
    	$("#perct").text(ctRandom+"%");
    	$("#perev2").text(evRandom+"%");
    	$("#perbl2").text(blperRandom+"%");
    	
    	if(evRandom <= ev){
    		$("#perev2").addClass("green");
    	}
    	else{
    		$("#perev2").addClass("red");
    	}
    	
    	if(ctRandom <= ct){
    		$("#perct").addClass("green");
    	}
    	else{
    		$("#perct").addClass("red");
    	}
    	
    	if(blperRandom <= bl){
    		$("#perbl2").addClass("green");
    	}
    	else{
    		$("#perbl2").addClass("red");
    	}
    	
    	var tb = $("#txtTB").text();
    	var name = $("#name").text();
    	var name2 = $("#name2").text();
    	tb = tb + name + " attack";
    	
    	if(energy>=10){
    		if(hp>0){
    			if(evRandom <= ev){
    				tb = tb + ", " +name2 + " dogged\n";
        			//txtThongBao = txtThongBao + "% EV: " + evRandom + " => atk: 0 \n"; 
        			$("#txtThongBao").text(txtThongBao);
        		}
        		else { 
        			//txtThongBao = txtThongBao + "% EV: " + evRandom + "\t"; 
        			tb = tb + " (atk: " + atk + ")\n"; 
        			
    	    		if(ctRandom <= ct){	 
    	    			pointCD = atk * cd / 100;
    	    			atk*=2;
    	    			tb = tb + " + (CT)  atk: "+atk;
    	    		}
    	    		
    	    		//txtThongBao = txtThongBao + "% CT: " + ctRandom + " => atk: " +atk + "\t";
    	    		
    	    		if(ctRandom <= ct){	    			
    	    			atk += pointCD;
    	    			//txtThongBao = txtThongBao + "% CD: " + cd + " => atk: " +atk + "\n";
    	    			tb = tb + " + (CD)  atk: "+atk;
    	    		}
    	    		
    	    		atk = atk + (atkgoc * typePoint / 100);
    	    		if(atk<0){
    	    			atk=0;
    	    		}
    	    		tb = tb + " + (ATT)  atk: "+atk + "\n";
    	    		//txtThongBao = txtThongBao + "atk + " + typePoint + "% => atk: " +atk + "\t";
    	    		
    	    		atk -= de;
    	    		if(atk<0){
    	    			atk=0;
    	    		}
    	    		tb = tb + " - (DE)  atk: "+atk;
    	    		//txtThongBao = txtThongBao + "DE: " + de + " => atk: " +atk + "\t"; 
    	    		
    	    		if(blperRandom <= bl){
    	    			atk = atk * ((100 - blnumRandom) / 100);
    	    			atk = Math.round(atk);
    	    			tb = tb + " - (BL)  atk: "+atk + "\n";
    	    		}
    	    		else{
    	    			tb += "\n";
    	    		}
	    			
    	    		//txtThongBao = txtThongBao + "BL: " + blperRandom + "% - " + blnumRandom + "%, atk = " +atk+ "\n"; 
    	    		
    	    		txtThongBao = txtThongBao + "atk: " +atk + "\n";
    	    		tb = tb + name + " attacked " + name2 + " " + atk + " damage \n";
    	    		
    	    		hp -= atk;
    	    		if(hp<0){
    	    			hp=0;
    	    		}
        			$("#hp2").text(hp);
        		}
    		}
    		tb += "\n";
    		energy-=10;
    		$("#energy").text(energy);
    		$("#txtThongBao").text(txtThongBao);
    		$("#txtTB").text(tb);
    		if(energy<10){
	    		$("#attack").attr("disabled","");
	    	}    		
    		
    		if(hp==0){
    			$("#pk1").addClass("win");
    		}
    	}
    	
    	
    })
    
    $("#attack2").click(function(){
    	var hp = parseInt($("#hp").text());
    	var atk = parseInt($("#atk2").text());
    	var energy = parseInt($("#energy2").text());
    	
    	var ct = parseInt($("#ct2").text());
    	var ctRandom = (Math.random() * 100) + 1; 
    	ctRandom = Math.round(ctRandom * 100) / 100;
    	
    	var cd = parseInt($("#cd2").text());
    	var pointCD = 0;
    	
    	var de = parseInt($("#de").text());
    	var ev = parseInt($("#ev").text());
    	var evRandom = (Math.random() * 100) + 1;   
    	evRandom = Math.round(evRandom * 100) / 100;
    
    	var bl = parseInt($("#bl").text());
    	var blperRandom = (Math.random() * 100) + 1 ; 
    	blperRandom = Math.round(blperRandom * 100) / 100;
    	
    	var blnumRandom = parseInt($("#blpoint").text());
    	
    	var typePoint = parseInt($("#typePoint2").text());
    	var atkgoc = atk;
    	
    	var txtThongBao = $("#txtThongBao2").text();
    	
    	$("#perct2").text(ctRandom+"%");
    	$("#perev").text(evRandom+"%");
    	$("#perbl").text(blperRandom+"%");
    	
    	if(evRandom <= ev){
    		$("#perev").addClass("green");
    	}
    	else{
    		$("#perev").addClass("red");
    	}
    	
    	if(ctRandom <= ct){
    		$("#perct2").addClass("green");
    	}
    	else{
    		$("#perct2").addClass("red");
    	}
    	
    	if(blperRandom <= bl){
    		$("#perbl").addClass("green");
    	}
    	else{
    		$("#perbl").addClass("red");
    	}
    	
    	var tb = $("#txtTB").text();
    	var name = $("#name2").text();
    	var name2 = $("#name").text();
    	tb = tb + name + " attack";
    	
    	if(energy>=10){
    		if(hp>0){
    			if(evRandom <= ev){
    				tb = tb + ", " +name2 + " dogged\n";
        			//txtThongBao = txtThongBao + "% EV: " + evRandom + " => atk: 0 \n"; 
        			$("#txtThongBao2").text(txtThongBao);
        		}
        		else {
        			tb = tb + " (atk: " + atk + ")\n"; 
        			//txtThongBao = txtThongBao + "% EV: " + evRandom + "\t"; 
    	    		if(ctRandom <= ct){
    	    			pointCD = atk * cd / 100;
    	    			atk*=2;	    			
    	    			tb = tb + " + (CT)  atk: "+atk;
    	    		}
    	    		//txtThongBao = txtThongBao + "% CT: " + ctRandom + " => atk: " +atk + "\t"; 
    	    		
    	    		if(ctRandom <= ct){	    			
    	    			atk += pointCD;
    	    			//txtThongBao = txtThongBao + "% CD: " + cd + " => atk: " +atk + "\n";
    	    			tb = tb + " + (CD)  atk: "+atk;
    	    		}
    	    		
    	    		atk = atk + (atkgoc * typePoint / 100);
    	    		//txtThongBao = txtThongBao + "atk + " + typePoint + "% => atk: " +atk + "\t";
    	    		tb = tb + " + (ATT)  atk: "+atk + "\n";
    	    		
    	    		atk -= de;
    	    		if(atk<0){
    	    			atk=0;
    	    		}
    	    		tb = tb + " - (DE)  atk: "+atk;
    	    		//txtThongBao = txtThongBao + "DE: " + de + " => atk: " +atk + "\t";
    	    		
    	    		if(blperRandom <= bl){
    	    			atk = atk * ((100 - blnumRandom) / 100);  
    	    			atk = Math.round(atk);
    	    			tb = tb + " - (BL)  atk: "+atk + "\n";
    	    		}
    	    		else{
    	    			tb += "\n";
    	    		}
    	    		
    	    		//txtThongBao = txtThongBao + "BL: " + blperRandom + "% - " + blnumRandom + "%, atk = " +atk+ "\n"; 
    	    		
    	    		
    	    		txtThongBao = txtThongBao + "atk: " +atk + "\n"; 
    	    		tb = tb + name + " attacked " + name2 + " " + atk + " damage \n";
    	    		
    	    		hp = hp - atk;
    	    		if(hp<0){
    	    			hp=0;
    	    		}
        			$("#hp").text(hp);
    	    	}
    		}
    		tb += "\n";
    		
    		energy-=10;
    		$("#energy2").text(energy);
    		$("#txtThongBao2").text(txtThongBao);
    		$("#txtTB").text(tb);
    		
    		if(energy<10){
	    		$("#attack2").attr("disabled","");
	    	}	    		
    		
    		if(hp==0){
    			$("#pk2").addClass("win");
    		}
    	}
    })
    
    
    $("#btnWinner").click(function(){
   		var id = $("#winnerid").text();
   		var id2 = $("#loseid").text();
   		$.ajax({
   			url : "BattleServlet?action=winner",
   			type : 'POST',
   			data : {
   				id:id,
   				id2:id2
   			},
   			success: function(data){
   				$("#tbWinner").text(data);
   			}
   		})
   	})
})
</script>

</body>
</html>