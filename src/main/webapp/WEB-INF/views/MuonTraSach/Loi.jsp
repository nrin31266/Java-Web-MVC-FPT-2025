<%--
  Created by IntelliJ IDEA.
  User: abc09
  Date: 4/19/2025
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.3.3/css/bootstrap.min.css' />">
</head>
<body>
<div>
    <div>
        <button onclick="window.location.href='${pageContext.request.contextPath}/'"
                class="btn btn-link">Thoat</button>
    </div>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
</div>
</body>
</html>
