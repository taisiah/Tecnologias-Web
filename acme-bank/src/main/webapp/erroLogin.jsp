<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ErrorLogin</title>
</head>
<body>
	<div align="center">
		<c:if test="${error != null}">
			<p><strong>${error}</strong></p>
		</c:if>
	</div>
	<div align ="center">
		<input  type="submit" value ="VOLTAR" id="btn-voltar" onClick="Voltar()">
		<script type="text/javascript">
		function Voltar ()
		{
		location.href="login.jsp"
		}
		</script>
	
	
	</div>
</body>
</html>