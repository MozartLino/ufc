<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<c:url value='/js/jquery-1.8.2.min.js'/>"></script>
<title>VRaptor Blank Project</title>
</head>
<body>

	<form action="<c:url value='/logar'/>" method="post" id="form">

		<input id="login" name="usuario.login" value=""> <input
			id="senha" name="usuario.senha" value=""> <input
			type="submit">

	</form>

</body>
</html>