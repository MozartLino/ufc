<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<c:url value='js/jquery-1.8.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='js/perfil.js'/>"></script>

<title>Perfil</title>
</head>
<body>
	<table>
		<c:forEach var="perfil" items="${perfilList}">
			<tr id="${perfil.id}">
				<td>${perfil.perfil}</td>
				<td>${perfil.descricao}</td>
				<td><a href="<c:url value='/perfil/${perfil.id}' />">
						alterar</a></td>
				<td><a href="javascript:void(0);"
					onclick="remover('${perfil.id}')"> remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>