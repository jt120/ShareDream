<%@ page import="com.jt.sd.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/inc/global.jsp" %>
<style>
.head{
text-align:right;
}
</style>
<div class="head">
<c:if test="${loginUser ne null}">
欢迎${loginUser.email}
<a href="${ctx}/user?method=list">账户管理</a>&nbsp;&nbsp;
<a href="user?method=logout">退出</a>&nbsp;&nbsp;
<a href="dream?method=dreamInput">发表</a>
<a href="dream?method=list">查看留言</a>
</c:if>

<c:if test="${loginUser eq null}">
<a href="user?method=loginInput">登陆</a>
</c:if>

<hr/>
</div>
