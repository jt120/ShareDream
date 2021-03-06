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
      <a class="navbar-brand" href="#">Share Dream</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="${ctx }/dream?method=list">Home</a></li>
        <li><a href="${ctx }/dream?method=dreamInput">Post</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Wait
           <b class="caret"></b></a>
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
        <li><a href="${ctx }/user?method=home">Welcome,&nbsp;${loginUser.email }</a></li>
        <li><a href="${ctx }/user?method=logout">Logout</a></li>
        </c:if>
        <c:if test="${loginUser eq null }">
          <li><a href="${ctx }/login?method=loginInput">Login</a></li>
          <li><a href="${ctx }/login?method=registerInput">Sign up?</a></li>
        </c:if>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</div>