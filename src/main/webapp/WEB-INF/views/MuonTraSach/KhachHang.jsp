<%--
  Created by IntelliJ IDEA.
  User: abc09
  Date: 4/19/2025
  Time: 4:11 PM
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
    <button onclick="window.location.href='${pageContext.request.contextPath}/'"
            class="btn btn-link">Thoat
    </button>
</div>
Thong tin muon sach
${khachHang}

<c:if test="${not empty khachHang.muonTraSachs}">
    <div class="card-deck">
        <c:forEach items="${khachHang.muonTraSachs}" var="mts">
            <div class="card mb-3" style="max-width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Thong tin muon tra</h5>
                    <p class="card-text"><strong>Ten sach:</strong> ${mts.sach.tenSach}</p>
                    </p>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>
<c:if test="${empty sinhVien.congViecs}">
    <div class="alert alert-warning">Chưa có thông tin</div>
</c:if>
</body>
</html>
