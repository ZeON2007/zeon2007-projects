<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <h1>Новостной портал</h1>
        </div>
        <div class="col-xs-6">

            <a href="<c:url value="controller">
                                    <c:param name="command" value="updatePage" />
                                    <c:param name="language" value="ru" />
                                 </c:url>">
                RU
            </a>
            <a href="<c:url value="controller">
                                    <c:param name="command" value="updatePage" />
                                    <c:param name="language" value="en" />
                                 </c:url>">
                EN
            </a>
        </div>
    </div>
</div>

<div class="container">
    <c:if test="${userType == null}">
        <a href="<c:url value="controller">
                            <c:param name="command" value="gotoLoginPage" />
                         </c:url>">
            LOGIN
        </a>
    </c:if>
    <c:if test="${userType == 'AUTHOR'}">
        <h2>Здравствуйте, уважаемый ${author.firstName} ${author.lastName}</h2>
        <a href="<c:url value="controller">
                            <c:param name="command" value="logout" />
                        </c:url>">
            LOGOUT
        </a>
    </c:if>
</div>

