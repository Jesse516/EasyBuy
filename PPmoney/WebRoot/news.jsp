<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>PPmoney</title>
</head>
<script src="js/jquery.js"></script>
<link href="css/comment.css" rel="stylesheet"></link>
<style>
li{ list-style:none;}
.poductbox{ width:980px; margin-left:auto; margin-right:auto;}
.poducttitle{ width:980px; background-color:#eaeaea; height:66px; text-align:center;}
.poducttitle h1{ font-family:"微软雅黑"; font-size:22px; color:#258ba1; padding-top:10px;}
.poducttitle h2{ font-family:"微软雅黑"; font-size:12px; color:#333; margin-top:-18px;}

.solutiontop{ width:980px;  margin-left:auto; margin-right:auto;} 
.solutiontop1{ width:318px; height:498px; float:left; border:solid 1px #CCC; background-color:#f9f9f9; overflow:hidden; text-align:center;  margin-top:10px;}
.solutiontop1 img{ width:150px; height:150px; padding-left:85px; padding-right:85px; padding-top:40px; padding-bottom:30px;}
.solutiontop1 h1{ font-family:"微软雅黑"; font-size:16px; color:#575757;}
.solutiontop1 a img{ display:block; width:105px; height:44px; padding-left:108px; padding-right:107px; }
.solutiontop1mR{ margin-right:10px;}
.solutiontop1mL{ margin-left:10px;}
.color1 span{ font-family:"微软雅黑"; font-size:24px; color:#47b9ed;}
.color2 span{ font-family: "微软雅黑"; font-size:24px; color:#edcc47;}
.color3 span{ font-family:"微软雅黑"; font-size:24px; color:#fa675d;}

.solutioncenter{ width:978px; height:153px; margin-left:auto; margin-right:auto; overflow:hidden;  border:solid 1px #CCC; background-color:#f9f9f9; margin-top:20px;}
.solutioncenterL{ margin-left:70px; float:left; margin-top:28px;}
.solutioncenterL a{ font-family:"微软雅黑"; font-size:18px; color:#3db9e3;}
.solutioncenterL p{  font-family:"微软雅黑"; font-size:14px; color:#575757;}
.solutioncenterR{ width:114px; height:113px; margin-top:21px; float:right; margin-right:100px;}
.solutioncenterL p span{ font-family:"微软雅黑"; font-size:14px; color:#fa675d;}

.newscenterbox{ overflow:hidden;} 
.newscenter{ width:980px;  margin-left:auto; margin-right:auto; background-color:#f9f9f9; padding-top:50px;}
.newscenterL{ width:180px; float:left; margin-top:30px; text-align:center;}
.newscenterL img{ margin-left:70px;}
.newscenterL h1{ font-family:"微软雅黑"; font-size:14px; color:#575757; margin-top:50px;}
.newscenterline{ float:left; width:18px; margin-right:60px;} 
.newscenterR{ float:left; width:540px; margin-top:20px; padding-right:122px;}
.newscenterR h2{ font-family:"微软雅黑"; font-size:24px; margin-top:40px;   color:#258ba1; }
.newscenterR h3{ font-family:"微软雅黑"; font-size:18px; color:#ae361b; margin-top:30px; }
.newscenterR p{ font-family:"微软雅黑"; font-size:14px; color:#575757; line-height:28px; }
.magin{ margin-top:-50px;} 
.maginH1 h1{ font-family:"微软雅黑"; font-size:14px; color:#575757; margin-top:92px;}
.maginH3 h3{font-family:"微软雅黑"; font-size:18px; color:#ae361b; margin-top:100px; }
</style>

<script type="text/javascript">
	$(document).ready(function(){
		$(".titlenav a").click(function(){
			$(this).addClass("titlenavcurrent");
			$(this).siblings().removeClass("titlenavcurrent");
		});
	});
</script>

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
        <a href="showAllLoan.Action">我要借款</a>
        <a href="findAllNewsByPages.Action" class="navcurrent">新闻中心</a>
        <a href="showAllCases.Action">成功案例</a>
        <a href="aboutUs.jsp">关于我们</a>
    </div>
</div>

<div class="banner">     
        <img src="images/indexbanner_07.png">
        <img src="images/indexbanner_05.png">
        <img src="images/indexbanner_04.png"> 
    <div class="bannerctrl">
        <span></span>
        <span></span>
        <span></span>
    </div>
</div>

<div class="box"> 
    <div class="title overH">
         <h1>新闻中心</h1>
         <h2>news center</h2>
    </div>   
    <div class="titlenav overH">
         <a href="findAllNewsByPages.Action">公司新闻</a>
         <a href="findAllNewsByPages1.Action">新闻中心</a>
         <a href="findAllNewsByPages.Action?type=2">行业动态</a>
    </div>
</div>
<div class="newscenterbox">
	<c:forEach items="${li }" var="n">
		<div class="newscenter overH">
        	<div class="newscenterL">
            	<img src="images/news_06.png">
             	<h1>${n.time }</h1>
        	</div>
        	<div class="newscenterline"><img src="images/news_031.png"></div>
        	<div class="newscenterR">
            	<h2>第一时间了解金融咨询及行业动态</h2>
            	<h3>${n.title }</h3>
            	<p>${n.content }</p>
         	</div>       
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
