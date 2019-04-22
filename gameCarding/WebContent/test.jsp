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

<title>test</title>
</head>
<body>
<h3><a href="index.jsp">back</a> || <a href="test.jsp">Reload</a></h3>
<br>
<%
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
					<td id="idpk" hidden="">1</td>
					<td id="name">HOPE</td> 
				</tr>
				<tr>
					<td>lv: 100</td> 
				</tr>
				<tr>
					<td>type: <span id="type"></span></td>
				</tr>
				<tr>
					<td>AT: <input type="number" id="atk" value="5000" style="width:70px"></td>
					<td>Heal: <input type="number" id="heal" value="10" style="width:70px"></td>
				</tr>
				<tr>
					<td>HP: <input type="number" id="hp" value="1000000" style="width:100px"></td>
					<td>Drain punch: <input type="number" id="drain" value="100" style="width:70px"></td>
				</tr>
				<tr>
					<td>DE: <input type="number" id="de" value="300" style="width:70px"></td>
					<td>reflection: <input type="number" id="reflection" value="50" style="width:70px"></td>
				</tr>
				<tr>
					<td>CT: <input type="number" id="ct" value="100" style="width:70px"></td>
					<td><span id="perct" ></span></td>
				</tr>
				<tr>
					<td>CD: <input type="number" id="cd" value="500" style="width:70px"></td> 
				</tr>
				<tr>
					<td>EV: <input type="number" id="ev" value="30" style="width:70px"></td>
					<td><span id="perev" ></span></td>
				</tr>
				<tr>
					<td>BL: <input type="number" id="bl" value="100" style="width:70px"></td>
					<td><span id="perbl" ></span></td>
				</tr>
				<tr>
					<td>status: <span id="status"></span></td>
					<td  id="sttime" hidden>0</td>
				</tr>
				<tr>
					<td>
						<select size="5" id="move">
						  <option value="attack" selected>attack</option>
						  <option value="icebeam">ice beam</option>
						  <option value="blastburn">blast burn</option>
						  <option value="gigadrain">giga drain</option>
						</select>
						<button class="btn btn-primary" id="attack" type="button">attack</button>
					</td>
				</tr>
			</table> 
			
			<textarea rows="20" cols="50" id="txtThongBao" readonly="readonly" >
			</textarea>
		</td>		
				
		<td  style="padding:20px" id="pk2">						
			<table style="margin:20px">			
				<tr>
					<td id="idpk2" hidden="">2</td>
					<td id="name2">MIRAI</td>
				</tr>				
				<tr>
					<td>lv: 100</td>
				</tr>
				<tr>
					<td>type: <span id="type"></span></td>
				</tr>
				<tr>
					<td>AT: <input type="number" id="atk2" value="5000" style="width:70px"></td>
					<td>Heal: <input type="number" id="heal2" value="10" style="width:70px"></td>
				</tr>
				<tr>
					<td>HP: <input type="number" id="hp2" value="1000000" style="width:100px"></td>
					<td>Drain punch: <input type="number" id="drain2" value="100" style="width:70px"></td>
				</tr>
				<tr>
					<td>DE: <input type="number" id="de2" value="300" style="width:70px"></td>
					<td>reflection: <input type="number" id="reflection2" value="50" style="width:70px"></td>
				</tr>
				<tr>
					<td>CT: <input type="number" id="ct2" value="100" style="width:70px"></td>
					<td><span id="perct2" ></span></td>
				</tr>
				<tr>
					<td>CD: <input type="number" id="cd2" value="500" style="width:70px"></td> 
				</tr>
				<tr>
					<td>EV: <input type="number" id="ev2" value="30" style="width:70px"></td>
					<td><span id="perev2" ></span></td>
				</tr>
				<tr>
					<td>BL: <input type="number" id="bl2" value="100" style="width:70px"></td>
					<td><span id="perbl2" ></span></td>
				</tr> 
				<tr>
					<td>status: <span id="status2"></span></td>
					<td  id="sttime2" class="red">0</td>
				</tr>
				<tr>
					<td>
						<select size="5" id="move2">
						  <option value="attack" selected>attack</option>
						  <option value="icebeam">ice beam</option>
						  <option value="blastburn">blast burn</option>
						  <option value="gigadrain">giga drain</option>
						</select>
						<button class="btn btn-primary" id="attack2" type="button">attack</button>
					</td>
				</tr>
				</tr>
			</table> 
			<textarea rows="20" cols="50" id="txtThongBao2" readonly="readonly" >
			</textarea>	
		</td>
		<td>
			turn <span id="turn">1</span> <br> 
			<textarea rows="35" cols="50" id="txtTB" readonly="readonly" ></textarea>
		</td>
	</tr>	
