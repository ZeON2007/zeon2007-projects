<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="loc"/>
<fmt:message bundle="${loc}" key="message.info.portal" var="m_portal"/>

<div class="container">
    <div class="row" style="display: flex; align-items: center">
        <div class="col-xs-6">
            <h1><c:out value="${m_portal}"/></h1>
        </div>
        <div class="col-xs-6">
            <a style="padding-right: 15px" href="<c:url value="/${requestScope.currentPage}">
                    <c:param name="language" value="ru" />
                 </c:url>">
                <img src="${pageContext.request.contextPath}/assets/images/flags/russia.png">
            </a>
            <a href="<c:url value="/${requestScope.currentPage}">
                        <c:param name="language" value="en" />
                     </c:url>">
                <img src="${pageContext.request.contextPath}/assets/images/flags/usa.png">
            </a>
        </div>
    </div>
</div>

<div class="container" style="min-height: 40px">
    <div class="row" style="padding-left: inherit">

        <form class="form-inline" action="controller" method="GET">
            <input type="hidden" name="command" value="findMaterials">
            <div class="form-group">
                <label for="search" class="sr-only">Material search</label>
                <input id="search"
                       class="form-control"
                       type="text"
                       name="criterion"
                       value=""
                       placeholder="Enter a search criterion"
                       style="width: 400px">
            </div>
            <button class="btn btn-default" type="submit" id="findSubmit" onclick="encode()">
                Search
            </button>
        </form>

    </div>
</div>

