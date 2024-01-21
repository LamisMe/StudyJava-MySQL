<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Thêm Mới </title>
    <%--   Boostrap --%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-header">
                    <strong>Thêm Mới</strong>
                </div>
                <div class="card-body card-block">
                    <form action="" method="post" name="form-2" id="form-2"
                          class="form-horizontal">
                        <div class="row form-group">
                            <div class="col col-md-3 mt-3">
                                <label for="" class="col-form-label">#</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <input type="number" id="" name="" required
                                       class="form-control"
                                       aria-describedby="passwordHelpInline"
                                       style="text-transform:capitalize">
                            </div>
                        </div>
                        <div class="row form-group mt-3">
                            <div class="col col-md-3">
                                <label for="" class="col-form-label">#</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <input type="text" name="" required
                                       class="form-control"
                                       aria-describedby="passwordHelpInline"
                                       style="text-transform:capitalize">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="row form-group">
                    <c:if test="${thongBao != null}">
                    <div class="success-msg" role="alert">
                        ${thongBao}
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<%--    Boostrap--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>

</body>
</html>
