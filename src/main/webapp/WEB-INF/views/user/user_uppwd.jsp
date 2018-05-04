<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"  language="java" %>
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
        <%@include file="/WEB-INF/views/common/sidebar.jsp" %>
        <%-- 사이드바 끝 --%>

        <%-- 본문 시작 --%>
        <div class="page-header">
            <h1 class ="col-md-offset-3">회원정보수정</h1>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
            <article class="container">
                <div class="col-sm-7 col-md-8 col-md-offset-1">
                    <form role="form" action="/user/updatePwd" method="post">

                        <div class="form-group">
                            <label for="oldPwd">현재 비밀번호</label>
                            <input type="password" class="form-control" id="oldPwd" name="oldPwd">
                        </div>
                        <div class="form-group">
                            <label for="pwd">새 비밀번호</label>
                            <input type="password" class="form-control" id="pwd" name="pwd">
                        </div>
                        <div class="form-group">
                            <label for="pwdCheck">새 비밀번호 확인</label>
                            <input type="password" class="form-control" id="pwdCheck" onchange="checkPwd()">
                            <small id="pwdhelp" class="form-text text-muted" style="display: none;color: #D32F2F">
                                입력된 값은 비밀번호와 같은 값이어야 합니다.
                            </small>
                        </div>
                        <div class="form-group text-center">
                            <button id="updatePwdBtn" class="btn btn-primary">
                                수정하기<i class="fa fa-times spaceLeft"></i>
                            </button>
                        </div>
                    </form>
                </div>
            </article>
            <%-- 본문 끝 --%>
        </div>
    </div>
</div>

<%-- 자바스크립트 임포트 시작 --%>
<%@include file="/WEB-INF/views/user/user_javascript.jsp"%>
<%-- 자바스크립트 임포트 끝 --%>
</body>
</html>