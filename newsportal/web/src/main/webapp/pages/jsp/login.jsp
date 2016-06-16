<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="loc"/>
<fmt:message bundle="${loc}" key="message.signin" var="m_signin"/>
<fmt:message bundle="${loc}" key="message.portal" var="m_portal"/>
<fmt:message bundle="${loc}" key="message.logout" var="m_logout"/>
<fmt:message bundle="${loc}" key="message.enter" var="m_enter"/>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login</title>

    <!-- Bootstrap -->
    <link href="../../css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container">
        <form id="form_id"
              class="form-signin"
              action="controller"
              method="post">
            <input type="hidden" name="command" value="login">

            <h2 class="form-signin-heading"><c:out value="${m_signin}"/></h2>
            <p id='result'></p>

            <label for="inputEmail" class="sr-only">Email address</label>
            <input id="inputEmail"
                   class="form-control"
                   type="email"
                   name="email"
                   value="${author.email}"
                   placeholder="Email address"
                   required autofocus>

            <label for="inputPassword" class="sr-only">Password</label>
            <input id="inputPassword"
                   class="form-control"
                   type="password"
                   name="password"
                   value="${author.password}"
                   placeholder="Password"
                   required>

            <p>${errorLoginOrPassword}</p>

            <button class="btn btn-lg btn-primary btn-block"
                    type="submit"
                    <%--onclick="return validate('form_id','inputEmail');"--%>
            >
                Sign in
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

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery-2.2.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/validator.js"></script>

</body>
</html>