<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
    <div class="row" style="display: flex; align-items: center">
        <div class="col-xs-6">
            <h1>Новостной портал</h1>
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
                LOGIN
            </a>
        </c:if>
        <c:if test="${userType == 'AUTHOR'}">
            <a class="btn btn-default"
               style="padding-right: 15px"
               href="<c:url value="controller">
                        <c:param name="command" value="logout" />
                    </c:url>">
                LOGOUT
            </a>
            <span>Вы вошли как ${author.firstName} ${author.lastName}</span>
        </c:if>
    </div>
</div>

