<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/9/2023
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
<body>
<div class="container-fluid">
    <h1 align="center">List Students</h1>
    <button onclick="window.location.href='/StudentServlet?action=create'" class="btn btn-primary">Thêm mới</button>
    <button onclick="window.location.href='/StudentServlet?action=showFindName'" class="btn btn-primary">Tìm kiếm</button>

    <table id="example" class="table table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Point</th>
            <th>Rank</th>
            <th>Id card</th>
            <th>Name Class</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <button type="button" class="btn btn-light" onclick="showModal(${student.code})">
                        <i class="fa-solid fa-trash" style="color: #eb0000;"></i>
                    </button>
                </td>
            </tr>
        </tbody>
    </table>
    <form action="/StudentServlet?action=delete" method="post">
        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">DELETE STUDENT</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <input type="hidden" name="code" id="code">
                    <div class="modal-body">
                        Bạn có muốn xóa học sinh có code là  <span id="idDelete"></span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-trash" style="color: #d71d1d;"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js"></script>
<script>
    new DataTable('#example');

    function showModal(code) {
        document.getElementById("idDelete").innerText = code;
        document.getElementById("code").value = code;
        $("#deleteModal").modal("show");
    }
</script>
</html>
