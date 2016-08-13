<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="loc"/>
<fmt:message bundle="${loc}" key="message.info.material.characteristics" var="m_filling"/>

<c:import url="../includes/header.jsp"/>

<div class="container">
    <form id="form_id" class="form-signin" action="controller" method="POST">
        <input type="hidden" name="command" value="editMaterial">
        <input type="hidden" name="selectedItem" value="${requestScope.material.id}">

        <h2 class="form-signin-heading"><c:out value="${m_filling}"/></h2>


        <label for="inputName" class="sr-only">Name</label>
        <input id="inputName"
               class="form-control"
               type="text"
               name="materialName"
               value="${requestScope.material.name}"
               placeholder="Enter a name"
               required autofocus>

        <label for="inputPrice" class="sr-only">Price</label>
        <input id="inputPrice"
               class="form-control"
               type="text"
               name="materialPrice"
               value="${requestScope.material.price}"
               placeholder="Enter a price" >

        <label for="selectSupplier" class="sr-only">Supplier</label>
        <select id="selectSupplier" name="supplierId" size="5" class="form-control">
            <option value="">N/A</option>
            <c:forEach var="supplier" items="${sessionScope.suppliers}">
                <c:if test="${requestScope.material.supplier.id == supplier.id}">
                    <option value="${supplier.id}" selected><c:out value="${supplier.name}"/></option>
                </c:if>
                <c:if test="${requestScope.material.supplier.id != supplier.id}">
                    <option value="${supplier.id}"><c:out value="${supplier.name}"/></option>
                </c:if>
            </c:forEach>
        </select>

        <button class="btn btn-lg btn-primary btn-block" type="submit">
            Submit changes
        </button><br>
        <p>
            <a href="<c:url value="controller">
                            <c:param name="command" value="gotoMainPage" />
                        </c:url>" >
                Вернуться на главную страницу
            </a>
        </p>
    </form>
</div>

<c:import url="../includes/footer.jsp"/>