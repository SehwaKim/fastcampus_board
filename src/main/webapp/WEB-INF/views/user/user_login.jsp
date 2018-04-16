<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="container-fluid col-md-offset-4 col-md-4">
    <h1 class="display-1">로그인 하기</h1>
    <form action="/user/login" method="post">
        <c:choose>
            <c:when test="${empty visible}">
                <div class="alert alert-danger" role="alert" style="display:none">비밀번호를 다시 입력 해주세요!</div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger" role="alert">비밀번호를 다시 입력 해주세요!</div>
            </c:otherwise>
        </c:choose>
        <div class="form-group">
            <input type="text" class="form-control" id="loginId" name="id" placeholder="ID" onchange="checkLoginId()">
            <small id="loginIdHelp" class="form-text text-muted" style="display: none;color: #D32F2F">존재하지 않는 아이디 입니다.</small>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="loginPwd" name="pwd" placeholder="PassWord">
        </div>
        <input type="hidden" name="referer" value="${referer}">
        <div>
           Find <a class="nav-link" href="/user/findid">Id</a> or <a class="nav-link" href="/user/findpwd">Password</a>
        </div>
        &nbsp;
        <div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
        </div>
    </form>
</div>

<%-- 자바스크립트 임포트 시작 --%>
<%@include file="/WEB-INF/views/user/user_javascript.jsp"%>
<%-- 자바스크립트 임포트 끝 --%>
</body>
</html>