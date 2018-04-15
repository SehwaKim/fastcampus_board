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
<div class="container">
    <div class="jumbotron mt-3 text-center" style="margin-top: 50px">
        <p class="lead">${title} : ${result}</p>
    </div>
</div>
<%-- 자바스크립트 임포트 시작 --%>
<%@include file="/WEB-INF/views/user/user_javascript.jsp"%>
<%-- 자바스크립트 임포트 끝 --%>
</body>
</html>