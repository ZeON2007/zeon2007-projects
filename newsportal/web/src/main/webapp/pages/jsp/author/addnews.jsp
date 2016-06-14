<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News Portal</title>
        <link rel="stylesheet" href="css/styles.css" />
    </head>
    <body>
        <h1>Добавление новости</h1>
        <h2>Заполните форму:</h2>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="addNews">

            <label class="pad_top">Номер категории:</label>
            <input type="text" name="categoryId" value="" required><br>

            <label class="pad_top">Название:</label>
            <input type="text" name="name" value="" required><br>

            <label class="pad_top">Краткое описание:</label>
            <input type="text" name="description" value="" required><br>

            <label class="pad_top">Основной текст:</label>
            <textarea rows="10" cols="30" name="maintext" required></textarea><br>

            <label class="pad_top">&nbsp;</label>
            <input class="margin_left" type="submit" value="ДОБАВИТЬ"><br>
        </form>
    </body>
</html>