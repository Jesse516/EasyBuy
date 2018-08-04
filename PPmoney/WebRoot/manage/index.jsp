<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>PPmoney</title>
<style type="text/css">
	#hahe{
		height:100px;
	}
	#hahe>div{
		width:350px;
		height:100px;
		display:inline-block;
		margin:10px 5px;
	}
</style>
</head>
<script src="../js/jquery.js"></script>
<link href="../css/comment.css" rel="stylesheet"></link>
<link href="../css/style.css" rel="stylesheet"></link>

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

<div id="childNav" style="height:800px;background-color:skyblue;">
	<div class="welcome wrap">
		管理员${sessionScope.user.surName }您好，欢迎回到管理后台。
	</div>
	<div id="main" class="wrap" style="height:660px;width:980px;background-color:white;">
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
	<div class="main">
		<h2>管理首页</h2>
		<div id="welcome" class="manage">
			<div id="hahe">
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">当前注册人数：<span style="color:red;font-size:35px;">${aResult }</span>人</p>
				</div>
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">当前绑卡人数：<span style="color:red;font-size:35px;">${bResult }</span>人</p>
				</div>
			</div>
			<div id="hahe">
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">已发理财产品数：<span style="color:red;font-size:35px;">${aInvestment }</span>个</p>
				</div>
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">已发贷款产品数：<span style="color:red;font-size:35px;">${aLoan }</span>个</p>
				</div>
			</div>
			<div id="hahe">
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">已满标理财产品数：<span style="color:red;font-size:35px;">${bInvestment }</span>个</p>
				</div>
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">已满标贷款产品数：<span style="color:red;font-size:35px;">${bLoan }</span>个</p>
				</div>
			</div>
			<div id="hahe">
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">当天累计交易金额：<span style="color:red;font-size:35px;">${bMoney }</span>万元</p>
				</div>
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">当天累计交易笔数：<span style="color:red;font-size:35px;">${bHtran }</span>笔</p>
				</div>
			</div>
			<div id="hahe">
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">总累计交易金额：<span style="color:red;font-size:35px;">${aMoney }</span>万元</p>
				</div>
				<div style="width:350px;height:100px;border:1px skyblue solid;">
					<p style="font-size:20px;">总累计交易笔数：<span style="color:red;font-size:35px;">${aHtran }</span>笔</p>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>

</body>
</html>
