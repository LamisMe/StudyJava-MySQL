<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang Hiển Thị</title>

    <%--   Boostrap --%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">


</head>
<body>
<div class="content">
    <div class="container">
        <h2 class="title-1 m-b-25 justify-content-center d-flex bt-5">
            Danh Sách</h2>
        <a class="btn btn-outline-primary mb-3" href="/bai-hoc?action=them">
            Thêm Mới
        </a>
        <div class="table-responsive table--no-card m-b-40">
            <table class="table table-borderless table-striped table-earning" style="width: 100%" id="myTable">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên Loại Bài Học</th>
                    <th>Độ Khó</th>
                    <th>Module</th>
                    <th>Link</th>
                    <th>Sửa</th>
                    <th>Xóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="b" items="${baiHocDto}" varStatus="lam">
                <tr>
                    <td>${lam.count}</td>
                    <td>${b.getTenLoaiBaiHoc()}</td>
                    <td>${b.getDoKho()}</td>
                    <td>${b.getModule()}</td>
                    <td>${b.getLink()}</td>
                    <td>
                        <a href="/bai-hoc?action=capnhat&maBaiHoc=${b.maBaiHoc}"
                           role="button" data-bs-toggle="modal"
                           data-bs-target="#exampleModal">
                            <button type="button" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal" class="btn btn-primary">
                                Sửa
                            </button>
                        </a>
                    </td>
                    <td>
                        <button type="button" data-bs-toggle="modal"
                                data-bs-target="#delete"
                                onclick="xoa('${b.maBaiHoc}','${b.link}')" class="btn btn-danger">
                            Xóa
                        </button>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--Modal--%>

<div class="modal" tabindex="-1" id="delete" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/bai-hoc?action=xoa" method="post" >
                <div class="modal-header" style="background-color: #dc3545">
                    <h5 class="modal-title" style="color: aliceblue">Xóa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" >
                    <input type="hidden" name="maBaiHoc" id="ma">
                    <p>Modal body text goes here.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary">Xác nhận</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--    Boostrap--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<%--DataTables--%>

<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>

<script>
    $(document).ready(function () {
        $('#myTable').DataTable({
            language: {
                "decimal": ",",
                "thousands": ".",
                "sEmptyTable": "Không có dữ liệu",
                "sInfo": "Đang hiển thị _START_ đến _END_ của tổng số _TOTAL_ mục",
                "sInfoEmpty": "Đang hiển thị 0 đến 0 của tổng số 0 mục",
                "sInfoFiltered": "(được lọc từ tổng số _MAX_ mục)",
                "sInfoPostFix": "",
                "sInfoThousands": ",",
                "sLengthMenu": "Hiển thị _MENU_ mục",
                "sLoadingRecords": "Đang tải...",
                "sProcessing": "Đang xử lý...",
                "sSearch": "Tìm kiếm:",
                "Show:": "",
                "entries": "",
                "oPaginate": {
                    "sFirst": "Đầu",
                    "sLast": "Cuối",
                    "sNext": "Tiếp",
                    "sPrevious": "Trước"
                },

            },
        });
    });
    function xoa(ma, ten) {
        document.getElementById("ma").value = ma;
        document.getElementById("ten").innerText = ten;
    }
</script>
</body>
</html>
