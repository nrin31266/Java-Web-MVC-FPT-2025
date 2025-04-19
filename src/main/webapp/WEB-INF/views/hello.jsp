<%--
  Created by IntelliJ IDEA.
  User: abc09
  Date: 4/15/2025
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.3.3/css/bootstrap.min.css' />">
</head>
<body>
    <button
            onclick="window.location.href='${pageContext.request.contextPath}/MuonTraSach/Them'"
            class="btn btn-primary">
        Muon Sach
    </button>
    <button
            onclick="window.location.href='${pageContext.request.contextPath}/MuonTraSach/LichSuMuon'"
            class="btn btn-primary">
        Lich Su Muon
    </button>
</body>
</html>
