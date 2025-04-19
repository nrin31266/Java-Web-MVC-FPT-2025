<%--
  Created by IntelliJ IDEA.
  User: abc09
  Date: 4/19/2025
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lich Su Muon Sach</title>
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.3.3/css/bootstrap.min.css' />">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card-shadow {
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            border-radius: 12px;
        }
        .table thead th {
            background-color: #0d6efd;
            color: white;
        }
        .table tbody tr:hover {
            background-color: #f1f1f1;
            cursor: pointer;
        }
        .form-control:focus {
            border-color: #0d6efd;
            box-shadow: 0 0 0 0.2rem rgba(13, 110, 253, 0.25);
        }
    </style>
</head>
<body>
<div class="px-5 py-5">
    <div>
        <button onclick="window.location.href='${pageContext.request.contextPath}/'"
                class="btn btn-link">Thoat</button>
    </div>
    <div class="row">

        <div class="col-md-4">
            <div class="card card-shadow p-4 bg-white">
                <h5 class="mb-4 text-primary text-center">Lich Su Muon Sach</h5>
                <form action="LichSuMuon" method="get">
                    <div class="mb-3">
                        <label for="soDT" class="form-label">So Dien Thoai</label>
                        <input type="text" class="form-control" id="soDT" name="soDT" value="${soDT}">
                    </div>
                    <div class="mb-3">
                        <label for="tenSach" class="form-label">Ten Sach</label>
                        <input type="text" class="form-control" id="tenSach" name="tenSach" value="${tenSach}">
                    </div>
                    <div class="mb-3">
                        <label for="ngayMuon" class="form-label">ngayMuon</label>
                        <input type="date" class="form-control" id="ngayMuon" name="ngayMuon" value="${ngayMuon}">
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Tim Kiem</button>
                    </div>
                </form>
            </div>
        </div>


        <div class="col-md-8">
            <div class="card card-shadow p-4">
                <h5 class="mb-4 text-success text-center">Danh Sach</h5>
                <div class="table-responsive">
                    <table class="table table-bordered table-hover align-middle">
                        <thead>
                        <tr>
                            <th scope="col">Ten KH</th>
                            <th scope="col">Tuoi</th>
                            <th scope="col">SDT</th>
                            <th scope="col">Ngay Muon</th>
                            <th scope="col">Ten Sach</th>
                            <th scope="col">Tac Gia</th>
                            <th scope="col">Ten Ma Loai Sach</th>
                            <th scope="col">Status</th>
                            <th scope="col">Ngay Tra</th>
                            <th scope="col">Hanh Dong</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${muonTraSachs}" var="mts">
                            <tr>
                                <td>${mts.khachHang.tenKH}</td>
                                <td>${mts.khachHang.tuoi}</td>
                                <td>${mts.khachHang.soDT}</td>
                                <td>${mts.ngayMuon}</td>
                                <td>${mts.sach.tenSach}</td>
                                <td>${mts.sach.tacGia}</td>
                                <td>${mts.sach.theLoaiSach.tenLoaiSach}</td>
                                <td><c:if test="${not empty mts.statusTraSach}">
                                    ${mts.sach.statusTraSach}
                                </c:if></td>
                                <td>${mts.ngayTra}</td>
                                <td >
                                    <form action="Xoa/${mts.khachHang.maKH}/${mts.sach.maSach}"  method="post">
                                        <button
                                                class="btn btn-danger">
                                            Xoa
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
