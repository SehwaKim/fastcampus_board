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
    <h1 class="display-1">비밀번호 찾기</h1>
    <form action="/user/findpwd" method="post">
        <c:choose>
            <c:when test="${result =='err'}">
                <div class="alert alert-danger" role="alert">해당 정보의 사용자가 없습니다.!</div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger" role="alert" style="display:none">해당 정보의 사용자가 없습니다.!</div>
            </c:otherwise>
        </c:choose>
        <div class="form-group">
            <input type="text" class="form-control" name="id" placeholder="ID">
        </div>
        <div class="form-group">
            <input type="email" class="form-control"  name="email" aria-describedby="emailHelp" placeholder="Email">
        </div>
        &nbsp;
        <div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">확인</button>
        </div>
    </form>
</div>

<%-- 자바스크립트 임포트 시작 --%>
<%@include file="/WEB-INF/views/user/user_javascript.jsp"%>
<%-- 자바스크립트 임포트 끝 --%>
</body>
</html>