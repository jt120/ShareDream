<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/inc/global.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
</head>
<body>
<jsp:include page="/inc/top.jsp"></jsp:include>

<table>
<tr><td>用户名</td><td>昵称</td><td>类型</td></tr>
<tr><td>${loginUser.email }</td><td>${loginUser.nickname }</td>

<td>
<c:if test="${loginUser.type eq 1}">普通用户</c:if>
<c:if test="${loginUser.type eq 2}">组长</c:if>
<c:if test="${loginUser.type eq 3}">管理员</c:if>
</td>
</tr>
</table>

</body>
</html>