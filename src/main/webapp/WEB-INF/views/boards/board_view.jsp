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

            <form class="form-horizontal" name="viewForm" action="/boards" method="get">
                <div id="commentDiv"></div>
                <div id="methodDiv"></div>
                <input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}" />
                <input type="hidden" name="categoryNo" value="${board.categoryNo}"/>
                <input type="hidden" name="page" value="${page}"/>
                <input type="hidden" id="commentPage" name="commentPage" value="${commentPage}"/>
                <input type="hidden" id="searchType" name="searchType" value="${searchType}"/>
                <input type="hidden" id="searchStr" name="searchStr" value="${searchStr}"/>
                <div class="form-group">
                    <label for="title" class="col-sm-1 control-label">제목</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="title" value="${board.title}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-1 control-label">작성자</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickname" value="${board.nickname}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="udate" class="col-sm-1 control-label">작성일</label>
                    <div class="col-sm-10">
                        <fmt:formatDate value="${board.udate}" pattern="yyyy-MM-dd HH:mm:ss" var="udate"/>
                        <input type="text" class="form-control" id="udate" value="${udate}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="content" class="col-sm-1 control-label"></label>
                    <div class="col-sm-10">
                        <textarea class="form-control" rows="10" id="content" readonly>${board.content}</textarea>
                    </div>
                </div>
                <c:forEach items="${board.fileNoList}" var="fileNo">
                <div class="form-group">
                    <div class="col-sm-10">
                        <img src="/boards/download/${fileNo}" name="image" id="image" alt="" style="width: 50%; height: auto;">
                    </div>
                </div>
                </c:forEach>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10" align="right">
                        <c:if test="${sessionScope.user.id == board.userId}" >
                            <input type="button" class="btn btn-warning" value="수정" onclick="goWriteForm()"/>
                            <input type="button" class="btn btn-danger" value="삭제" onclick="deleteContent()"/>
                        </c:if>
                        <input type="submit" class="btn btn-success" value="목록"/>
                    </div>
                </div>
            </form>
            <br/>
            <br/>
            <%-- 댓글시작 --%>
            <table class="table">
                <colgroup>
                    <col width="55%">
                    <col width="15%">
                    <col width="15%">
                    <col width="10%">
                </colgroup>
                <tbody>
                <c:forEach items="${commentList}" var="comment">
                    <tr>
                        <c:choose>
                            <c:when test="${comment.depth == 0}">
                                <td style="font-style: italic">삭제된 댓글 입니다.</td>
                            </c:when>
                            <c:when test="${comment.depth == 1}">
                                <td>&nbsp;${comment.content}</td>
                            </c:when>
                            <c:otherwise>
                                <td>&nbsp;┗&nbsp;${comment.content}</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${comment.nickname}</td>
                        <td><fmt:formatDate value="${comment.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <c:if test="${ sessionScope.user != null && comment.depth > 0 }">
                                <c:if test="${comment.depth == 1}">
                                    <a href="#"  data-toggle="modal" data-target=".comment_${comment.commentNo}">답글</a>
                                </c:if>
                                <c:if test="${sessionScope.user.id eq comment.userId}">${comment.depth == 1 ? '&nbsp;|&nbsp;' : ''}<a href="javascript:deleteComment(${comment.commentNo})">삭제</a></c:if>
                            </c:if>
                        </td>
                    </tr>
                    <div class="modal fade comment_${comment.commentNo}" tabindex="-1" role="dialog" aria-labelledby="commentInput" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">답글입력</h4>
                                </div>
                                <div class="modal-body">
                                    <form method="post" name="replyForm_${comment.commentNo}">
                                        <input type="text" class="form-control" name="commentContent" placeholder="댓글 작성">
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-warning" onclick="regsitComment(${comment.commentNo}, replyForm_${comment.commentNo}.commentContent.value)">등록</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </tbody>
            </table>
            <%-- 댓글 끝 --%>
            <%-- 댓글 페이징--%>
            <div align="center">
                <nav>
                    <ul class="pagination pagination-sm">
                    <c:if test="${pagination.hasPrev()}" >
                        <li>
                            <a href="javascript:getComments(${pagination.startPage - 1})" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                        <c:forEach var="pageNum" begin="${pagination.startPage}" end="${pagination.endPage}">
                            <li class="${pagination.page == pageNum ? 'active' : ''}"><a href="javascript:getComments(${pageNum})">${pageNum}</a></li>
                        </c:forEach>
                    <c:if test="${pagination.hasNext()}" >
                        <li>
                            <a href="javascript:getComments(${pagination.endPage + 1})" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    </ul>
                </nav>
            </div>
            <%--댓글 페이징 끝 --%>
            <%-- 댓글 작성 --%>
            <div align="center">
            <c:if test="${sessionScope.user != null}">
                <form class="form-inline" name="commentForm" method="post" action="/boards/${board.boardNo}/comment">
                    <input type="text" class="form-control" style="width: 80%;" id="commentContent" name="commentContent" value="" placeholder="댓글 작성">
                    <input type="button" class="btn btn-warning" style="width: 10%;" onclick="regsitComment(0, commentForm.commentContent.value)" value="입력" />
                </form>
            </c:if>
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
        viewForm.commentPage.value = pageNum;
        viewForm.submit();
    }

    var regsitComment = function(commentGroup, content) {
        viewForm.action = "/boards/${board.boardNo}/comment";
        viewForm.method = "post";
        // commentContent
        if(content.trim().length == 0) return;
        var inputs = "<input type='hidden' value='' id='commentContent' name='content' />";
        document.getElementById("commentDiv").innerHTML = inputs;

        if(commentGroup > 0) {
            inputs += "<input type='hidden' value='' id='commentGroup' name='commentGroup' />";
            inputs += "<input type='hidden' value='' id='depth' name='depth' />";
            document.getElementById("commentDiv").innerHTML = inputs;
            viewForm.commentGroup.value = commentGroup;
            viewForm.depth.value = 2;

        }
        viewForm.commentContent.value = content;

        viewForm.submit();
    }

    var deleteComment = function (commentNo) {
        viewForm.action = "/boards/${board.boardNo}/comment/"+commentNo;
        viewForm.method = "post";
        document.getElementById("commentDiv").innerHTML = "<input type='hidden' value='delete' name='_method' />";
        viewForm.submit();
    }

    var goWriteForm = function () {
        viewForm.action = "/boards/updateform"
        viewForm.submit();
    }

    var deleteContent = function () {
        if(!confirm("삭제 하시겠습니까?")) return;
        viewForm.action = "/boards/${board.boardNo}";
        viewForm.method = "post";
        document.getElementById("methodDiv").innerHTML = "<input type='hidden' value='delete' name='_method' />";
        viewForm.submit();
    }
</script>
</html>