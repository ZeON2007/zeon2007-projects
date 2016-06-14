<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Количество элементов на странице:</p>
<div>
    <span>
        <form action="controller" method="GET">
            <input type="hidden" name="command" value="updatePage">
            <input type="submit" value="ВЫБРАТЬ" >
            <select name="quantityPerPage" >
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="20">20</option>
                <option value="100">100</option>
            </select>
        </form>
    </span>
    <span>
        <c:forEach var="item" items="${sessionScope.paginationMenu}">

                <a href="<c:url value="controller">
                                <c:param name="command" value="updatePage" />
                                <c:param name="selectedPage" value="${item}" />
                            </c:url>" >
                    <c:out value="${item}"/>
                </a>

        </c:forEach>
    </span>
</div>
<br>
<p>&copy; Copyright 2016 Александр Гержот </p>
</body>
</html>