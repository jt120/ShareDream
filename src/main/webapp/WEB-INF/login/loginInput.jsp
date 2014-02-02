<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@ include file="/inc/global.jsp" %>
    <%@ include file="/inc/meta.jsp" %>
    <title>Login Page</title>
	<%@ include file="/inc/bootstrap.jsp" %>
	<link href="${ctx}/resources/css/login.css" rel="stylesheet">
  </head>
  <body>
	
    <!-- Wrap all page content here -->
    <div id="wrap">

      <%@include file="/inc/header.jsp" %>

      <!-- Begin page content -->
      <div class="container">
      
      <form action="${ctx }/login?method=login" method="post" class="form-signin">
	    <h2 class="form-signin-heading">Please Login</h2>
	    <input type="text" name="email" value="${email }" class="form-control" placeholder="Email address" required autofocus>
	    <input type="password" name="password" class="form-control" placeholder="Password" required>
	    <label class="checkbox">
	      <input type="checkbox" name="remeberMe" value="remember-me"> remember me
	    </label>
	    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
	  </form>
	  
      </div>
    </div>

    <%@ include file="/inc/footer.jsp" %>
	
	<%@ include file="/inc/js.jsp" %>
  </body>
</html>