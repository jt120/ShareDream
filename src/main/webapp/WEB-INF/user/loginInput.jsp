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
      
      <form action="${ctx }/user?method=login" method="post" class="form-signin">
	    <h2 class="form-signin-heading">请登录</h2>
	    <input type="text" name="email" class="form-control" placeholder="Email address" required autofocus>
	    <input type="password" name="password" class="form-control" placeholder="Password" required>
	    <label class="checkbox">
	      <input type="checkbox" name="remeberMe" value="remember-me"> 记住我
	    </label>
	    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
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
>>>>>>> 4113ab57663ce5ce5beef53d284714803e4ca6b1
</html>