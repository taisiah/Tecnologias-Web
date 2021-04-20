<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.*, br.com.bank.dao.*, br.com.bank.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>

	<div align="center">
		<c:if test="${user != null}">
			<p>Seja bem vindo, Sr. <strong>${user}</strong>  </p>
		</c:if>
	</div>
	
	<div align="center">
		<p>CLIENTES CADASTRADOS</p>
		<jsp:useBean id="dao" class="br.com.bank.dao.ClientDaoImpl"></jsp:useBean>
		<table border ="1">
		<tr>
			<td>NOME</td>
			<td>EMAIL</td>
			<td>PHONE</td>
			<td>ID</td>
		</tr>
		<tr>
		</tr>
		
		<c:forEach var="client" items="${dao.all}">
			<tr>
				<td>${client.name}</td>
				<td>${client.email}</td>
				<td>${client.phone}</td>
				<td>${client.id}</td>
			</tr>
		</c:forEach>
		</table>
	<br/>
	</div>
	<div align="center">
	<input  type="submit" value="DELETAR " id="btn-deletar" onClick="Deletar()">
	<script type="text/javascript">
	function Deletar ()
	{
		location.href="delete.jsp"
	}
	</script>
	<input  type="submit" value ="NOVO CADASTRO" id="btn-cadastro" onClick="Cadastro()">
	<script type="text/javascript">
	function Cadastro ()
	{
		location.href="add_client.jsp"
	}
	</script>
	</div>
	
	
</body>
</html>