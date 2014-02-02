<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@ include file="/inc/global.jsp" %>
    <%@ include file="/inc/meta.jsp" %>
    <title>Fixed Top Navbar Example for Bootstrap</title>
	<%@ include file="/inc/bootstrap.jsp" %>
  </head>
  <body>
	
    <!-- Wrap all page content here -->
    <div id="wrap">

      <%@include file="/inc/header.jsp" %>

      <!-- Begin page content -->
      <div class="container">
      	<h2>Personal Info</h2>
        <table class="table">
			<tr><th>Email</th><th>Nickname</th><th>Type</th></tr>
			<tr><td>${loginUser.email }</td><td>${loginUser.nickname }</td>
			
			<td>
			<c:if test="${loginUser.type eq 1}">User</c:if>
			<c:if test="${loginUser.type eq 2}">Group</c:if>
			<c:if test="${loginUser.type eq 3}">Admin</c:if>
			</td>
			</tr>
		</table>
		<h2>Update Self Info</h2>
		<form action="${ctx }/user?method=update" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
	    <div class="form-group">
		    <label for="email" class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-4">
		      <input type="email" class="form-control" id="email" placeholder="Email">
		    </div>
	    </div>
	    <div class="form-group">
		    <label for="plainPassword" class="col-sm-2 control-label">Password</label>
		    <div class="col-sm-4">
		      <input type="password" class="form-control" id="plainPassword">
		    </div>
	    </div>
	    <div class="form-group">
		    <label for="avater" class="col-sm-2 control-label">Avater</label>
		    <div class="col-sm-4">
		      <input type="file" class="form-control" id="avater">
		    </div>
	    </div>
        <div class="form-group">
	     <div class="col-sm-offset-2 col-sm-4">
	      <button type="submit" class="btn btn-default">Update</button>
	     </div>
	    </div>
	  </form>
      </div>
    </div>

    <%@ include file="/inc/footer.jsp" %>
	
	<%@ include file="/inc/js.jsp" %>
  </body>
</html>