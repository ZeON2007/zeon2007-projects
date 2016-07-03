<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="list-unstyled">
    <li id="newsName">
        <c:out value="${news.name}"/>
    </li>
    <li id="description">
        <c:out value="${news.mainText}"/>
    </li>
    <li id="date">
        <c:out value="${news.date} | ${author.firstName} ${author.lastName}"/>
    </li>
</ul>