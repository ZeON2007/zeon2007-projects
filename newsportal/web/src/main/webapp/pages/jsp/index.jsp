<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../includes/header.jsp"/>

<div id="tableContainer">
    <div class="tableRow">
        <nav>
            <c:import url="../includes/navigation.jsp"/>
        </nav>
        <section>
            <c:if test="${news == null}">
                <c:import url="../includes/news.jsp"/>
            </c:if>
            <c:if test="${news != null}">
                <c:import url="../includes/maintext.jsp"/>
            </c:if>
        </section>
    </div>
</div>

<c:import url="../includes/footer.jsp"/>