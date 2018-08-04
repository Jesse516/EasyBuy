<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>PPmoney</title>
</head>
<script src="js/jquery.js"></script>
<link href="css/comment.css" rel="stylesheet"></link>
<style>
.casesbigbox{ margin-top:10px;}
.casesbox{ width:978px; margin-left:auto; margin-right:auto; background-color:#f9f9f9; height:153px; border:solid #CCC 1px; margin-top:10px;}
.cases1{ width:690px; float:left; margin-left:20px;}
.cases1 h1{ font-family:"微软雅黑"; font-size:18px; font-weight:bold; color:#575757; margin-top:20px;} 
.cases1 ul{ float:left; width:270px; margin:0; padding:0; list-style:none;}
.cases1 ul li{ font-family:"微软雅黑"; font-size:12px; color:#575757; float:left;  line-height:24px; margin:0; padding:0; list-style:none;}
.cases1 ul li a{ font-family:"微软雅黑"; font-size:12px; color:#575757; margin-right:18px;}
.abg1{ background-image:url(images/cases1_06.png); background-position:left center; background-repeat:no-repeat;}
.abg2{ background-image:url(images/cases1_10.png); background-position:left center; background-repeat:no-repeat;}
.abg3{ background-image:url(images/cases1_13.png); background-position:left center; background-repeat:no-repeat;}
.abg4{ background-image:url(images/cases1_15.png); background-position:left center; background-repeat:no-repeat;}
.cases1 ul li span{ color:#f47747; font-family:Arial; font-size:18px;}
.cases2{ width:243px; height:104px; float:right; overflow:hidden; margin-right:20px; margin-top:25px;} 

 
</style>
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

<div class="nav">
    <div class="logo"><img src="images/logo.png"></div>
    <div class="navlink">
        <a href="main.Action">首页</a>
        <a href="investment.jsp">我要理财</a>
        <a href="showAllLoan.Action">我要借款</a>
        <a href="findAllNewsByPages.Action">新闻中心</a>
        <a href="showAllCases.Action" class="navcurrent">成功案例</a>
        <a href="aboutUs.jsp">关于我们</a>
    </div>
</div>

<div class="banner">     
        <img src="images/indexbanner_06.png">
        <img src="images/indexbanner_04.png">
        <img src="images/indexbanner_05.png"> 
    <div class="bannerctrl">
        <span></span>
        <span></span>
        <span></span>
    </div>
</div>

<div class="box"> 
    <div class="title overH">
         <h1>成功案例</h1>
         <h2>successful cases</h2>
    </div>   
    <div class="titlenav overH">
         <a href="#" class="titlenavcurrent">成功案例</a>
    </div>
</div>

<div class="casesbigbox overH">
	<c:forEach items="${li }" var="l">
    	<div class="casesbox overH">
    		<div class="cases1">
            	<h1>${l.name }</h1>
             	<ul>
                	<li>担保机构：<a href="#" class="abg1">&nbsp;&nbsp;&nbsp;&nbsp;${l.issueCompany }</a></li>
                	<li>项目规模：${l.money }万&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项目期限：${l.duration }月</li>
                	<li class="cases1a">
                		<a href="#" class="abg2">&nbsp;&nbsp;&nbsp;&nbsp;当天计息</a>
                    	<a href="#" class="abg3">&nbsp;&nbsp;&nbsp;&nbsp;本息保障</a>
                    	<a href="#" class="abg4">&nbsp;&nbsp;&nbsp;&nbsp;灵活转让</a>
                	</li>
             	</ul>
             	<ul>
                	<li>还款方式：${l.type } </li>
                	<li>年化收益：<span>${100*l.rate }%</span></li>
             	</ul>
         	</div>
         	<div class="cases2"><img src="images/cases1_03.png"></div>
         </div>	
    </c:forEach>       
    
</div>
 
<div class="footerbox">
    <div class="footer overH">
        <div class="footerleft">
            <ul>关于我们
                <li><a href="#">公司简介</a></li>
                <li><a href="#">企业规划</a></li>
                <li><a href="#">企业文化</a></li>
                <li><a href="#">联系我们</a></li>
            </ul>
            <ul>我要借款
                <li><a href="#">政府扶持</a></li>
                <li><a href="#">投资理财</a></li>
                <li><a href="#">本息保障</a></li>
                <li><a href="#">收益稳健</a></li>
            </ul>
            <ul>我要理财
                <li><a href="#">超低门槛</a></li>
                <li><a href="#">债权优质</a></li>
                <li><a href="#">安全运行</a></li>
                <li><a href="#">收益整年</a></li>
            </ul>
        </div>
        <div class="footerright">
            <ul>
                <li>客服电话：（工作时间：9:00-18:00）</li>
                <li><span>4006-888-898</span></li>
                <li>地址：广州市天河区体育西路153号新天河大厦</li>
                <li>电话：400-00894-855</li>
                <li>传真：020-2788 0889</li>
            </ul>
        </div>
    </div>
</div>

<div class="copyrightbox">
  <div class="copyright">Copyright   2008-2015PPMONEY （xuexindai.com）All Rrights Reserved 粤ICP备09063742号-35号 增值电信业务经营许可 电信与信息服务经营许可证</div>
</div>
<div class="back"><img src="images/back.png"></div>
 
<script>
/*导航*/ 
$(".back").click(
	function(){		 
		$("html,body").animate({scrollTop:0})
	}
)

/*导航*/
$(".navlink a").click(
                  function(){
					  $(this).addClass("navcurrent").siblings().removeClass("navcurrent");
					  }
)

/*广告*/
$(".banner img").hide();
$(".banner img:eq(0)").show()
var n=0;
$(".bannerctrl span").click(function(){
	n = $(".bannerctrl span").index(this);
	document.title=n;
	$(".banner img").hide();
	$(".banner img:eq("+n+")").show();
	$(".bannerctrl span").removeClass("bannerctrlcurrent");
	$(this).addClass("bannerctrlcurrent");
})
function changeN(){
	if(n<$(".banner img").length-1){
		n=n+1;
	}else{
		n=0;
	}
	$(".banner img").hide();
	$(".banner img:eq("+n+")").show();	
	$(".bannerctrl span").removeClass("bannerctrlcurrent");
	$(".bannerctrl span:eq("+n+")").addClass("bannerctrlcurrent");
}
var timer = setInterval(changeN,2000);
$(".bannerctrl span").hover(function(){
	clearInterval(timer);	
},function(){
	timer = setInterval(changeN,2000);
})

/*小导航*/
$(".titlenav a").click(
                  function(){
					  $(this).addClass("titlenavcurrent").siblings().removeClass("titlenavcurrent");
					  }
)
 
</script>
</body>
</html>
