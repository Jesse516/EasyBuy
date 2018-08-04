<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function updateNum(id,op,event){
		$(event).prev().val(parseInt($(event).prev().val())+1);	
		$(event).parent().next().html("￥"+(parseFloat($(event).parent().prev().find("span").html().substring(1,$(event).parent().prev().html().length))*parseFloat($(event).prev().val()))+".0");
		$("#total").html("总计：￥"+(parseInt($("#total").html().substring(4,($("#total").html().length)))+parseInt($(event).parent().prev().find("span").html().substring(1,$(event).parent().prev().html().length)))+".0");
	}
	function updateNum1(id,op,event){
		if(parseInt($(event).next().val())>1){
			$(event).next().val(parseInt($(event).next().val())-1);	 
			$(event).parent().next().html("￥"+parseInt($(event).parent().prev().find("span").html().substring(1,$(event).parent().prev().html().length-1))*parseInt($(event).next().val()));
			$("#total").html("总计：￥"+(parseInt($("#total").html().substring(4,($("#total").html().length)))-parseInt($(event).parent().prev().find("span").html().substring(1,$(event).parent().prev().html().length)))+".0");
		}
	}
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="shopping.jsp" class="shopping">购物车X件</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a><a href="guestbook.jsp">留言</a><a href="manage/index.jsp">后台管理</a></div>
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
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<c:choose>
			<c:when test="${!empty sc.lines }">
				<form action="FindUser.Action" method="post">
				<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${sc.lines }" var="line">
					<tr id="product_id_0">
						<td class="thumb"><img src="images/${line.product.src }" width='100' height='100'/><a href="FindProductById.Action?id=${line.product.id }">${line.product.name }</a></td>
						<td class="price" id="price_id_0">
							<span id="lineprice1">￥${line.product.price }</span>
							<input type="hidden" value="99" />
						</td>
						<td class="number">
                        	<span name="del" id="del" onclick="updateNum1('${line.product.id}','-',this)">-</span>
                        	<input id="number${line.product.id }" type="text" name="number" value="${line.num }" onblur="updateNum('${line.product.id}')"/>
                        	<span name="add" id="add" onclick="updateNum('${line.product.id}','+',this)">+</span>
						</td>
						<td class="price" id="lineprice2">￥${line.sum }</td>
						<input type="hidden" name="haha" value="${line.product.id }">
						<td class="delete"><a href="deleteSaleLine.Action?id=${line.product.id }">删除</a></td>
					</tr>
				</c:forEach>
				</table>
				<span><a href="ClearCart.Action">清空购物车</a></span>
            	<div class="total"><span id="total">总计：￥${sc.total }</span></div>
            	<c:if test="${!empty sessionScope.userId }">
            		<div class="button"><input type="submit" value=""/></div>
            	</c:if>
				</form>
			</c:when>
			<c:otherwise>
				<h2 align="center">没有商品，请先购物</h2>
			</c:otherwise>
		</c:choose>
			
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
