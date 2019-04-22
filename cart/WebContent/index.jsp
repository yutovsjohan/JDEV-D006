<%@page import="model.danhmucModel"%>
<%@page import="entities.danhmuc"%>
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

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>View page</title>
</head>
<body>
<h2>List Product</h2>
<br>

<%
if(request.getAttribute("msg") != null){
%>
<div class="alert alert-<%= request.getAttribute("chuoi") %>" role="alert">
  <%= request.getAttribute("msg") %>
</div>
<br>

<%
}
%>

<a href="addProduct.jsp">Add Product</a> | <a href="cartServlet?action=viewcart">View cart</a>

<table class="table" style="margin-top:20px">
  <thead>
    <tr>
      <th scope="col">Mã sản phẩm</th>
      <th scope="col">Tên sản phẩm</th>
      <th scope="col">Hình</th>
      <th scope="col">Giá</th>
      <th scope="col">Danh mục</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <% 
  	productModel promodel = new productModel(); 
  	danhmucModel dm = new danhmucModel(); 
  %>
  <c:set var="dm" value="<%=dm %>" />
  <c:forEach var="i" items="<%=promodel.getList() %>" >
  <c:set var="tendm" value="${dm.getTendmByMadm(i.madm) }" />
    <tr>
      <td>${i.masp }</td>
      <td>${i.tensp }</td>
      <td><img src="image/${i.hinh }" width="120px" height="150px"/></td>
      <td>
      	<fmt:formatNumber value="${i.gia}" type="number" maxFractionDigits="3" /> VND
      </td>
      <td>${tendm }</td>
      <td>
      	<a href="cartServlet?action=add&masp=${i.masp}">Add to cart</a> | <a href="updateProduct.jsp?masp=${i.masp}">Update</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>