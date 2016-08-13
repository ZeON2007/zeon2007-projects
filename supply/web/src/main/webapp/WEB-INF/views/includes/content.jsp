<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="<c:url value="controller">
                            <c:param name="command" value="gotoEditMaterialPage" />
                        </c:url>" >
    ADD NEW MATERIAL
</a>

<c:if test="${sessionScope.category == 'materials'}">
    <table class="table table-bordered" style="width: 80%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Supplier</th>
        <th></th>
    </tr>
    <c:forEach var="material" items="${sessionScope.materials}">
        <tr>
            <td>
                <c:out value="${material.id}"/>
            </td>
            <td>
                <a href="<c:url value="controller">
                            <c:param name="command" value="gotoEditMaterialPage" />
                            <c:param name="selectedItem" value="${material.id}" />
                        </c:url>" >
                    <c:out value="${material.name}"/>
                </a>
            </td>
            <td>
                <c:out value="${material.price}"/>
            </td>
            <td>
                <c:out value="${material.supplier.name}"/>
            </td>
            <td>
                <a href="<c:url value="controller">
                            <c:param name="command" value="deleteMaterial" />
                            <c:param name="selectedItem" value="${material.id}" />
                        </c:url>" >
                    <img src="${pageContext.request.contextPath}/assets/images/delete.png" width="20" >
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</c:if>

<c:if test="${sessionScope.category == 'suppliers'}">
    <table class="table table-bordered" style="width: 80%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Settlement account</th>
            <th>Contact person</th>
        </tr>
        <c:forEach var="supplier" items="${sessionScope.suppliers}">
            <tr>
                <td>
                    <c:out value="${supplier.id}"/>
                </td>
                <td>
                    <c:out value="${supplier.name}"/>
                </td>
                <td>
                    <c:out value="${supplier.settlementAccount}"/>
                </td>
                <td>
                    <c:out value="${supplier.contactPerson}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>




