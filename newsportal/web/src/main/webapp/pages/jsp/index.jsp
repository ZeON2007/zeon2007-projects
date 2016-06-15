<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../includes/header.jsp"/>

<div class="container">

    <div class="container">
        <c:import url="../includes/top.jsp"/>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-xs-3">
                <c:import url="../includes/navigation.jsp"/>
            </div>
            <div class="col-xs-9">
                <div class="container">
                    <c:if test="${news == null}">
                        <c:import url="../includes/news.jsp"/>
                    </c:if>
                    <c:if test="${news != null}">
                        <c:import url="../includes/maintext.jsp"/>
                    </c:if>
                </div>
                <div class="container">
                    <c:import url="../includes/pagination.jsp"/>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <p>&copy; Copyright 2016 Александр Гержот</p>
    </div>

</div>

<c:import url="../includes/footer.jsp"/>