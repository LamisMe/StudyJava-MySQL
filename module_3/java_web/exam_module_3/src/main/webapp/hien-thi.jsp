<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 9/11/2023
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <h2 class="title-1 m-b-25 justify-content-center d-flex" style="color: #0c0c0c; margin-bottom: 0">
            #</h2>
        <a class="btn btn-outline-light" href="" style="color: black">
          <button class="btn btn-primary">Thêm Mới</button>
        </a>
        <div class="table-responsive table--no-card m-b-40">
        <table class="table table-borderless table-striped table-earning" style="width: 100%" id="myTable">
                <thead>
                <tr>
                    <th>#</th>
                    <th>#</th>
                    <th>#</th>
                    <th>#</th>
                </tr>
                </thead>
            <tbody>
             <tr>
                 <td>#</td>
                 <td>#</td>
                 <td>#</td>
                 <td>#</td>
             </tr>
            </tbody>
        </table>
    </div>
</div>
<%--Modal--%>

<div class="modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<%--DataTables--%>

<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>

<script>
    $(document).ready(function () {
        $('#myTable').DataTable({});
    });
</script>
</body>
</html>
