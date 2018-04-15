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
    <%-- 본문 시작 --%>
    <div class="page-header">
        <h1 class ="col-md-offset-3">회원가입</h1>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
        <article class="container">
            <div class="col-sm-7 col-md-8 col-md-offset-1">
                <form role="form" action="/user/signup" method="post">
                    <div class="form-group">
                        <label for="name">성명</label>
                        <input type="text" class="form-control" id="name" name="name" oninput="checkName()">
                    </div>
                    <div class="form-group">
                        <label for="id">아이디</label>
                        <input type="text" class="form-control" id="id" name="id"  oninput="checkId()">
                        <small id="idhelp" class="form-text text-muted" style="display: none;color: #D32F2F">
                            사용중인 아이디 입니다. 다른 아이디를 선택해 주세요
                        </small>
                    </div>
                    <div class="form-group">
                        <label for="email">이메일 주소</label>
                        <input type="email" class="form-control" id="email" name="email" >
                    </div>
                    <div class="form-group">
                        <label for="pwd">비밀번호</label>
                        <input type="password" class="form-control" id="pwd" name="pwd" >
                    </div>
                    <div class="form-group">
                        <label for="pwdCheck">비밀번호 확인</label>
                        <input type="password" class="form-control" id="pwdCheck" oninput="checkPwd()">
                        <small id="pwdhelp" class="form-text text-muted" style="display: none;color: #D32F2F">
                            입력된 값은 비밀번호와 같은 값이어야 합니다.
                        </small>
                    </div>
                    <div class="form-group">
                        <label for="nickname" >별명</label>
                        <input type="text" class="form-control" id="nickname" name="nickname">
                    </div>


                    <div class="form-group text-center">
                        <button type="submit" id="join-submit" class="btn btn-primary">
                            회원가입<i class="fa fa-check spaceLeft"></i>
                        </button>
                    </div>
                </form>
            </div>
        </article>
        <%-- 본문 끝 --%>
    </div>
</div>

<%-- 자바스크립트 임포트 시작 --%>
<%@include file="/WEB-INF/views/user/user_javascript.jsp"%>
<%-- 자바스크립트 임포트 끝 --%>
</body>
</html>