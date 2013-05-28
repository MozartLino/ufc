<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<c:url value='js/jquery-1.8.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='js/ajax.js'/>"></script>

<title>VRaptor Blank Project</title>
</head>
<body>
	<table>
		<c:forEach var="usuario" items="${usuarioList}">
			<tr id="${usuario.id}">
				<td>${usuario.nome}</td>
				<td>${usuario.login}</td>
				<td>${person.cpf}</td>
				<td>${person.email}</td>
				<td><a href="<c:url value='/usuario/altera/${usuario.id}' />">
						alterar</a></td>
				<td><a href="javascript:void(0);"
					onclick="remover('${usuario.id}')"> remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>