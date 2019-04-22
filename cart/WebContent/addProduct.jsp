<%@page import="model.danhmucModel"%>
<%@page import="entities.danhmuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Add Product</title>
</head>
<body>
<h2>Add Product</h2>
<%
	ArrayList<danhmuc> list = new danhmucModel().getList();
%>
	<form enctype="multipart/form-data" action="productServlet?action=add" method="post">
		<table style="margin-top:20px">
		<tr>
			<td><label for="inputmasp">Mã sản phẩm</label></td>
    		<td><input type="text" class="form-control" id="inputmasp" placeholder="Nhập mã sản phẩm" name="masp"></td>
		</tr>
		<tr>
			<td><label for="inputtensp">Tên sản phẩm</label></td>
    		<td><input type="text" class="form-control" id="inputtensp" placeholder="Nhập tên sản phẩn" name="tensp"></td>
		</tr>
		<tr>
			<td><label for="inputgia">Giá</label></td>
    		<td><input type="number" class="form-control" id="inputgia" placeholder="Nhập giá" name="gia"></td>
		</tr>
		<tr>
			<td><label for="selecthinh">Hình</label></td>
			<td><input type="file" name="file" id="selecthinh"></td>
		</tr>
		<tr>
			<td><label for="inputdm">Mã danh mục</label></td>
    		<td>
    			<select name="madm">
    				<c:forEach var="i" items="<%=list %>">
    					<option value="${i.madm }">${i.tendm }</option>
    				</c:forEach>
    			</select>
    		</td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit" class="btn btn-primary">Add</button></td>
		</tr>
	</table>
	</form>

</body>
</html>