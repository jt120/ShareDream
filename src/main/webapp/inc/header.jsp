<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">分享梦想</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${ctx }/dream?method=list">主页</a></li>
        <li><a href="${ctx }/dream?method=dreamInput">发表</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">敬请期待 <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li class="dropdown-header">Nav header</li>
            <li><a href="#">Separated link</a></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <c:if test="${loginUser ne null }">
        <li><a href="${ctx }/user?method=home">欢迎&nbsp;${loginUser.email }</a></li>
        <li><a href="${ctx }/user?method=logout">安全退出</a></li>
        </c:if>
        <c:if test="${loginUser eq null }">
          <li><a href="${ctx }/user?method=loginInput">登陆</a></li>
          <li><a href="${ctx }/user?method=registerInput">注册</a></li>
        </c:if>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</div>