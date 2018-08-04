
//nav-tabs选项卡
var _getSearch = 0;
$(".nav-tabs li").changeTab({ 'tab_class': 'answer-list', 'event': 'click' })
.each(function(index, el) {
    if (location.href.match($(this).attr('data-value'))) {
        $(this).trigger('click');
        _getSearch = 1;
    };
});
if (_getSearch == 0) {
    $(".nav-tabs li:first").trigger('click');
};


function getTabData(page,id){
    $.get('/article', {id: id,page:page}, function(data, textStatus, xhr) {
        /*optional stuff to do after success */
        var _tabListDom = $(".nav-tab-list .answer-list"),html = '';
        $.each(data.docs, function(index, val) {
             /* iterate through array or object */

            html += '<div class="answer-cell" data-value="'+val._id+'">\
                        <div class="answer-title cf">\
                            <div class="fl"> '+val.title+'</div>\
                            <div class="fr sign-icon">\
                                <i class="h-spirit h-icon-down"></i>\
                            </div>\
                        </div>\
                        <div class="answer-cont">'+val.comments+'</div>\
                    </div>'

        });

        _tabListDom.html(html);

        if (data.pageInfo.totalItems > 0) {
            $("#recordPagi").html(
                PPmoneyPagination({
                    pageIndex: data.pageInfo.currentPage, //当前索引
                    pageSize: data.pageInfo.limit, //页面条数
                    totalCount: data.pageInfo.totalItems, //页面总数
                    callback: 'getTabData', //点击更新
                    params: '\''+ id + '\''
                })
            );
        } else {
            $("#recordPagi").html('<div class="no-record">暂无记录</div>');
        }
        showSearch();
        getIframeHeight();
    });
}

//单个问题展开收缩
$(document.body).on("click",".answer-cell .answer-title",function(){
    var $this = $(this);
    $(".answer-title >.sign-icon").find(".h-spirit").removeClass("h-icon-top").addClass("h-icon-down");
    if($this.next().css("display") == "none") {
        $(".answer-cell .answer-cont").slideUp();
        $this.next().slideDown();
        $this.find(".sign-icon").children().addClass("h-icon-top").removeClass("h-icon-down");
    }else {
        $this.next().slideUp();
        $this.find(".sign-icon").children().addClass("h-icon-down").removeClass("h-icon-top");
    }
    setTimeout(getIframeHeight,500)
});

function navLabels(){
    $(".help-nav .help-item").each(function(index, el) {
        if(location.href.match($(this).find("a").attr('data-value')) || location.href.split("___")[1] && $(this).find("a").attr('data-value').match(location.href.split("___")[1])){
            $(this).addClass('hover');
            $("#helpNavLabel").stop().animate({
                top:$(this).offset().top-$("#helpNavWrap").offset().top+2
            },200);
            return;
        }
    });
}

