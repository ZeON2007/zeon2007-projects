<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Ошибка</title>
	</head>
	<body>
		<h2>Ошибка:</h2>
		${requestScope.errorDatabase} <br/>
		${requestScope.errorCriterion} <br/>
		<a href="<c:url value="controller">
                    <c:param name="command" value="gotoMainPage" />
                 </c:url>" >
			Перейти на главную страницу.
		</a>
	</body>
</html>