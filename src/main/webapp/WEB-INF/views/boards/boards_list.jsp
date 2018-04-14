<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 공통헤더 시작 --%>
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <%-- 공통헤더 끝 --%>
    <title>Board List</title>
    <script>
        function colorOnPage(){
            document.getElementById(${page}).setAttribute("class", "active");
        }
    </script>
</head>

<body onload="colorOnPage()">

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
            <button class="btn btn-default" type="submit" onclick="location.href='/boards/writeform'">글쓰기</button>
            <div class="table-responsive">
                <table class="table table-striped">
                    <colgroup>
                        <col width="10%" align="center">
                        <col width="*">
                        <col width="15%" align="center">
                        <col width="20%" align="center">
                        <col width="5%" align="center">
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
                    <c:if test="${boardList != null}">
                        <c:forEach items="${boardList}" var="b">
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
            <nav align="center">
                <ul class="pagination">
                    <c:if test="${hasPrev}">
                        <li>
                            <a href="/boards?page=${startPage-1}&searchType=${searchType}&searchStr=${searchStr}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach begin="${startPage}" end="${endPage}" step="1" var="num">
                      <li id="${num}">
                          <a href="/boards?page=${num}&searchType=${searchType}&searchStr=${searchStr}">${num}</a>
                      </li>
                    </c:forEach>
                    <c:if test="${hasNext}">
                        <li>
                            <a href="/boards?page=${endPage+1}&searchType=${searchType}&searchStr=${searchStr}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
            <div align="center">
                <form class="form-inline" method="get" action="/boards">
                    <div class="form-group">
                        <select class="form-control" name="searchType">
                            <option value="title" selected>Title</option>
                            <option value="content">Content</option>
                        </select>
                        <label for="inputSearchStr" class="sr-only">searchStr</label>
                        <input type="search" class="form-control" id="inputSearchStr" name="searchStr">
                    </div>
                    <button type="submit" class="btn btn-default">검색</button>
                </form>
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