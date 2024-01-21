<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 9/11/2023
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <strong>Cập nhật</strong>
                </div>
                <div class="card-body card-block">
                    <form action="/bai-hoc?action=capnhat" method="post" name="form-2" id="form-2"
                          class="form-horizontal">
                        <c:if test="${baiHoc != null}">
                            <input type="hidden" name="maBaiHoc"
                                   value="${baiHoc.maBaiHoc}"/>
                        </c:if>
                        <div class="row form-group m-3">
                            <div class="col col-md-3">
                                <label for="maLoaiBaiHoc" class="col-form-label">Ma Loai Bai Hoc</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <input type="number" id="maLoaiBaiHoc" name="maLoaiBaiHoc"
                                       class="form-control"
                                       aria-describedby="passwordHelpInline"
                                       style="text-transform:capitalize" value="${baiHoc.maLoaiBaiHoc}">
                            </div>
                        </div>
                        <div class="row form-group m-3">
                            <div class="col col-md-3">
                                <label fclass="col-form-label">Do Kho</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check ">
                                    <c:set var="luachon" value="${baiHoc.doKho}"/>
                                    <label for="inline-radio1" class="form-check-label">
                                        <input type="radio" id="inline-radio1" value="1" name="doKho"
                                               style="margin-left: 10px" required
                                               class="form-check-input" <c:if test="${luachon eq 1}"/>>Trung
                                        Binh
                                    </label>
                                    <label for="inline-radio2" class="form-check-label ">
                                        <input type="radio" id="inline-radio2" value="2" name="doKho"
                                               style="margin-left: 10px"
                                               class="form-check-input" <c:if test="${luachon eq 2}">checked</c:if>>Kho
                                    </label> <label for="inline-radio3" class="form-check-label ">
                                    <input type="radio" id="inline-radio3" value="3" name="doKho"
                                           style="margin-left: 10px"
                                           class="form-check-input" <c:if test="${luachon eq 3}">checked</c:if>>Rat Kho
                                </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group m-3">
                            <div class="col col-md-3">
                                <label for="module" class="col-form-label">Module</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <input type="number" class="form-control" id="module" name="module"
                                       aria-describedby="passwordHelpInline"
                                       style="text-transform:capitalize" value="${baiHoc.module}">
                                <span class="form-message text-warning"></span>
                            </div>
                        </div>
                        <div class="row form-group m-3">
                            <div class="col col-md-3">
                                <label for="module" class="col-form-label">Link</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <input type="text" class="form-control" id="link" name="link"
                                       aria-describedby="passwordHelpInline"
                                       style="text-transform:capitalize" value="${baiHoc.link}">
                                <span class="form-message text-warning"></span>
                            </div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-primary" type="submit">
                                Xác nhận
                            </button>
                            <a href="/bai-hoc" class="btn btn-dark">Đóng</a>
                        </div>
                        <div class="row form-group m-3">
                            <c:if test="${thongBao != null}"/>
                            <div class="success-msg" role="alert">
                                ${thongBao}
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
