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
        <p>${dream.name }</p>
		<p>${dream.content }</p>
		<hr/>
		<c:forEach items="${pComments.datas }" var="comment">
		<div class="reply">
			<div class="reply_content">
			${comment.content }
			</div>
			<div class="reply_date">
			发表于${comment.replyDate }
			</div>
		<hr/>
		</div>
		</c:forEach>
		<form action="dream?method=reply" method="post">
			<input type="hidden" name="d_id" value="${dream.id }"/>
			<textarea class="ckeditor" cols="20" id="editor1" name="content" rows="10">
			</textarea>
			<p></p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">回复</button>
		</form>
		
        
      </div>
    </div>

    <%@ include file="/inc/footer.jsp" %>
	
	<%@ include file="/inc/js.jsp" %>
  </body>
</html>