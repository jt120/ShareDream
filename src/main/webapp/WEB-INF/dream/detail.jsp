<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/inc/global.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${ctx }/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<jsp:include page="/inc/top.jsp"></jsp:include>
<div>
<p>Name:${dream.name }</p>
<p>Content:${dream.content }</p>

<form action="dream?method=reply" method="post">
<input type="hidden" name="d_id" value="${dream.id }"/>
<p>
<textarea class="ckeditor" cols="20" id="editor1" name="content" rows="10">
</textarea>
</p>
<p>
<button>回复</button>
</p>
</form>
<c:forEach items="${pComments.datas }" var="comment">
<div class="reply">
	<div class="reply_content">
	${comment.content }
	</div>
	<div class="reply_date">
	${comment.replyDate }
	</div>
<hr/>
</div>
</c:forEach>
</div>
<jsp:include page="/inc/pager.jsp">
<jsp:param value="${pComments.totalRecord }" name="items"/>
</jsp:include>
</body>
</html>