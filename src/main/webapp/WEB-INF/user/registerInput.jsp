<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<!DOCTYPE html>
  <head>
  	<%@ include file="/inc/global.jsp" %>
    <%@ include file="/inc/meta.jsp" %>
    <title>Fixed Top Navbar Example for Bootstrap</title>
	<%@ include file="/inc/bootstrap.jsp" %>
	<link href="${ctx}/resources/css/login.css" rel="stylesheet">
  </head>
  <body>
	
    <!-- Wrap all page content here -->
    <div id="wrap">

      <%@include file="/inc/header.jsp" %>

      <!-- Begin page content -->
      <div class="container">
        <form action="${ctx }/user?method=register" method="post" class="form-signin">
			<h2 class="form-signin-heading">注册</h2>
			 <input type="text" name="email" class="form-control" placeholder="Email address" required autofocus>
	    	<input type="password" name="password" class="form-control" placeholder="Password" required>
	    	<p style="color:red;">${msg }</p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
		</form>
      </div>
    </div>

    <%@ include file="/inc/footer.jsp" %>
	
	<%@ include file="/inc/js.jsp" %>
  </body>
=======
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
>>>>>>> 4113ab57663ce5ce5beef53d284714803e4ca6b1
</html>