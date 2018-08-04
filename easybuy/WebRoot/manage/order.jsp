<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript">
	function changeStatus(id){
		var status = document.getElementById("opt"+id).value;
		window.location.href="updateStatus.Action?id="+id+"&status="+status;
	}

	function openF(url,name,iWidth,iHeight){
		var iTop = (window.screen.height-30-iHeight)/2;
		var iLeft = (window.screen.width-10-iWidth)/2;
		window.open(url,name,'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
	}
</script>
<script type="text/javascript">
	$(".pager").show(function(){
				$.ajax({
				"url":"FindOrder.Action",
				"type":"post",
				"data":"pageNo="+pageNo+"&userId="+userId+"&orderId="+orderId,
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
			<li><a href="product.jsp">商品</a></li>
			<li class="current"><a href="order.jsp">订单</a></li>
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
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">				
			</div>
			<div class="spacer"></div>
            <form id="orderForm" method="post"  action="FindOrder.Action">
                 订单号：<input type="text" class="text" name="orderId" id="entityId" value="${requestScope.orderId }"/>
                 订货人：<input type="text" class="text" name="userId" value="${requestScope.userId }"/>
                 <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
            </form>
			<table class="list">
				<c:forEach items="${map }" var="entry">
					<tr>
						<th colspan="2">单号：${entry.key.orderId }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 时间：<fmt:formatDate value="${entry.key.createTime }" pattern="yyyy-MM-DD HH:mm:ss"/></th>					
						<th colspan="2">状态:
							<c:choose>
								<c:when test="${entry.key.status==1 }">待审核</c:when>
								<c:when test="${entry.key.status==2 }">审核通过</c:when>
								<c:when test="${entry.key.status==3 }">配货</c:when>
								<c:when test="${entry.key.status==4 }">发货</c:when>
								<c:when test="${entry.key.status==5 }">收货确认</c:when>
							</c:choose>
							<c:if test="${entry.key.status!=5 }">
								<select name="status" id="opt${entry.key.orderId }">
									<option value="1" 
									<c:if test="${entry.key.status==1 }">
										selected="selected"
									</c:if>
									>待审核</option>
									<option value="2"
									<c:if test="${entry.key.status==2 }">
										selected="selected"
									</c:if>
									>审核通过</option>
									<option value="3"
									<c:if test="${entry.key.status==3 }">
										selected="selected"
									</c:if>
									>配货</option>
									<option value="4"
									<c:if test="${entry.key.status==4 }">
										selected="selected"
									</c:if>
									>发货</option>
									<option value="5">收货确认</option>
								</select>
								<input type="button" value="修改" onclick="changeStatus('${entry.key.orderId}')"/>
							</c:if>
						</th>					
					</tr>
					<c:forEach items="${entry.value }" var="od" varStatus="st">
						<tr>
							<td class="first w4 c"><img src="../images/${od.src }" width='100' height='100'/>${od.name }</td>
							<td>${od.price }</td>
							<td>${od.amount }</td>
							<c:if test="${st.count==1 }">
								<td class="w1 c" rowspan="${fn:length(entry.value) }">总计：${entry.key.cost }</td>					
							</c:if>	
						</tr>
					</c:forEach>
				</c:forEach>	
			</table>
			<div class="pager">
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
