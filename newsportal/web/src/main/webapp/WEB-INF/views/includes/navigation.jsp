<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav lead">
    <c:forEach var="category" items="${categoryList}">
        <li>
            <a href="<c:url value="/category">
                            <c:param name="selectedCategoryId" value="${category.id}" />
                        </c:url>" >
                <c:out value="${category.category}"/>
            </a>
        </li>
    </c:forEach>
</ul>