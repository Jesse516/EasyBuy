<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />

<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript">
	var pageNo=1;
	var pageAll=0;
	$(function(){
			$.ajax({
				"url":"ProductShow.Action",
				"type":"post",
				"data":"pageNo="+pageNo,
				"success":function(result){
					pageAll = result.countPage;
					var str="<table class='list'>";
					str+="<tr><th>编号</th><th>商品名称</th><th>操作</th></tr>";
					for(var i=0;i<result.li.length;i++){
						str+="<tr><td class='first w4 c'>"+result.li[i].id+"</td><td class='thumb'><img src='../images/"+result.li[i].src+"' width='100' height='100'/><a href='../product-view.jsp' target='_self'>"+result.li[i].name+"</a></td><td class='w1 c'><a href='ProductModify.Action?id="+result.li[i].id+"'>修改</a> <a class='manageDel' href='ProductDelete.Action?id="+result.li[i].id+"'>删除</a></td></tr>";
					}
					str+="</table>";
					$(".manage").html(str);
				}
			})
		
		$(".current").live("click",function(){
			pageNo = $(this).attr("id");
			$.ajax({
				"url":"ProductShow.Action",
				"type":"post",
				"data":"pageNo="+pageNo,
				"success":function(result){
							var str="<table class='list'>";
							str+="<tr><th>编号</th><th>商品名称</th><th>操作</th></tr>";
							for(var i=0;i<result.li.length;i++){
								str+="<tr><td class='first w4 c'>"+result.li[i].id+"</td><td class='thumb'><img src='../images/"+result.li[i].src+"' width='100' height='100'/><a href='../product-view.jsp' target='_self'>"+result.li[i].name+"</a></td><td class='w1 c'><a href='ProductModify.Action?id="+result.li[i].id+"'>修改</a> <a class='manageDel' href='ProductDelete.Action?id="+result.li[i].id+"'>删除</a></td></tr>";
							}
							str+="</table>";
							$(".manage").html(str);
						}
			})
		})
		
		$("#pre").live("click",function(){
			if(pageNo>1){
				pageNo--;
				$.ajax({
				"url":"ProductShow.Action",
				"type":"post",
				"data":"pageNo="+pageNo,
				"success":function(result){
						var str="<table class='list'>";
						str+="<tr><th>编号</th><th>商品名称</th><th>操作</th></tr>";
						for(var i=0;i<result.li.length;i++){
							str+="<tr><td class='first w4 c'>"+result.li[i].id+"</td><td class='thumb'><img src='../images/"+result.li[i].src+"' width='100' height='100'/><a href='../product-view.jsp' target='_self'>"+result.li[i].name+"</a></td><td class='w1 c'><a href='ProductModify.Action?id="+result.li[i].id+"'>修改</a> <a class='manageDel' href='ProductDelete.Action?id="+result.li[i].id+"'>删除</a></td></tr>";
						}
						str+="</table>";
						$(".manage").html(str);
						}
				})
			}
		})
		
		$("#next").live("click",function(){
			if(pageNo<pageAll){
				pageNo++;
				$.ajax({
				"url":"ProductShow.Action",
				"type":"post",
				"data":"pageNo="+pageNo,
				"success":function(result){
						var str="<table class='list'>";
						str+="<tr><th>编号</th><th>商品名称</th><th>操作</th></tr>";
						for(var i=0;i<result.li.length;i++){
							str+="<tr><td class='first w4 c'>"+result.li[i].id+"</td><td class='thumb'><img src='../images/"+result.li[i].src+"' width='100' height='100'/><a href='../product-view.jsp' target='_self'>"+result.li[i].name+"</a></td><td class='w1 c'><a href='ProductModify.Action?id="+result.li[i].id+"'>修改</a> <a class='manageDel' href='ProductDelete.Action?id="+result.li[i].id+"'>删除</a></td></tr>";
						}
						str+="</table>";
						$(".manage").html(str);
						}
				})
			}
		})
		
		$(".pager").show(function(){
			$.ajax({
				"url":"ProductShow.Action",
				"type":"post",
				"success":function(result){
					var str="<ul class='clearfix'><li id='pre'><a>上一页</a></li>";
					for(var i=0;i<result.countPage;i++){
						str+="<li class='current' id='"+(i+1)+"'><a>"+(i+1)+"</a></li>";
					}
					str+="<li id='next'><a>下一页</a></li></ul>";
					console.log(str)
					$(".pager").html(str);
						}
			})
		})
			
		
	})

</script>
<script type="text/javascript">
	function openF(url,name,iWidth,iHeight){
		var iTop = (window.screen.height-30-iHeight)/2;
		var iLeft = (window.screen.width-10-iWidth)/2;
		window.open(url,name,'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
	}
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../main.Action">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${sessionScope.userId }您好，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="user.jsp">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a onclick="javascript:openF('CategoryShowAll.Action','',500,400)">新增</a></em><a href="CategoryShow.Action">分类管理</a></dd>
				<dd><em><a href="addProductCategory.Action">新增</a></em><a href="product.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.jsp">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
		</div>
	</div>
	<div class="clear"></div>
    <div class="pager">
	</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
