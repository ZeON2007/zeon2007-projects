<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="loc"/>
<fmt:message bundle="${loc}" key="message.info.material" var="m_materials"/>
<fmt:message bundle="${loc}" key="message.info.supplier" var="m_suppliers"/>

<ul class="nav lead">
    <li>
        <a href="<c:url value="controller">
                    <c:param name="command" value="gotoCategoryPage" />
                    <c:param name="category" value="materials" />
                 </c:url>" >
            <c:out value="${m_materials}"/>
        </a>
    </li>
    <li>
        <a href="<c:url value="controller">
                    <c:param name="command" value="gotoCategoryPage" />
                    <c:param name="category" value="suppliers" />
                 </c:url>" >
            <c:out value="${m_suppliers}"/>
        </a>
    </li>
</ul>