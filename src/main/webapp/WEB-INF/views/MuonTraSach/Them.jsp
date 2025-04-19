<%--
  Created by IntelliJ IDEA.
  User: abc09
  Date: 4/19/2025
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Muon sach</title>
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.3.3/css/bootstrap.min.css' />">
</head>
<body>
    <div class="row justify-content-center">

        <div class="col-md-8">
            <div class="card shadow-lg">
                <div>
                    <button onclick="window.location.href='${pageContext.request.contextPath}/'"
                            class="btn btn-link">Thoat</button>
                </div>

                <div class="card-header bg-primary text-white text-center">
                    <h4>Nhap thông tin muon sach</h4>
                </div>

                <div class="card-body">
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">${error}</div>
                    </c:if>

                    <form:form method="post" action="Them" modelAttribute="requestBody">
                        <h5>Thông Tin Khach Hang</h5>
                        <div class="mb-3">
                            <label class="form-label">Ma Khach Hang</label>
                            <form:input path="maKH" cssClass="form-control"/>
                            <form:errors path="maKH" cssClass="text-danger"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Ten Khach Hang</label>
                            <form:input path="tenKH" cssClass="form-control"/>
                            <form:errors path="tenKH" cssClass="text-danger"/>
                        </div>


                        <div class="mb-3">
                            <label class="form-label">Tuoi</label>
                            <form:input path="tuoi" type="date" cssClass="form-control"/>
                            <form:errors path="tuoi" cssClass="text-danger"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Gioi Tinh</label>
                            <form:input path="gioiTinh" cssClass="form-control"/>
                            <form:errors path="gioiTinh" cssClass="text-danger"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Dia Chi</label>
                            <form:input path="diaChi" cssClass="form-control"/>
                            <form:errors path="diaChi" cssClass="text-danger"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Số điện thoại</label>
                            <form:input path="soDT" cssClass="form-control"/>
                            <form:errors path="soDT" cssClass="text-danger"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Ghi Chu KH</label>
                            <form:input path="ghiChuKH" cssClass="form-control"/>
                            <form:errors path="ghiChuKH" cssClass="text-danger"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Chon Loai KH</label>
                            <form:select path="maLoaiKhachHang" cssClass="form-select">
                                <form:options items="${loaiKhachHangs}" itemValue="maLoaiKH" itemLabel="tenLoaiKH"/>
                            </form:select>
                            <form:errors path="maLoaiKhachHang" cssClass="text-danger"/>
                        </div>

                        <hr>
                        <h5>Thông Tin Sach</h5>

                        <div class="mb-3">
                            <label class="form-label">Chon Sach</label>
                            <form:select path="maSach" cssClass="form-select">
                                <form:options items="${sachs}" itemValue="maSach" itemLabel="tenSach"/>
                            </form:select>
                            <form:errors path="maSach" cssClass="text-danger"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Ngay Muon</label>
                            <form:input path="ngayMuon" type="date" cssClass="form-control"/>
                            <form:errors path="ngayMuon" cssClass="text-danger"/>
                        </div>


                        <div class="mb-3">
                            <label class="form-label">Ghi Chu Muon Sach</label>
                            <form:input path="ghiChuMTS" cssClass="form-control"/>
                            <form:errors path="ghiChuMTS" cssClass="text-danger"/>
                        </div>


                        <div class="text-center">
                            <button type="submit" class="btn btn-success">Lưu thông tin</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
