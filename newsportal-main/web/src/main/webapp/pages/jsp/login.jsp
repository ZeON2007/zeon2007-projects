<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>News Portal</title>
    <link rel="stylesheet" href="css/styles.css" />
</head>
<body>
    <h1>Авторизация</h1>
    <p>Введите свои данные в представленной форме:</p>
    <form action="controller" method="POST">
        <input type="hidden" name="command" value="login">

        <label class="pad_top">Email:</label>
        <input type="email" name="email" value="${author.email}" required><br>

        <label class="pad_top">Password:</label>
        <input type="password" name="password" value="${author.password}" required><br>

        ${errorLoginOrPassword}<br>

        <label class="pad_top">&nbsp;</label>
        <input type="submit" value="ВОЙТИ" class="margin_left"><br>

        <a href="<c:url value="controller">
                        <c:param name="command" value="gotoMainPage" />
                    </c:url>" >
            Перейти на главную страницу
        </a>
    </form>
</body>
</html>