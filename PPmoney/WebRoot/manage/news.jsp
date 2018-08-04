<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/comment.css" />
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
	var pageNo=1;
	var pageAll = 0;
	$(function(){
			$.ajax({
			"url":"NewsShow.Action",
			"type":"post",
			"data":"pageNo="+pageNo,
			"success":function(result){
						pageAll=result.countPage;
						var str="<table class='list'>";
						str+="<tr><th>编号</th><th>标题</th><th>内容</th><th>发布时间</th><th>板块</th><th>操作</th></tr>";
						for(var i=0;i<result.li.length;i++){
							str+="<tr><td class='first w1 c'>"+result.li[i].id+"</td><td class='w1 c'>"+result.li[i].title+"</td><td class='w4 c'>"+result.li[i].content+"</td><td class='w1 c'>"+result.li[i].time+"</td><td class='w1 c'>"+result.li[i].type+"</td><td class='w1 c'><a href='UserChange.Action?id="+result.li[i].id+"'>修改</a> <a class='manageDel' href='UserDelete1.Action?id="+result.li[i].id+"'>删除</a></td></tr>";							
						}	
							str+="</table>";
							$(".manage").html(str);
					}
			})
		
		$("#pre").live("click",function(){
				if(pageNo>1){
				pageNo--;
				$.ajax({
				"url":"NewsShow.Action",
				"type":"post",
				"data":"pageNo="+pageNo,
				"success":function(result){
						var str="<table class='list'>";
						str+="<tr><th>编号</th><th>标题</th><th>内容</th><th>发布时间</th><th>板块</th><th>操作</th></tr>";
						for(var i=0;i<result.li.length;i++){
							str+="<tr><td class='first w1 c'>"+result.li[i].id+"</td><td class='w1 c'>"+result.li[i].title+"</td><td class='w4 c'>"+result.li[i].content+"</td><td class='w1 c'>"+result.li[i].time+"</td><td class='w1 c'>"+result.li[i].type+"</td><td class='w1 c'><a href='UserChange.Action?id="+result.li[i].id+"'>修改</a> <a class='manageDel' href='UserDelete1.Action?id="+result.li[i].id+"'>删除</a></td></tr>";							
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
				"url":"NewsShow.Action",
				"type":"post",
				"data":"pageNo="+pageNo,
				"success":function(result){
						var str="<table class='list'>";
						str+="<tr><th>编号</th><th>标题</th><th>内容</th><th>发布时间</th><th>板块</th><th>操作</th></tr>";
						for(var i=0;i<result.li.length;i++){
							str+="<tr><td class='first w1 c'>"+result.li[i].id+"</td><td class='w1 c'>"+result.li[i].title+"</td><td class='w4 c'>"+result.li[i].content+"</td><td class='w1 c'>"+result.li[i].time+"</td><td class='w1 c'>"+result.li[i].type+"</td><td class='w1 c'><a href='UserChange.Action?id="+result.li[i].id+"'>修改</a> <a class='manageDel' href='UserDelete1.Action?id="+result.li[i].id+"'>删除</a></td></tr>";							
						}	
							str+="</table>";
							$(".manage").html(str);
						}
				})
			}
		})
			
		$(".pager").show(function(){
				$.ajax({
				"url":"NewsShow.Action",
				"type":"post",
				"success":function(result){
					var str="<ul class='clearfix'><li id='pre'><a>上一页</a></li>";
					for(var i=0;i<result.countPage;i++){
						str+="<li class='current' id='"+(i+1)+"'><a>"+(i+1)+"</a></li>";
					}
					str+="<li id='next'><a>下一页</a></li></ul>";
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
	
	$(document).ready(function(){
		$("#UserList").change(function(){
			var sf = $("#UserList").val(); 
			$.ajax({
				"url":"NewsShow.Action",
				"type":"post",
				"data":"pageNo="+pageNo+"&&sf="+sf,
				"success":function(result){
						pageAll=result.countPage;
						var str="<table class='list'>";
						str+="<tr><th>编号</th><th>标题</th><th>内容</th><th>发布时间</th><th>板块</th><th>操作</th></tr>";
						for(var i=0;i<result.li.length;i++){
							str+="<tr><td class='first w1 c'>"+result.li[i].id+"</td><td class='w1 c'>"+result.li[i].title+"</td><td class='w4 c'>"+result.li[i].content+"</td><td class='w1 c'>"+result.li[i].time+"</td><td class='w1 c'>"+result.li[i].type+"</td><td class='w1 c'><a href='UserChange.Action?id="+result.li[i].id+"'>修改</a> <a class='manageDel' href='UserDelete1.Action?id="+result.li[i].id+"'>删除</a></td></tr>";							
						}	
							str+="</table>";
							$(".manage").html(str);
						}
			})		
		})
	})
</script>
</head>
<body>
<div class="topbox">
    <div class="top overH">
        <h1>服务热线：<span style="color:white">10101212</span><span style="color:white">（人工 9:00～22:00）</span></h1>
        <a href="englishVersion.jsp">English&nbsp;</a>
        <a href="manage/manageMain.Action">后台管理&nbsp;|</a>   
        <a href="helpCenter.jsp">帮助中心&nbsp;|</a>     
        <a href="register.jsp">注册&nbsp;|</a> 
        <a href="login.jsp">登录&nbsp;|</a>
        <a href="myAccount.jsp">我的账户&nbsp;|</a>
    </div>
</div>
<div class="nav" style="background-color:white;">
    <div class="logo"><img src="../images/logo.png"></div>
    <div class="navlink">
        <a href="index.jsp" class="navcurrent">首页</a>
        <a href="investment.jsp">我要理财</a>
        <a href="loan.jsp">我要借款</a>
        <a href="news.jsp">新闻中心</a>
        <a href="cases.jsp">成功案例</a>
        <a href="aboutUs.jsp">关于我们</a>
    </div>
</div>

<div id="childNav">
	<div class="welcome wrap">
		管理员${sessionScope.userId }您好，欢迎回到管理后台。
	</div>
</div>


<div id="main" class="wrap" style="height:660px;background-color:white;">
	<div id="menu-mng" class="lefter" style="margin-top:35px;">
		<div class="box">
			<ul>
				<li><a href="user.jsp">用户管理</a></li>
				<li><a href="product.jsp">产品管理</a></li>
				<li><a href="order.jsp">订单管理</a></li>
				<li><a href="cases.jsp">案例管理</a></li>
				<li><a href="news.jsp">新闻管理</a></li>
			</ul>
		</div>
	</div>
	<div id="main" class="wrap">
		<div class="main">
			<h2>新闻管理</h2>
			<div class="manage"></div>
			<div class="clear"></div>
    		<div class="pager"></div>
		</div>	
	</div>
</div>

</body>
</html>