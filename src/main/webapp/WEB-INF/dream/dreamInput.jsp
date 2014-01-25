<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
  	<%@ include file="/inc/global.jsp" %>
    <%@ include file="/inc/meta.jsp" %>
    <title>Fixed Top Navbar Example for Bootstrap</title>
	<%@ include file="/inc/bootstrap.jsp" %>
	<script src="${ctx }/resources/ckeditor/ckeditor.js"></script>
  </head>
  <body>
	
    <!-- Wrap all page content here -->
    <div id="wrap">

      <%@include file="/inc/header.jsp" %>

      <!-- Begin page content -->
      <div class="container">
       <form action="dream?method=post" method="post">
			<input type="text" name="name" class="form-control" placeholder="梦想。。。" required autofocus>
			<p>
			<textarea class="ckeditor" cols="20" id="editor1" name="content" rows="10">
			</textarea>
			</p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">发表</button>
		</form>
      </div>
    </div>

    <%@ include file="/inc/footer.jsp" %>
	
	<%@ include file="/inc/js.jsp" %>
  </body>
</html>