//导航条很长的情况
//(function () {
//    var oBox = $("#asset");
//    var oUl = $("#nav-tabs");
//    var aLi = oUl.find("li");
//    var aBtn = oBox.find(".nav-btn");
//    var aNav = $(".auto-nav");
//    if (aLi.length <=6) return;
//    var iNow = 0,liLen = 0;
//    if(aLi.length%6 == 0) {
//        liLen = aLi.length / 6;
//    }else {
//        liLen = parseInt(aLi.length / 6) + 1;
//    }
//    oUl.css("width", aNav.width()*liLen);
//
//    aBtn.eq(0).click(function () {
//        iNow--;
//        if (iNow < 0) {
//            iNow = liLen -1;
//        }
//        oUl.stop().animate({ "left": -(aLi.eq(0).width()+12) *6* iNow });
//    });
//
//    aBtn.eq(1).click(function () {
//        iNow++;
//        if (iNow > liLen -1) {
//            iNow = 0;
//        }
//        oUl.stop().animate({ "left": -(aLi.eq(0).width()+12) *6* iNow });
//    });
//    //隐藏和显示滑动按钮
//    aNav.on("mouseenter",function(){
//        aBtn.fadeIn();
//    });
//    $(".help-content").on("mouseleave",function(){
//        aBtn.fadeOut();
//    });
//})();
(function () {
    var oBox = $("#asset");
    var oUl = $("#nav-tabs");
    var aLi = oUl.find("li");
    var aBtn = oBox.find(".nav-btn");
    var aNav = $(".auto-nav");

    var iNow = 0,liLen = 0,iLen = 0;
    //proviNum存储的是点击按钮后出现第一个位置的Li的index，totalLen代表的是当前
    //移动的位置的距离
    var proviNum = 0,totalLen=0;
    for(var i=0;i<aLi.length;i++) {
        iLen += aLi.eq(i).width() + 12;
    }
    if (iLen <= aNav.width()) return;
    if(iLen%aNav.width() == 0) {
        liLen = iLen / aNav.width();
    }else {
        liLen = parseInt(iLen / aNav.width()) + 1;
    }
    oUl.css("width", liLen*aNav.width());
    aBtn.eq(0).click(function () {
        iNow--;
        var provLen = 0;
        if(proviNum == 0) {
            proviNum = aLi.length;
        }
        for(var i=proviNum;i>0;i--) {
            //计算从proviNum开始到i的长度
            provLen += aLi.eq(i).width() + 12;
            if(provLen > aNav.width()) {
                totalLen -= provLen - (aLi.eq(proviNum).width() + 12);
                proviNum = i;
                break;
            }
            if(provLen <= aNav.width() && iNow < 1) {
                proviNum = 0;
                totalLen = 0;
                iNow = 0;
                break;
            }
        }
        oUl.stop().animate({ "left": -totalLen });
    });

    aBtn.eq(1).click(function () {
        iNow++;
        var nextLen=0;
        for(var i=proviNum;i<aLi.length;i++) {
            //计算从proviNum开始到i的长度
            nextLen += aLi.eq(i).width() + 12;
            if(nextLen > aNav.width()) {
                proviNum = i;
                totalLen += nextLen - (aLi.eq(proviNum).width() + 12);
                break;
            }
            if(nextLen <= aNav.width() && iNow > liLen -1) {
                proviNum = 0;
                totalLen = 0;
                iNow = 0;
            }
        }
        oUl.stop().animate({ "left": -totalLen });
    });

    //单个LI点击触发滑动
    aLi.on("click",function(){
        var slen = 0;
        var index = aLi.index($(this));
        for(var i=proviNum;i<=index;i++) {
            slen += aLi.eq(i).width() + 12;
        }
        if(slen > aNav.width()) {
            iNow++;
            proviNum = i-1;
            totalLen += slen - (aLi.eq(index).width() + 12);
            oUl.stop().animate({ "left": -totalLen });
        }
    })

    //隐藏和显示滑动按钮
    aNav.on("mouseenter",function(){
        aBtn.fadeIn();
    });
    $(".help-content").on("mouseleave",function(){
        aBtn.fadeOut();
    });
})();

//搜索查找到当前tab切换
function showSearch(){
    if(getQueryString('searchId')) {
        var url = window.location.href,
            secNav = getQueryString('searchId'),
            $tabs_li = $("#nav-tabs li"),
            $nav_tabs_li = $(".nav-tab-list .answer-list");
        for(var i=0;i<$tabs_li.length;i++) {
            if(url.match($tabs_li.eq(i).attr("data-value"))) {
                $tabs_li.eq(i).addClass("active").siblings().removeClass("active");
                if(parseInt(i/6) > 0) {
                    $("#nav-tabs").stop().animate({ "left": -($tabs_li.width()+12) *6* parseInt(i/6) });
                }
                var $answer_cell = $nav_tabs_li.find(".answer-cell");
                for(var j=0;j<$answer_cell.length;j++) {
                    if($answer_cell.eq(j).attr("data-value") === secNav) {
                        $answer_cell.eq(j).find(".answer-title").find(".sign-icon").children().removeClass("h-icon-down").addClass("h-icon-top");
                        $answer_cell.eq(j).find(".answer-cont").slideDown();
                    }
                }
            }
        }
    }
}


