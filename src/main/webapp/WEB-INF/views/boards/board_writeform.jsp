<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 공통헤더 시작 --%>
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <%-- 공통헤더 끝 --%>
    <title>Board View</title>
        <script>
            function loadname(img, previewName){

                var isIE = (navigator.appName=="Microsoft Internet Explorer");
                var path = img.value;
                var ext = path.substring(path.lastIndexOf('.') + 1).toLowerCase();

                if(ext == "gif" || ext == "jpeg" || ext == "jpg" ||  ext == "png" )
                {
                    if(isIE) {
                        $('#'+ previewName).attr('src', path);
                    }else{
                        if (img.files[0])
                        {
                            var reader = new FileReader();
                            reader.onload = function (e) {
                                $('#'+ previewName).attr('src', e.target.result);
                            }
                            reader.readAsDataURL(img.files[0]);
                        }
                    }

                }else{
                }
            }
        </script>
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
            <h1 class="page-header">게시글 작성</h1><%-- DB에서 내려 줘야댐. --%>

            <form class="form-horizontal" name="writeForm" action="/boards" method="get" enctype="multipart/form-data">
                <input type="hidden" name="categoryNo" value="${board.categoryNo}"/>
                <input type="hidden" name="page" value="${page}"/>
                <input type="hidden" id="searchType" name="searchType" value="${searchType}"/>
                <input type="hidden" id="searchStr" name="searchStr" value="${searchStr}"/>
                <div class="form-group">
                    <label for="title" class="col-sm-1 control-label">제목</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="title" name="title" value="" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-1 control-label">작성자</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickname" name="nickname" value="${sessionScope.user.nickname}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="image" class="col-sm-1 control-label"></label>
                    <div class="col-sm-10">
                        <input type="file" class="file" id="image" name="image" onchange="loadname(this,'previewimg')";><br>
                        <img src="about:blank" name="previewimg" id="previewimg" alt="" style="width: 50%; height: auto;">
                    </div>
                </div>
                <div class="form-group">
                    <label for="content" class="col-sm-1 control-label"></label>
                    <div class="col-sm-10">
                        <textarea class="form-control" rows="10" id="content" name="content"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10" align="right">
                        <input type="button" class="btn btn-warning" value="등록" onclick="regist()"/>
                        <input type="submit" class="btn btn-success" value="목록"/>
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
<script>

    var regist = function () {
        if(writeForm.title.value.trim().length == 0) {
            alert("제목을 입력해주세요.");
            return;
        }
        if(writeForm.content.value.trim() == 0) {
            alert("내용을 입력해주세요.");
            return;
        }
        if(!confirm("등록 하시겠습니까?")) return;

        writeForm.method = "post";
        writeForm.submit();
    }

</script>
</html>