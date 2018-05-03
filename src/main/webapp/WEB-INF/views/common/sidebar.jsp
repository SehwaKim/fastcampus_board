<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
            <c:if test="${categories != null}">
                <c:forEach items="${categories}" var="c">
                    <li <c:if test="${categoryNo eq c.categoryNo}">class="active"</c:if>><a href="/boards?categoryNo=${c.categoryNo}">${c.name}<span class="sr-only"></span></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </div>
