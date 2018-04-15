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

            <form class="form-horizontal" name="viewForm" method="get">
                <input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}" />
                <input type="hidden" name="categoryNo" value="${board.categoryNo}"/>
                <input type="hidden" name="page" value="${board.categoryNo}"/>
                <input type="hidden" id="commentPage" name="commentPage" value=""/>
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
            <br/>
            <br/>
            <%-- 댓글시작 --%>
            <table class="table">
                <colgroup>
                    <col width="60%">
                    <col width="15%">
                    <col width="15%">
                    <col width="5%">
                </colgroup>
                <tbody>
                <c:forEach items="${commentList}" var="comment">
                    <tr>
                        <td>&nbsp;${comment.depth > 1 ? '┗&nbsp;' : ''}${comment.content}</td>
                        <td>${comment.nickname}</td>
                        <td>${comment.regdate}</td>
                        <td>삭제</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%-- 댓글 끝 --%>
            <%-- 댓글 페이징--%>
            <div align="center">
                <nav>
                    <ul class="pagination pagination-sm">
                        <li ${pagination.hasPrev() ? '' : 'class="disabled"'}>
                            <a href="javascript:getComments(${pagination.startPage - 1})" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach var="pageNum" begin="${pagination.startPage}" end="${pagination.endPage}">
                            <li class="${pagination.page == pageNum ? 'active' : ''}"><a href="javascript:getComments(${pageNum})">${pageNum}</a></li>
                        </c:forEach>
                        <li ${pagination.hasNext() ? '' : 'class="disabled"'}>
                            <a href="javascript:getComments(${pagination.endPage + 1})" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <%--댓글 페이징 끝 --%>
            <%-- 댓글 작성 --%>
            <div align="center">
                <form class="form-inline">
                    <input type="text" class="form-control" style="width: 80%;" id="exampleInputName2" placeholder="댓글 작성">
                    <button type="submit" class="btn btn-warning" style="width: 10%;">입력</button>
                </form>
            </div>
            <%-- 댓글 작성 끝 --%>
        <%-- 본문 끝 --%>
        </div>
    </div>

    <%-- 자바스크립트 임포트 시작 --%>
    <%@include file="/WEB-INF/views/common/javascript.jsp" %>
    <%-- 자바스크립트 임포트 끝 --%>
</div>
</body>
<script>
    var getComments = function (pageNum) {
        viewForm.action = "/boards/"+viewForm.boardNo.value;
        console.log("/boards/"+viewForm.boardNo.value);
        viewForm.commentPage.value = pageNum;
        viewForm.submit();
    }

</script>
</html>