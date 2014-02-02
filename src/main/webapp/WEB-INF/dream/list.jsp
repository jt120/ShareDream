<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jt.sd.utils.HTMLFilter" %>
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
        <table class="table">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Replies</th>
				<th>User ID</th>
			</tr>
			<c:forEach items="${dreams}" var="dream">
			<tr>
				<td>${dream.id}</td>
				<td><a href="dream?method=detail&id=${dream.id }">${dream["name"]}</a></td>
				<td>${dream.commentNumber }</td>
				<td>${dream.user.id }</td>
			</tr>
			</c:forEach>
			<tr>
			<tr>
			<td colspan="5">
			<jsp:include page="/inc/pager.jsp">
			<jsp:param value="dream" name="url"/>
			<jsp:param value="${pages.totalRecord}" name="items"/>
			<jsp:param value="method" name="params"/>
			</jsp:include>
			</td>
			</tr>
			</table>
      </div>
    </div>

    <%@ include file="/inc/footer.jsp" %>
	
	<%@ include file="/inc/js.jsp" %>
  </body>
</html>