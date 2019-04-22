<%@page import="entities.item"%>
<%@page import="model.cartModel"%>
<%@page import="model.productModel"%>
<%@page import="entities.product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>My Cart</title>
</head>
<body>

<h1>My Cart</h1>
<br>
<%
	ArrayList<item> cart = (ArrayList<item>) request.getAttribute("cart");
	if(cart.size()==0){
%>
	<br>
	<h3>Giỏ hàng rỗng</h3>
	<br>
	<a href="index.jsp">Quay lại trang chủ</a>
<%
	}
	else{
%>
<form action="cartServlet" method="post">
<table class="table" style="margin-top:20px">
  <thead>
    <tr>
      <th scope="col">Mã sản phẩm</th>
      <th scope="col">Tên sản phẩm</th>
      <th scope="col">Hình</th>
      <th scope="col">Giá</th>
      <th scope="col">Số lượng</th>
      <th scope="col">Tổng</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:set var="total" value="0" />
  <c:forEach var="i" items="<%=cart %>" >
    <tr>
      <td>${i.sanpham.masp }</td>
      <td>${i.sanpham.tensp }</td>
      <td><img src="image/${i.sanpham.hinh }" width="90px" height="120px"/></td>
      <td><fmt:formatNumber value="${i.sanpham.gia}" type="number" maxFractionDigits="3" /> VND</td>
      <td>${i.soluong}</td>
      <td><fmt:formatNumber value="${i.sanpham.gia * i.soluong }" type="number" maxFractionDigits="3" /> VND</td>
      <td><a href="cartServlet?action=delete&masp=${i.sanpham.masp }">Xóa</a></td>
      <c:set var="total" value="${total + (i.sanpham.gia * i.soluong) }" />
    </tr>
  </c:forEach>
  </tbody>
  <tbody>
  	<tr>
  		<td colspan="7">
  			<center><h3>Tổng tiền: <fmt:formatNumber value="${total }" type="number" maxFractionDigits="3" /> VND</h3></center>
  		</td>
  	</tr>
  </tbody>
  <tbody>
  	<tr>
  		<td colspan="2">
  			<a href="index.jsp">Tiếp tục mua</a>
  		</td>
  		<td colspan="3">
  			<button type="submit" class="btn btn-primary">Đặt mua</button>
  		</td>
  		<td colspan="2">
  			<a href="cartServlet?action=deleteAll">Xóa giỏ hàng</a>
  		</td>
  	</tr>
  </tbody>
</table>
</form>
<% 
	}
%>

</body>
</html>