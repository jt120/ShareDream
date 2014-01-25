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
        <table>
			<tr><td>用户名</td><td>昵称</td><td>类型</td></tr>
			<tr><td>${loginUser.email }</td><td>${loginUser.nickname }</td>
			
			<td>
			<c:if test="${loginUser.type eq 1}">普通用户</c:if>
			<c:if test="${loginUser.type eq 2}">组长</c:if>
			<c:if test="${loginUser.type eq 3}">管理员</c:if>
			</td>
			</tr>
		</table>
      </div>
    </div>

    <%@ include file="/inc/footer.jsp" %>
	
	<%@ include file="/inc/js.jsp" %>
  </body>
</html>