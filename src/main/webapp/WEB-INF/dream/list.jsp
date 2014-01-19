<%@ page import="com.jt.sd.entity.Dream" %>
<%@ page import="com.jt.sd.entity.Pager" %>
<%@ page import="com.jt.sd.dao.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/inc/global.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%@ include file="/inc/top.jsp" %> --%>
<jsp:include page="/inc/top.jsp"></jsp:include>
<table>
<tr>
	<td>ID</td>
	<td>名称</td>
	<td>内容</td>
	<td>评论数</td>
	<td>用户ID</td>
</tr>
<c:forEach items="${dreams}" var="dream">
<tr>
	<td>${dream.id}</td>
	<td><a href="dream?method=detail&id=${dream.id }">${dream.name }</a></td>
	<td>${dream.content }</td>
	<td>${dream.commentNumber }</td>
	<td>${dream.user.id }</td>
</tr>
</c:forEach>
<tr>
<tr>
<td colspan="5">
<jsp:include page="/inc/pager.jsp">
<jsp:param value="dream" name="url"/>
<jsp:param value="${pages.totalRecord}" name="items"/>
<jsp:param value="method" name="params"/>
</jsp:include>
</td>
</tr>
</table>
</body>
</html>