</table>


<script type="text/javascript">
$(document).ready(function(){	  
	function changeturn() {
		var turn = parseInt($("#turn").text());
       	turn++;
       	$("#turn").text(turn);
       	
       	// -------  status 2  -------
       	var status2 = $("#status2").text();
       	
       	if(status2 != ""){
       		if(status2 == "freeze" || status2 == "sleep"){
		       	var sttime2 = parseInt($("#sttime2").text());
				sttime2++;
				$("#sttime2").text(sttime2);
				
				if(sttime2 == 4){
					$("#status2").text("");
					$("#sttime2").text("0");
				}
				else{
					var txttb2 = $("#txtThongBao2").text();
					txttb2 += status2 + "\n";
					$("#txtThongBao2").text(txttb2);
				}
       		}
       		else{
       			$("#sttime2").text("0");
       			
       			var txttb2 = $("#txtThongBao2").text();
				txttb2 += status2;
				
				if(status2 == "burn"){
       				var hp2 = parseInt($("#hp2").val());
       				hp2 -= 5000;
       				$("#hp2").val(hp2);
       				txttb2 += ", -5000 HP\n";
       			}				
				
				$("#txtThongBao2").text(txttb2);
       		}
       	}
		
		
		//  ------- status 1  -------
		var status = $("#status").text();
		
		if(status != 0){
			var sttime = parseInt($("#sttime").text());
			sttime++;
			$("#sttime").text(sttime);
			
			if(sttime == 4){
				$("#status").text("");
				$("#sttime").text("0");
			}
			else{
				var txttb = $("#txtThongBao").text();
				if(status == "sleep")
					txttb += "sleep\n";
				else if(status == "freeze")
					txttb += "freeze\n";
				
				$("#txtThongBao").text(txttb);
			}
		}
		//----------------------------
	}

	$("#attack").click(function(){
		changeturn(); 
		
		var move = $("#move");
		var select = move.val();
		
		var hp = parseInt($("#hp").val());	
		var hp2 = parseInt($("#hp2").val());
    	var atk = parseInt($("#atk").val());    	
    	
    	var ct = parseInt($("#ct").val());
    	var ctRandom = (Math.random() * 100) + 1; 
    	ctRandom = Math.round(ctRandom * 100) / 100;
    	
    	var cd = parseInt($("#cd").val());
    	var pointCD = 0; 
    	
    	var de = parseInt($("#de2").val());
    	var ev = parseInt($("#ev2").val());
    	var evRandom = (Math.random() * 100) + 1 ; 
    	evRandom = Math.round(evRandom * 100) / 100;
    	
    	var bl = parseInt($("#bl2").val());
    	var blnumRandom = (Math.random() * 100) + 1; 
    	blnumRandom = Math.round(blnumRandom * 100)/100;
		
		if(select == "attack"){				    	
	    	var atkgoc = atk; 
	    	
	    	var txtThongBao = $("#txtThongBao").text();
	    	$("#perct2").text("");
	    	$("#perev").text("");
	    	$("#perbl").text("");
	    	
	    	$("#perct").text(ctRandom+"%");
	    	$("#perev2").text(evRandom+"%");
	    	$("#perbl2").text(blnumRandom+"%");
	    	
	    	if(evRandom <= ev){
	    		$("#perev2").removeClass("red");
	    		$("#perev2").addClass("green");
	    	}
	    	else{
	    		$("#perev2").removeClass("green");
	    		$("#perev2").addClass("red");
	    	}
	    	
	    	if(ctRandom <= ct){
	    		$("#perct").removeClass("red");
	    		$("#perct").addClass("green");
	    	}
	    	else{
	    		$("#perct").removeClass("green");
	    		$("#perct").addClass("red");
	    	}
	    	
	    	if(blnumRandom <= bl){
	    		$("#perbl2").removeClass("red");
	    		$("#perbl2").addClass("green");
	    	}
	    	else{
	    		$("#perbl2").removeClass("green");
	    		$("#perbl2").addClass("red");
	    	}
	    	
	    	var tb = $("#txtTB").text();
	    	var name = $("#name").text();
	    	var name2 = $("#name2").text();
	    	tb = tb + name + " attack";
	    	
	    	var heal = parseInt($("#heal").val());
	    	var drain = parseInt($("#drain").val());
	    	var reflection = parseInt($("#reflection").val());
	    		    	
	   		if(hp2>0){
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
	   	    			tb = tb + " + (CD)  atk: "+atk + "\n";
	   	    		}
	   	    		
	   	    		atk -= de;
	   	    		if(atk<0){
	   	    			atk=0;
	   	    		}
	   	    		tb = tb + " - (DE)  atk: "+atk;
	   	    		//txtThongBao = txtThongBao + "DE: " + de + " => atk: " +atk + "\t"; 
	   	    		
	   	    		if(blnumRandom <= bl){
	   	    			atk = atk * ((100 - blnumRandom) / 100);
	   	    			atk = Math.round(atk);
	   	    			tb = tb + " - (BL)  atk: "+atk + "\n";
	   	    		}
	   	    		else{
	   	    			tb += "\n";
	   	    		}
	    			
	   	    		//txtThongBao = txtThongBao + "BL: " + blperRandom + "% - " + blperRandom + "%, atk = " +atk+ "\n"; 
	   	    		
	   	    		txtThongBao = txtThongBao + "atk: " +atk + "\n";
	   	    		
	   	    // 		---------------  heal hp  ----------------------
	   	    		
	   	    		var healhp = Math.round(hp * heal / 1000);
	   	    		
	   	    		txtThongBao += "+" + healhp + " hp";
	   	    		hp += healhp;
	   	    		
	   	    		healhp = Math.round(atk * drain / 1000);
	   	    		txtThongBao += ", +" + healhp + " hp";
	   	    		hp += healhp;
	   	    		
	   	    		$("#hp").val(hp);
	   	    		
	   	    // 		---------------  heal hp  ----------------------
	   	    
	   	    //		---------------  reflection  -------------------
	   	    		var ref = Math.round(atk * reflection /100);
	   	    		txtThongBao += ", -" + ref + " hp\n";
	   	    		hp -= ref;
	   	    		
	   	    		if(hp < 0){
	   	    			hp = 0;
	   	    		}
	   	    		
	   	    		$("#hp").val(hp);
	   	    //		---------------  reflection  -------------------
	   	    		
	   	    		tb = tb + name + " attacked " + name2 + " " + atk + " damage \n";
	   	    		
	   	    		hp2 -= atk;
	   	    		if(hp2<0){
	   	    			hp2=0;
	   	    		}
	       			$("#hp2").val(hp2);
	       		}
	   		}
	   		tb += "\n";
	
	   		$("#txtThongBao").text(txtThongBao);
	   		$("#txtTB").text(tb);
			    	
	   		//$("#attack").attr("disabled","");
	   		//$("#attack2").removeAttr("disabled");
		}
		else{
			var status2 = $("#status2").text(); 
	   		$.ajax({
	   			url : "testServlet",
	   			type : 'GET',
	   			data : {
	   				select: select,
	   				hp2: hp2,
	   				hp: hp
	   			},
	   			success: function(data){
	   				var arr = data.split(",");
	   				$("#hp2").val(arr[0]);
	   				
	   				if(arr[1] != ""){
	   					$("#status2").text(arr[1]);
	   				}
	   				
	   				if(arr[1] == "freeze" || arr[1] == "sleep"){
	   					$("#sttime2").text("0");
	   				}
	   				
	   				var txttb = $("#txtThongBao").text();
	   				
	   				$("#hp").val(arr[3]);
	   				var curhp = hp;
	   				hp = arr[3];
	   				
	   				if(hp != curhp){
	   					var addhp = hp - curhp;
	   					if(addhp > 0)
	   						txttb += "+" + addhp + " hp";
	   					else
	   						txttb += addhp + " hp";
	   				}
	   				
	   				if(arr[2]!=100){
	   					txttb += arr[2];
	   				}
	   				
	   				txttb += "\n";
	   				$("#txtThongBao").text(txttb);
	   			}
	   		})
		}
		
		
    })
    
    $("#attack2").click(function(){
    	changeturn();
    	
    	var move = $("#move2");
		var select = move.val();
				
    	var hp = parseInt($("#hp").val());
    	var hp2 = parseInt($("#hp2").val());
    	var atk = parseInt($("#atk2").val());
    	var energy = parseInt($("#energy2").val());
    	
    	var ct = parseInt($("#ct2").val());
    	var ctRandom = (Math.random() * 100) + 1; 
    	ctRandom = Math.round(ctRandom * 100) / 100;
    	
    	var cd = parseInt($("#cd2").val());
    	var pointCD = 0;
    	
    	var de = parseInt($("#de").val());
    	var ev = parseInt($("#ev").val());
    	var evRandom = (Math.random() * 100) + 1;   
    	evRandom = Math.round(evRandom * 100) / 100;
    
    	var bl = parseInt($("#bl").val());
    	var blperRandom = (Math.random() * 100) + 1 ; 
    	blperRandom = Math.round(blperRandom * 100) / 100;
    	
    	var status2 = $("#status2").text();
    	var isAttack = true;
    	
		if(status2 == "freeze" || status2 == "sleep"){
			isAttack = false;			
		}
    	
    	if(select == "attack" && isAttack == true){	
	    	var atkgoc = atk;
	    	
	    	var txtThongBao = $("#txtThongBao2").text();
	    	
	    	$("#perct").text("");
	    	$("#perev2").text("");
	    	$("#perbl2").text("");
	    	
	    	$("#perct2").text(ctRandom+"%");
	    	$("#perev").text(evRandom+"%");
	    	$("#perbl").text(blperRandom+"%");
	    	
	    	if(evRandom <= ev){
	    		$("#perev").removeClass("red");
	    		$("#perev").addClass("green");
	    	}
	    	else{
	    		$("#perev").removeClass("green");
	    		$("#perev").addClass("red");
	    	}
	    	
	    	if(ctRandom <= ct){
	    		$("#perct2").removeClass("red");
	    		$("#perct2").addClass("green");
	    	}
	    	else{
	    		$("#perct2").removeClass("green");
	    		$("#perct2").addClass("red");
	    	}
	    	
	    	if(blperRandom <= bl){
	    		$("#perbl").removeClass("red");
	    		$("#perbl").addClass("green");
	    	}
	    	else{
	    		$("#perbl").removeClass("green");
	    		$("#perbl").addClass("red");
	    	}
	    	
	    	var tb = $("#txtTB").text();
	    	var name = $("#name2").text();
	    	var name2 = $("#name").text();
	    	tb = tb + name + " attack";
			
	    	var heal = parseInt($("#heal2").val());
	    	var drain = parseInt($("#drain2").val());
	    	var reflection = parseInt($("#reflection2").val());
	    	
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
	   	    			tb = tb + " + (CD)  atk: "+atk + "\n";
	   	    		}
	   	    		
	   	    		    	    		
	   	    		atk -= de;
	   	    		if(atk<0){
	   	    			atk=0;
	   	    		}
	   	    		tb = tb + " - (DE)  atk: "+atk;
	   	    		//txtThongBao = txtThongBao + "DE: " + de + " => atk: " +atk + "\t";
	   	    		
	   	    		if(blperRandom <= bl){
	   	    			atk = atk * ((100 - blperRandom) / 100);  
	   	    			atk = Math.round(atk);
	   	    			tb = tb + " - (BL)  atk: "+atk + "\n";
	   	    		}
	   	    		else{
	   	    			tb += "\n";
	   	    		} 
	   	    		 
	   	    		//txtThongBao = txtThongBao + "BL: " + blperRandom + "% - " + blperRandom + "%, atk = " +atk+ "\n"; 
	   	    		
	   	    		
	   	    		txtThongBao = txtThongBao + "atk: " +atk + "\n"; 
					
	   	    // 		---------------  heal hp  ----------------------
	   	    		var healhp = Math.round(hp * heal / 1000);
	   	    		
	   	    		txtThongBao += "+" + healhp + " hp";
	   	    		hp2 += healhp;
	   	    		
	   	    		healhp = Math.round(atk * drain / 1000);
	   	    		txtThongBao += ", +" + healhp + " hp";
	   	    		hp2 += healhp;
	   	    		
	   	    		$("#hp2").val(hp2);
	   	    		
	   	    // 		---------------  heal hp  ----------------------
	   	    
	   	     //		---------------  reflection  -------------------
	   	    		var ref = Math.round(atk * reflection /100);
	   	    		txtThongBao += ", -" + ref + " hp\n";
	   	    		hp2 -= ref;
	   	    		if(hp2 < 0){
	   	    			hp2 = 0;
	   	    		}
	   	    		
	   	    		$("#hp2").val(hp2);
	   	    //		---------------  reflection  -------------------
	   	    		
	   	    		tb = tb + name + " attacked " + name2 + " " + atk + " damage \n";
	   	    		
	   	    		hp = hp - atk;
	   	    		if(hp<0){
	   	    			hp=0;
	   	    		}
	       			$("#hp").val(hp);
	   	    	}
	   		}
	   		tb += "\n";
	   		$("#txtThongBao2").text(txtThongBao);
	   		$("#txtTB").text(tb);
	   		
    	}
    	
    	     	
       	
     	//$("#attack2").attr("disabled","");
     	//$("#attack").removeAttr("disabled");
    	
    })
        
})
</script>

</body>
</html>