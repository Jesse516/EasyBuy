(function($){
	var defaults = {
		'tab_class' : 'tab_class',//需要切换的tab的class
		'active' : 'active',//高亮的class
		'event' : 'click' //事件的种类
	};
	$.fn.extend({
		'changeTab' : function(options){
			var opts = $.extend({},defaults,options);
			return this.each(function(){
				var $this = $(this);
				$this.on(opts.event,function(){
					$this.addClass("active").siblings().removeClass("active");
					$("." + opts.tab_class).eq($this.index()).show().siblings().hide();
					getTabData(1,$this.attr('data-id'));
				});
			});
		}
	});
})(jQuery);

//获取url参数
/*function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = location.search.substr(1).match(reg);
    if (r != null)
        return r[2];
    return null;
}*/

PPmoney.dialog = {
    //鼠标提示
    hoverTips: function (data) {
        var a;
        data.elem.mouseover(function () {
            var d = dialog({
                align: data.align || "bottom",
                content: data.content || $(this).attr("data-tips"),
                width: data.width || "auto",
                quickClose: true
            });
            d.show($(this).get(0)),
            $(this).addClass("artDialog-hover"),
            a = d
        }).mouseout(function () {
            a.close().remove(),
            $(this).removeClass("artDialog-hover")
        })
    },
    //提示
    tips: function (data) {
        var d = dialog({
            align: data.align || "top",
            width: data.width || "auto",
            height: data.height || "auto",
            content: data.content,
            quickClose: data.quickClose || false
        }).show(data.elem.get(0));
        return d;
    },
    //确认
    confirm: function (data) {
        if (Object.prototype.toString.call(data) === "[object String]") {
            data = { content: data };
        }
        var d = dialog({
            id: data.id || null,
            title: data.title || PPmoney.config.title,
            content: '<div class="ui-dialog-confirm">' + data.content + '</div>',
            width: data.width || "auto",
            height: data.height || "auto",
            ok: data.ok || null
        });
        return d.showModal().focus();
    },
    //默认常用
    show: function (data) {
        var d = dialog({
            id: data.id || null,
            title: data.title || PPmoney.config.title,
            content: '<div class="ui-dialog-confirm">' + data.content + '</div>',
            width: data.width || "auto",
            height: data.height || "auto",
            ok: data.ok || null,
            cancel: data.cancel || null
        });
        return d.show();
    },
    //遮罩层
    showModal: function (data) {
        var d = dialog({
            id: data.id || null,
            title: data.title || PPmoney.config.title,
            skin: data.skin || '',
            content: '<div class="ui-dialog-confirm">' + data.content + '</div>',
            width: data.width || "auto",
            height: data.height || "auto",
            ok: data.ok || null,
            cancel: data.cancel || null,
            onshow: data.onshow || null,
            onclose: data.onclose || null
        });
        return d.showModal();
    },
    //快速提示后消失
    quickClose: function (data) {
        if (Object.prototype.toString.call(data) === "[object String]") {
            data = { content: data };
        }
        var d = dialog({
            content: '<div class="p-20">' + data.content + '</div>',
            onclose: data.onclose || null
        });
        data.onclose ? d.showModal() : d.show();
        setTimeout(function () {
            data.callback && data.callback();
            d.close().remove();
        }, data.time || 2000);
    },
    //打开新页面
    iframe: function (data) {
        //dialog.get(id)根据获取打开的对话框实例
        var d = dialog({
            id: data.id || '',//dialog.get(id)获取对话框的实例
            title: data.title || PPmoney.config.title,
            data: data.data,
            url: data.url,
            width: data.width || "auto",
            height: data.height || "auto",
            skin: data.skin + ' PPLoading' || 'PPLoading',
            scroll: data.scroll || false,//是否显示滚动条
            onshow: function (data) {
                PPLoading();
            },
            oniframeload: function () {
                hideLoading();
                if (this.options.height === "auto") {
                    this.height(this.iframeNode.contentDocument.body.offsetHeight + 20);
                }
            },
            onclose: data.onclose || null,
            onremove: data.onremove || null
        })
        .showModal();
        return d;
    }
};
PPmoney.maskLayer = {
    show: function () {
        var height = $("html,body").height() > $(window).height ? $("html,body").height() : $(window).height
        $('<div class="g-mask-layer gray"></div>').appendTo($("body"))
        .height(height)
        .show();
    },
    hide: function () {
        $(".g-mask-layer").hide()
        .remove();
    }
};

$(function(){
	NTKF_PARAM = {
        siteid: "kf_9150",                              //小能提供企业id,
        settingid: "kf_9150_1452647794846",             //小能分配的缺省客服组id
        uid: "",          //用户id
        uname: "",        //用户名
        userlevel: "0"                                  //网站用户级别，登录用户可选，游客不填
    };
	$("body").append('<script type="text/javascript" src="https://download-xiaop.ppmoney.com/js/xn6/ntkfstat.js?siteid=kf_9150" charset="utf-8"></script>');
    var interval = setInterval(function () {
        if (typeof NTKF !== "undefined") {
            clearInterval(interval);
            $(".service .qq").click(function () {
                NTKF.im_openInPageChat();
                return false;
            });
        }
    }, 200);

    //
    try{
        $('.multiple-items').slick({
          dots: false,
          infinite: true,
          speed: 500,
          slidesToShow: 3,
          slidesToScroll: 3
        });

        $("a[rel=group]").fancybox({
            'titlePosition' : 'over',
            'cyclic'        : true,
            'titleFormat'   : function(title, currentArray, currentIndex, currentOpts) {
                return '<span id="fancybox-title-over">' + (currentIndex + 1) + ' / ' 
                + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
            }
        });
    }catch(e){
        
    }

    $("#head a").on('click',function(){
        var href = $(this).attr("data-href");
        $("#head a").removeClass('active');
        $(this).addClass('active');
        $('[data-jsevent="bussiness"]').addClass('hide');
        $("." + href + "-bussiness").removeClass('hide');
        $("#banner").removeClass().addClass(href + '-banner');
    });

    $("#detail-btn").click(function(){
        $(".show-box").toggle();

        if($(".show-box").is(':hidden')){
            $(this).html('点击查看详情&nbsp;&gt;&gt;');
        }else{
            $(this).text('点击收起');
        }
    });
})

