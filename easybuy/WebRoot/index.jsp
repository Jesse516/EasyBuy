<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="welcomeImage">
    <img width="100%" height="150" src="images/banner.jpg" alt="welcome">
</div>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="shopping.jsp" id="shoppingBag" class="shopping">购物车X件</a><a href="login.jsp">登录</a>
	<c:choose>
		<c:when test="${empty sessionScope.userId }">
			<a class="button" href="UserLogOut.Action">注销</a>
		</c:when>
		<c:otherwise>
			<a class="button" href="UserLogOut.Action">注销</a>
		</c:otherwise>
	</c:choose>
	<a href="register.jsp">注册</a><a href="CommentShow2.Action">留言</a>
	<c:if test="${sessionScope.user.type!=1 }">
		<a href="manage/index.jsp">后台管理</a>
	</c:if>
	</div>
    <div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="main.Action">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${requestScope.map }" var="m">
					<dt>${m.key.name }</dt>
					<c:forEach items="${m.value }" var="v">
						<dd><a href="ShowAllProduct.Action">${v.name }</a></dd>
					</c:forEach>
				</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<c:if test="${!empty latelyList}">
				<dl class="clearfix">
					<c:forEach items="${latelyList }" var="p">
						<dt><img src="images/${p.src }" width="56" height="56"/></dt>
						<dd><a href="FindProductById.Action?id=${p.id }"  target="_self">${p.name }</a><a href="FindProductById.Action?id=${p.id }"></a></dd>
						<dt>&nbsp;</dt>
						<dd>&nbsp;</dd>
					</c:forEach> 
				</dl>
			</c:if>
	  </div>
	</div>
	<div class="main">
		<div class="price-off">
            <div class="slideBox">
                <ul id="slideBox">
                    <li><img src="images/product/banner_1.jpg"/></li>
                    <li><img src="images/product/banner_2.jpg"/></li>
                    <li><img src="images/product/banner_3.jpg"/></li>
                    <li><img src="images/product/banner_4.jpg"/></li>
                </ul>
            </div>
			<h2>商品列表</h2>
			<ul class="product clearfix">
				<c:forEach items="${requestScope.prli }" var="p">
					<li>
						<dl>
							<dt><a href="FindProductById.Action?id=${p.id }"  target="_self"><img src="images/${p.src }" /></a></dt>
							<dd class="title"><a href="FindProductById.Action?id=${p.id }" target="_self">${p.name } ${p.detail }</a></dd>
							<dd class="price">￥${p.price }</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="side">			
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<c:forEach items="${requestScope.li }" var="news">
						<li><a href="showCertainNews.Action?id=${news.id }"  target="_self">${news.title }</a></li>
					</c:forEach>
					
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
    </div>
</div>

</body>
</html>
