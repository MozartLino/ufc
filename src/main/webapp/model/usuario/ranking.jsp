<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value='/js/angular.min.js' />"
	type="text/javascript"></script>
	<script src="<c:url value='/js/model/user.js' />"
	type="text/javascript"></script>

<title>VRaptor Blank Project</title>
</head>
<body ng-app ng-controller="usuarioRankingController">


	<table>
		<tr ng-repeat="usuario in usuarios" id="{{usuario.id}}">
			<td>{{usuario.nome}}</td>
			<td>{{usuario.login}}</td>
			<td>{{usuario.cpf}}</td>
			<td>{{usuario.email}}</td>
			<td>{{usuario.pontos}}</td>
		</tr>
	</table>
</body>
</html>