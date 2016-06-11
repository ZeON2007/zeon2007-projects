<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>News Portal</title>
        <link rel="stylesheet" href="css/styles.css" />
    </head>
    <body>
    <h1>НОВОСТНОЙ ПОРТАЛ</h1>
    <h2>
        <c:if test="${userType == null}">
            <a href="<c:url value="controller">
                        <c:param name="command" value="gotoLoginPage" />
                     </c:url>" >
                LOGIN
            </a>
        </c:if>
        <c:if test="${userType == 'AUTHOR'}">
            <h2>Здравствуйте, уважаемый ${author.firstName} ${author.lastName}</h2>
            <a href="<c:url value="controller">
                        <c:param name="command" value="logout" />
                    </c:url>" >
                LOGOUT
            </a>
        </c:if>
    </h2>