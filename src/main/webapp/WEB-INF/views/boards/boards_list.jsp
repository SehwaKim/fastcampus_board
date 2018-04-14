<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 공통헤더 시작 --%>
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <%-- 공통헤더 끝 --%>
    <title>Board List</title>
</head>

<body>

<%-- 탑 네이게이션 시작 --%>
<%@include file="/WEB-INF/views/common/top_nav.jsp"%>
<%-- 탑 네비게이션 끝 --%>

<div class="container-fluid">
    <div class="row">
        <%-- 사이드바 시작 --%>
        <%@include file="/WEB-INF/views/common/sidebar.jsp"%>
        <%-- 사이드바 끝 --%>
        <%-- 본문 시작 --%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">자유게시판</h1><%-- DB에서 내려 줘야댐. --%>

            <div class="table-responsive">
                <table class="table table-striped">
                    <colgroup>
                        <col width="10%">
                        <col width="*">
                        <col width="15%">
                        <col width="20%">
                        <col width="10%">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Writer</th>
                        <th>Date</th>
                        <th>Hit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${list != null}">
                        <c:forEach items="${list}" var="b">
                            <tr>
                                <td>${b.boardNo}</td>
                                <td><a href="/boards/${b.boardNo}">${b.title}</a></td>
                                <td>${b.nickname}</td>
                                <td>${b.udate}</td>
                                <td>${b.hit}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>

        <%-- 본문 끝 --%>
    </div>
</div>

<%-- 자바스크립트 임포트 시작 --%>
<%@include file="/WEB-INF/views/common/javascript.jsp"%>
<%-- 자바스크립트 임포트 끝 --%>
</body>
</html>