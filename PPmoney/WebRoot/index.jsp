<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <a href="helpCenter2.jsp">帮助中心&nbsp;|</a>     
        <a href="register.jsp">注册&nbsp;|</a> 
        <a href="login.jsp">登录&nbsp;|</a>
        <a href="myAccount.jsp">我的账户&nbsp;|</a>
    </div>
</div>

<div class="nav">
    <div class="logo"><img src="images/logo.png"></div>
    <div class="navlink">
        <a href="main.Action" class="navcurrent">首页</a>
        <a href="investment.jsp">我要理财</a>
        <a href="showAllLoan.Action">我要借款</a>
        <a href="findAllNewsByPages.Action">新闻中心</a>
        <a href="showAllCases.Action">成功案例</a>
        <a href="aboutUs.jsp">关于我们</a>
    </div>
</div>

<div class="banner">     
        <img src="images/indexbanner_03.png">
        <img src="images/indexbanner_04.png">
        <img src="images/indexbanner_05.png"> 
    <div class="bannerctrl">
        <span></span>
        <span></span>
        <span></span>
    </div>
    <div class="bannerright">
       <h1>历史年化收益率</h1>
       <h2>PPmoney历史年化收益率</h2>
       <h3>6%~13%</h3>
       <a href="register.jsp" style="display:block; width:210px;margin-left:auto; margin-right:auto; font-family:'微软雅黑'; font-size:14px; color:white; background-image: url(images/bannerrightbotton.png); line-height:38px;  background-repeat:no-repeat;">注册领红包</a>
    </div>
</div>

<div id="summaryList">
	<ul class="detailList">
    	<li>
        	<span>累计现金交易总额</span>
            <label id="CashTradingVol"></label>
        </li>
        <li>
            <span>为用户赚取收益</span>
            <label id="TotalProfit"></label>
        </li>
        <li class="personNum">
            <span>注册人数</span>
            <label id="YesterdayVolume"></label>
            <em class="line"></em>
        </li>
        <li>
            <span>安全运营时间</span>
            <label id="TodayVolume"></label>
        </li>
    </ul>
</div>

<div class="poductbox overH">
    <div class="poducttitle">
        <h1>我要投资</h1>
        <h2>Investment</h2>
    </div>
    <c:forEach items="${pli }" var="i">
    	<div class="poduct">
        <h3 style="background-color:lightblue;">投资</h3>
        <ul>
        	<li>${i.name }</li>
        </ul>
        <ul>
           <li>项目期限${i.duration }天</li>
           <li>预期年化收益率：<span>${100*i.rate }%</span></li>
        </ul>
        <ul>
           <li>剩余可投金额：<span>82,3780元</span></li>
           <li class="poductp"><img src="images/poduct_09.png"></li>
           <li>项目金额<span style="font-size:18px;">${i.money }</span>万元</li>
        </ul>
        <a href="#" style="background-color:skyblue;">了解详情</a>
    </div>
    </c:forEach> 
</div>

<div class="poductbox overH">
    <div class="poducttitle">
        <h1>我要借款</h1>
        <h2>Loan</h2>
    </div>
    <c:forEach items="${pli2 }" var="l">
    	<div class="poduct">
        <h3 style="background-color:red">借</h3>
        <ul>
           <li>预期年化收益：<span>${100*l.rate }%</span></li>
           <li>还款方式：${l.type }</li>
        </ul>
        <ul>
           <li>投资期限：<span>${l.duration }个月</span></li>
        </ul>
        <ul>
           <li>剩余可投金额：<span>82,3780元</span></li>
           <li class="poductp"><img src="images/poduct_09.png"></li>
           <li>借款金额：<span>${l.money }万</span></li>
        </ul>
        <a style="background-color:red;" href="#">了解详情</a>
    </div>
    </c:forEach>
</div>

<div class="poductbox overH">
    <div class="poducttitle">
        <h1>新闻中心</h1>
        <h2>news center</h2>
    </div>
    <div class="newscenter">
        <div class="newscenterleft">
            <h5 style="font-size:22px;">行业动态</h5>
            <c:forEach items="${nli }" var="n">
            	<p>${n.title }</p>
            </c:forEach>
        </div>
        <div class="newscenteright"><img src="images/newscenter_03.png"></div>
    </div>
</div>

<div class="poductbox overH">
    <div class="poducttitle">
        <h1>成功案例</h1>
        <h2>successful cases</h2>
    </div>
    <c:forEach items="${cli }" var="c">
    	<div class="case overH">
        	<a href="#"><img src="images/${c.pic }"></a>
        	<p>${c.time }${c.content }</p>
        	<img src="images/${c.src }">
    	</div>
    </c:forEach>
</div>  

<div class="poductbox overH">
    <div class="poducttitle">
        <h1>关于我们</h1>
        <h2>about us</h2>
    </div>
    <div class="about">
        <a href="#"><img src="images/about_03.png"></a>
        <a href="#"><img src="images/about_05.png"></a>
        <a href="#"><span><img src="images/about_07.png"></span></a>
    </div>
</div>  

<div class="poductbox overH">
    <div class="poducttitle">
        <h1>合作伙伴</h1>
        <h2>cooperative partners</h2>
    </div> 
    <div class="cooperative">
        <a href="#"><img src="images/cooperative_13.png"></a>
        <a href="#"><img src="images/cooperative_15.png"></a>
        <a href="#"><img src="images/cooperative_17.png"></a>
        <a href="#"><img src="images/cooperative_19.png"></a>
        <a href="#"><img src="images/cooperative_21.png"></a>
        <a href="#"><img src="images/cooperativepartner_03.png"></a>
        <a href="#"><img src="images/cooperativepartner_05.png"></a>
    </div>       
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
