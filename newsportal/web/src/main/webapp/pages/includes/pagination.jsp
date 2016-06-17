<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="loc"/>
<fmt:message bundle="${loc}" key="message.quantity" var="m_quantity"/>

<p>
    <c:forEach var="item" items="${sessionScope.paginationMenu}" varStatus="status">

        <c:if test="${!status.first}">
            <c:if test="${sessionScope.paginationMenu[status.index] - sessionScope.paginationMenu[status.index - 1] != 1}">
                <span class="lead">...</span>
            </c:if>
        </c:if>

        <c:if test="${item != sessionScope.paginationParams['selectedPage']}">
            <a class="lead" href="<c:url value="controller">
                                    <c:param name="command" value="updatePage" />
                                    <c:param name="selectedPage" value="${item}" />
                                </c:url>" >
                <c:out value="${item}"/>
            </a>
        </c:if>
        
        <c:if test="${item == sessionScope.paginationParams['selectedPage']}">
            <span class="lead"><c:out value="${item}"/></span>
        </c:if>

    </c:forEach>
</p>
<form action="controller" method="get">
    <input type="hidden" name="command" value="updatePage">
    <input type="submit" value="<c:out value="${m_quantity}"/>" >

    <select name="quantityPerPage" >

        <c:if test="${sessionScope.paginationParams['quantityPerPage'] == 1}">
            <option value="1" selected>1</option>
        </c:if>
        <c:if test="${sessionScope.paginationParams['quantityPerPage'] != 1}">
            <option value="1">1</option>
        </c:if>

        <c:if test="${sessionScope.paginationParams['quantityPerPage'] == 2}">
            <option value="2" selected>2</option>
        </c:if>
        <c:if test="${sessionScope.paginationParams['quantityPerPage'] != 2}">
            <option value="2">2</option>
        </c:if>

        <c:if test="${sessionScope.paginationParams['quantityPerPage'] == 5}">
            <option value="5" selected>5</option>
        </c:if>
        <c:if test="${sessionScope.paginationParams['quantityPerPage'] != 5}">
            <option value="5">5</option>
        </c:if>

        <c:if test="${sessionScope.paginationParams['quantityPerPage'] == 10}">
            <option value="10" selected>10</option>
        </c:if>
        <c:if test="${sessionScope.paginationParams['quantityPerPage'] != 10}">
            <option value="10">10</option>
        </c:if>

        <c:if test="${sessionScope.paginationParams['quantityPerPage'] == 20}">
            <option value="20" selected>20</option>
        </c:if>
        <c:if test="${sessionScope.paginationParams['quantityPerPage'] != 20}">
            <option value="20">20</option>
        </c:if>

    </select>
</form>







