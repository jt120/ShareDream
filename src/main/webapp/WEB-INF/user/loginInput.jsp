<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/inc/global.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/inc/top.jsp"></jsp:include>
<h2>用户登陆</h2>
<form action="<%=request.getContextPath()%>/user?method=login" method="post">
<p>Email:<input name="email" type="text"/></p>
<p>Password:<input name="password" type="password"/></p>
<p style="color:red;"><%=request.getAttribute("msg") %></p>
<p><button>登录</button></p>
<a href="${ctx}/user?method=registerInput">注册</a>
</form>

</body>
</html>