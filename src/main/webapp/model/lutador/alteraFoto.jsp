<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>
	<form action="<c:url value='/usuario/alterafoto'/>" method="post"
		enctype="multipart/form-data">

		<input type="file" name="file"> 
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>