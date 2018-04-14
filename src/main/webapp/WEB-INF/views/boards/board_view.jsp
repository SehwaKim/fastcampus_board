<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 공통헤더 시작 --%>
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <%-- 공통헤더 끝 --%>
    <title>Board View</title>
</head>

<body>

<%-- 탑 네이게이션 시작 --%>
<%@include file="/WEB-INF/views/common/top_nav.jsp" %>
<%-- 탑 네비게이션 끝 --%>

<div class="container-fluid">
    <div class="row">
        <%-- 사이드바 시작 --%>
        <%@include file="/WEB-INF/views/common/sidebar.jsp" %>
        <%-- 사이드바 끝 --%>

        <%-- 본문 시작 --%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">게시글 상세보기</h1><%-- DB에서 내려 줘야댐. --%>

            <form class="form-horizontal" name="viewForm" action="/boards" method="post">
                <input type="hidden" name="categoryNo" value="${board.categoryNo}"/>
                <div class="form-group">
                    <label for="title" class="col-sm-1 control-label">제목</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="title" value="${board.title}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-1 control-label">작성자</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickname" name="nickname" value="${board.nickname}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="udate" class="col-sm-1 control-label">작성일</label>
                    <div class="col-sm-10">

                        <input type="text" class="form-control" id="udate" name="udate" value="${board.udate}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="content" class="col-sm-1 control-label"></label>
                    <div class="col-sm-10">
                        <textarea class="form-control" rows="10" id="content" name="content" readonly>${board.content}</textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10" align="right">
                        <input type="button" class="btn btn-warning" value="수정"/>
                        <input type="button" class="btn btn-success" value="목록"/>
                    </div>
                </div>
            </form>

            <%-- 본문 끝 --%>
        </div>
    </div>

    <%-- 자바스크립트 임포트 시작 --%>
    <%@include file="/WEB-INF/views/common/javascript.jsp" %>
    <%-- 자바스크립트 임포트 끝 --%>
</div>
</body>
</html>