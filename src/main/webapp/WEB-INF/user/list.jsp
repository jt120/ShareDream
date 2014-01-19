<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/inc/global.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/inc/top.jsp"></jsp:include>
	<table>
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>昵称</td>
			<td>角色</td>
			<td>状态</td>
			<td>注册时间</td>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.email }</td>
				<td>${user.nickname }</td>
				<td><c:if test="${user.type eq 1}">普通用户</c:if> <c:if
						test="${user.type eq 2}">组长</c:if> <c:if test="${user.type eq 3}">管理员</c:if>
				</td>
				<td><c:if test="${user.status eq 0}">停用</c:if> <c:if
						test="${user.status eq 1}">启用</c:if></td>
				<td>${user.registerDate }</td>
				<c:if test="${user.type eq 3}">
					<td><a href="user?method=delete&id=${user.id }">删除</a></td>
				</c:if>


			</tr>
		</c:forEach>

		<tr>
		<tr>
			<td colspan="4"><jsp:include page="/inc/pager.jsp">
					<jsp:param value="user" name="url" />
					<jsp:param value="${pages.totalRecord}" name="items" />
					<jsp:param value="method,name" name="params" />
				</jsp:include></td>
		</tr>
	</table>
</body>
</html>