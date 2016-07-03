<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="loc"/>
<fmt:message bundle="${loc}" key="message.owner" var="m_owner"/>


<c:import url="../includes/header.jsp"/>

<div class="container" style="background: #fffcd7">

    <div class="container">

        <%--<c:import url="../includes/top.jsp"/>--%>

        <tiles:insertAttribute name="top"/>

    </div>

    <div class="container">
        <div class="row">
            <div class="col-xs-3" role="navigation">

                <c:import url="../includes/navigation.jsp"/>

            </div>
            <div class="col-xs-9">

                <c:if test="${news == null}">
                    <div class="container"
                         style="min-height: 400px; padding-left: 0px">

                        <c:import url="../includes/news.jsp"/>

                    </div>
                    <div class="container"
                         style="padding-left: 0px">

                        <c:import url="../includes/pagination.jsp"/>

                    </div>
                </c:if>
                <c:if test="${news != null}">

                    <c:import url="../includes/maintext.jsp"/>

                </c:if>
            </div>
        </div>
    </div>

    <div class="container" style="padding-top: 20px">

        <p>&copy; Copyright 2016 <c:out value="${m_owner}"/></p>

    </div>

</div>

<c:import url="../includes/footer.jsp"/>