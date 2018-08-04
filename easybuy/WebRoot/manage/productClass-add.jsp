<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript">
	$(function(){
		$("#parentId").change(function(){
			var parentId=$("#parentId").val();
			$.ajax({
				"url":"CategoryFindChildByParent.Action",
				"type":"post",
				"data":"parentId="+parentId,
				"success":function(result){
							var str="<select name='childId'>";
							console.log(result);
							for(var i=0;i<result.length;i++){
								
								str+="<option value='"+result[i].id+"'>"+result[i].name+"</option>";
							}
								str+="</select>";
								$("#childId").html(str);
							}
			})
		})
		
		$("#updateBtn").click(function(e){
			var text = $(".text").val();
			if(text.length==0){
				alert("请输入分类名称");
				e.preventDefault();
				window.location.reload();
				/* window.location.href="CategoryShowAll1.Action"; */
			}
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
		<h2>添加分类</h2>
		<div class="manage">
			<form action="CategoryAddParent.Action" method="post">
				<table class="form">
					<tr>
						<td class="field">父分类：</td>
						<td>
							<select name="parentId" id="parentId">
								<option value="0">请选择</option>
								<c:forEach items="${li }" var="c" varStatus="st">
									<option value="${c.id }">${c.name }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<c:if test="${gradeC=='pb' }">
						<tr>
						<td class="field">二级分类：</td>
						<td id="childId">
							<select name="childId" id="childId">
								<option value="-1">请选择</option>
							</select>
						</td>
					</tr>
					</c:if>
					
					<tr>
						<td class="field">分类名称：</td>
						<td><input type="text" class="text" name="className" /><div>${msg }</div></td>
					</tr>
					<tr>
						<p><input type="hidden" id="hhh" name="hhh" value="${gradeC }"></p>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" id="updateBtn" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
