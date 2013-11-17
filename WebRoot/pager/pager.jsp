<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<pg:pager maxPageItems="10" maxIndexPages="10" items="${param.items }" export="pageOffset,curPage=pageNumber" url="${param.url }">
<c:forEach items="${param.params }" var="p">
	<pg:param name="${p}"/>
</c:forEach>

共有${param.items}条，
<pg:last>
共有${pageNumber }页,
<c:set var="cluPage" value="${pageNumber }" />
</pg:last>
当前第${curPage }页
<pg:first>
	<a href="${pageUrl }">首页</a>
</pg:first>
<pg:prev>
	<a href="${pageUrl }">上一页</a>
</pg:prev>
<pg:pages>

<c:if test="${curPage eq pageNumber }">
	[${pageNumber }]
</c:if>
<c:if test="${curPage ne pageNumber }">
	<a href="${pageUrl }">${pageNumber }</a>
</c:if>
</pg:pages>
<pg:next>
	<a href="${pageUrl }">下一页</a>
</pg:next>
<pg:last>
	<a href="${pageUrl }">尾页</a>
</pg:last>

<select id="currentPage" onchange="changePage()">
    <c:forEach begin="1" end="${cluPage}" step="1" var="numbers">
    	<c:choose>
    		<c:when test="${numbers == curPage}">
    			<option value="${numbers*param.pageSize-param.pageSize}" selected="selected">${numbers}</option>
    		</c:when>
    		<c:otherwise>
               <option value="${numbers*param.pageSize-param.pageSize}">${numbers}</option>
            </c:otherwise>
    	</c:choose>
    </c:forEach>
</select>
<script type="text/javascript">
	function changePage(){
		var currentPage = document.getElementById("currentPage").value;
		var url = "${param.url}?pageOffset=" + currentPage;
		window.open(url,"_self");
	}
</script>
</pg:pager>