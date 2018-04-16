<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/boards"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;스터디 게시판</a>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
                <%-- 로그인 안했을때만 노출 시작 --%>
                <c:if test="${sessionScope.user == null}">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/user/login"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;로그인</a></li>
                        <li><a href="/user/signup">회원가입</a></li>
                    </ul>
                </c:if>
                <%-- 로그인 안했을때만 노출 끝 --%>

                <%-- 로그인 했을때만 노출 시작 --%>
                <c:if test="${sessionScope.user != null}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/user/update"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;${sessionScope.user.nickname}</a></li>
                    <li><a href="/user/logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;로그아웃</a></li>
                </ul>
                </c:if>
                <%-- 로그인 했을때만 노출 끝 --%>
            </div>
        </div>
    </nav>