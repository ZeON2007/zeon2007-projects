<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-2.2.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
<script>
    var $ = function(id) {
        return document.getElementById(id);
    };
    var encode = function () {
        $('search').value = encodeURIComponent($('search').value);
    };
</script>

</body>
</html>