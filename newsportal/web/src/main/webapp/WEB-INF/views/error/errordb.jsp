<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Ошибка</title>
	</head>
	<body>
		Извините, но в данный момент сервис не доступен: <br/>
		${errorDatabase} <br/>
		<a href="<c:url value="controller">
                    <c:param name="command" value="" />
                 </c:url>" >
			Назад
		</a>
	</body>
</html>