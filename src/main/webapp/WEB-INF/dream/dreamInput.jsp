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
发表文章
<form action="dream?method=post" method="post">
<p>标题:<input type="text" name="name"/></p>
<p>
<textarea class="ckeditor" cols="20" id="editor1" name="content" rows="10">
</textarea>
</p>
<button>发表</button>
</form>
</body>
</html>