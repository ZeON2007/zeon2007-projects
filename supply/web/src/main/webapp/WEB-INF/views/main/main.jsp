<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="loc"/>
<fmt:message bundle="${loc}" key="message.info.owner" var="m_owner"/>


<c:import url="../includes/header.jsp"/>

<div class="container" style="background: #fffcd7">

    <div class="container">
        <c:import url="../includes/top.jsp"/>
    </div>

    <div class="container">
        <div class="row">

            <div class="col-xs-3" role="navigation">
                <c:import url="../includes/navigation.jsp"/>
            </div>

            <div class="col-xs-9">

                <div class="col-xs-12" style="min-height: 400px">
                    <c:import url="../includes/content.jsp"/>
                </div>

                <c:if test="${sessionScope.category == 'materials'}">
                    <div class="col-xs-12">
                        <c:import url="../includes/pagination.jsp"/>
                    </div>
                </c:if>

            </div>

        </div>
    </div>

    <div class="container" style="padding-top: 20px">
        <p>&copy; Copyright 2016 <c:out value="${m_owner}"/></p>
    </div>

</div>

<c:import url="../includes/footer.jsp"/>