<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${userType == 'AUTHOR'}">
    <ul class="list-unstyled">
        <a href="<c:url value="controller">
                    <c:param name="command" value="gotoAddNewsPage" />
                </c:url>" >
            ADD
        </a><br>
        <c:forEach var="news" items="${newsList}">
            <li>
                <a href="<c:url value="controller">
                        <c:param name="command" value="gotoBodytextPage" />
                        <c:param name="selectedNewsId" value="${news.id}" />
                    </c:url>" >
                    <c:out value="${news.name}"/>
                </a>
            </li>
            <li>
                <c:out value="${news.description}"/>
            </li>
            <li>
                <c:out value="${news.date}"/>
            </li>
            <a href="<c:url value="controller">
                    <c:param name="command" value="deleteNews" />
                    <c:param name="selectedNewsId" value="${news.id}" />
                </c:url>" >
                DELETE
            </a>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${userType != 'AUTHOR'}">
    <ul class="list-unstyled">
        <c:forEach var="news" items="${newsList}">
            <li>
                <a href="<c:url value="controller">
                            <c:param name="command" value="gotoBodyTextPage" />
                            <c:param name="selectedNewsId" value="${news.id}" />
                        </c:url>" >
                    <c:out value="${news.name}"/>
                </a>
            </li>
            <li>
                <c:out value="${news.description}"/>
            </li>
            <li>
                <c:out value="${news.date}"/>
            </li>
        </c:forEach>
    </ul>
</c:if>