<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>PPmoney</title>
</head>
<script src="js/jquery.js"></script>
<link href="css/comment.css" rel="stylesheet"></link>

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

<div class="nav" style="height:66px;background-color:white;">
    <div class="logo"><img src="images/logo.png"></div>
    <div class="navlink">
        <a href="main.Action">首页</a>
        <a href="investment.jsp">我要理财</a>
        <a href="loan.jsp">我要借款</a>
        <a href="findAllNewsByPages.Action">新闻中心</a>
        <a href="cases.jsp">成功案例</a>
        <a href="aboutUs.jsp">关于我们</a>
    </div>
</div>

<div style="height:1000px;background-color:lightblue;" id="searcherList">
	<input id="searcherList1" type="text" name="searcher" placeholder='请输入问题关键词，如"充值"'>
	<div style="width:1000px;height:800px;background-color:white;margin:0 auto;padding:30px;">
		<h2 style="font-size:30px;">自助服务</h2>
		<ul id="selfService">
			<li><a href="#">修改登录密码</a></li>
			<li><a href="#">完善会员资料</a></li>
			<li><a href="#">解绑银行卡</a></li>
			<li><a href="#">修改银行卡预留手机号</a></li>
		</ul>
		<hr/>
		<div id="commonQuestion">
		<h2 style="font-size:20px;">常见问题</h2>
		<div>
			<div>
				<h3 style="background-color:lightgrey;">我要出借</h3>
				<ul>
					<li><a href="#">平台费用&nbsp;&nbsp; </a>|</li>
					<li><a href="#">出借说明 </a></li>
				</ul>
			</div>
			<div>
				<h3 style="background-color:lightgrey;">资金管理</h3>
				<ul>
					<li><a href="#">充值&nbsp;&nbsp; </a>|</li>
					<li><a href="#">提现 </a></li>
				</ul>
			</div>
			<div>
				<h3 style="background-color:lightgrey;">优惠劵</h3>
				<ul>
					<li><a href="#">PP码&nbsp;&nbsp;</a>|</li>
					<li><a href="#">加息券&nbsp;&nbsp; </a>|</li>
					<li><a href="#">满减券&nbsp;&nbsp; </a>|</li>
					<li><a href="#">体验金&nbsp;&nbsp; </a>|</li>
					<li><a href="#">充值卡 </a></li>
				</ul>
			</div>
			<div>
				<h3 style="background-color:lightgrey;">产品服务</h3>
				<ul>
					<li><a href="#">网贷 </a></li>
				</ul>
			</div>
			<div>
				<h3 style="background-color:lightgrey;">资料变更</h3>
				<ul>
					<li><a href="#">修改手机号码&nbsp;&nbsp; </a>|</li>
					<li><a href="#">银行卡相关&nbsp;&nbsp; </a>|</li>
					<li><a href="#">账户变更&nbsp;&nbsp; </a>|</li>
					<li><a href="#">资料变更申请表 </a></li>
				</ul>
			</div>
			<div>
				<h3 style="background-color:lightgrey;">我的账户</h3>
				<ul>
					<li><a href="#">注册/登录&nbsp;&nbsp; </a>|</li>
					<li><a href="#">银行存管&nbsp;&nbsp; </a>|</li>
					<li><a href="#">开户/激活&nbsp;&nbsp; </a>|</li>
					<li><a href="#">密码设置 </a></li>
				</ul>
			</div>
			<div>
				<h3 style="background-color:lightgrey;">会员中心</h3>
				<ul>
					<li><a href="#">会员服务&nbsp;&nbsp; </a>|</li>
					<li><a href="#">积分管理&nbsp;&nbsp; </a>|</li>
					<li><a href="#">会员特权标&nbsp;&nbsp; </a>|</li>
					<li><a href="#">PP合伙人 </a></li>
				</ul>
			</div>
		</div>
	</div>
</div>


</body>
</html>