<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<c:url value='js/jquery-1.8.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='js/geral.js'/>"></script>

<title>UFC_BD Videos</title>
</head>
<body>
	<table>
		<c:forEach var="video" items="${videoList}">
			<tr id="${video.id}">
				<td>${video.url}</td>
				<td><a href="<c:url value='/video/altera/${video.id}' />">
						alterar</a></td>
				<td><a href="javascript:void(0);"
					onclick="remover('${video.id}', 'video')"> remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>