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
<%
String msg = request.getParameter("msg");
%>
<jsp:include page="/inc/top.jsp"></jsp:include>
<h2>用户注册</h2>
<form action="${ctx }/user?method=register" method="post">
<p>Email:<input name="email" type="text"/></p>
<p>Password:<input name="plainPassword" type="password"/></p>
<p style="color:red;"><%=msg %></p>
<p><input type="submit" value="注册"/></p>
<a href="${ctx }/user?method=loginInput">登录</a>
</form>

</body>
</html>