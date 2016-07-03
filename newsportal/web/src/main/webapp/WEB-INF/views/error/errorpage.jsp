<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
Ошибка 404. Нет такой страницы.<br/>
Если Вы считаете, что страницы нет по нашей вине, то можете подать на нас в суд.<br/>

<a href="<c:url value="controller">
                    <c:param name="command" value="" />
                 </c:url>" >
    Перейти на главную страницу.
</a>
</body>
</html>