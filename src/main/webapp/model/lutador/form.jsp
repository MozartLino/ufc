<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>

	<form action="<c:url value='confronto/salva'/>" method="POST" enctype="multipart/form-data">

		Evento : <input type="text" id="nome" name="confronto.evento" value="${usuario.nome}"> <br />
		<!-- -->
		Data <input type="text" id="cpf" name="confronto.data" value="${usuario.cpf}"> <br />
		<!-- -->
		1° Lutador : <input type="text" id="email" name="confronto.lutador1" value="${usuario.email}"> <br />
		<!-- -->
		2° Lutador : <input type="text" id="email" name="confronto.lutador2" value="${usuario.email}"> <br />
		<!-- -->
		Categoria : <input type="password" id="senha" name="confronto.categoria" value="${usuario.senha}"> <br />
		<!-- -->
		<input type="submit" value="Enviar" />
	</form>

</body>
</html>