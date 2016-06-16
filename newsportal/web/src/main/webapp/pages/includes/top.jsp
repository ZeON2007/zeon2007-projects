<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="loc"/>
<fmt:message bundle="${loc}" key="message.login" var="m_login"/>
<fmt:message bundle="${loc}" key="message.portal" var="m_portal"/>
<fmt:message bundle="${loc}" key="message.logout" var="m_logout"/>
<fmt:message bundle="${loc}" key="message.enter" var="m_enter"/>



<div class="container">
    <div class="row" style="display: flex; align-items: center">
        <div class="col-xs-6">
            <h1><c:out value="${m_portal}"/></h1>
        </div>
        <div class="col-xs-6">
            <a style="padding-right: 15px" href="<c:url value="controller">
                    <c:param name="command" value="updatePage" />
                    <c:param name="language" value="ru" />
                 </c:url>">
                <img src="../../images/flags/russia.png">
            </a>
            <a href="<c:url value="controller">
                        <c:param name="command" value="updatePage" />
                        <c:param name="language" value="en" />
                     </c:url>">
                <img src="../../images/flags/usa.png">
            </a>
        </div>
    </div>
</div>

<div class="container" style="min-height: 40px">
    <div class="row" style="padding-left: inherit">
        <c:if test="${userType == null}">
            <a class="btn btn-default" style="padding: 5px"
               href="<c:url value="controller">
                        <c:param name="command" value="gotoLoginPage" />
                     </c:url>">
                <c:out value="${m_login}"/>
            </a>
        </c:if>
        <c:if test="${userType == 'AUTHOR'}">
            <a class="btn btn-default"
               style="padding-right: 15px"
               href="<c:url value="controller">
                        <c:param name="command" value="logout" />
                    </c:url>">
                <c:out value="${m_logout}"/>
            </a>
            <span><c:out value="${m_enter}"/> ${author.firstName} ${author.lastName}</span>
        </c:if>
    </div>
</div>

