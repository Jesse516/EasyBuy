/**
 * PPmoney
 * @version v4.01
 * @time Tue Jan 05 2016 14:57:29 GMT+0800 (中国标准时间)
 */
var PPmoneyPagination=function(l){var a,i,s=Math.ceil(l.totalCount/l.pageSize),c="",e="",p="",n=l.params?","+l.params:"";7>s?(a=1,i=s):l.pageIndex<3?(a=1,i=6,p='<li class="disable">...</li>'):l.pageIndex>=s-5?(a=s-5,i=s):(a=l.pageIndex-2,i=l.pageIndex+3,p='<li class="disable">...</li>');for(var u=a;i>=u;u++)e+=u==l.pageIndex?'<li class="cur">'+u+"</li>":'<li onclick="'+l.callback+"("+u+n+')">'+u+"</li>";return c='<div class="pp-pagination"><div class="page-info">第'+l.pageIndex+"页/共"+s+'页</div><ul class="pagination">'+(1==l.pageIndex?'<li class="disable"><u class="u-pp-2-0"></u>首页</li>':'<li onclick="'+l.callback+"(1"+n+')"><u class="u-pp-2-0"></u>首页</li>')+(l.pageIndex>1?'<li onclick="'+l.callback+"("+(l.pageIndex-1)+n+')"><u class="u-pp-2-0"></u>上一页</li>':'<li class="disable"><u class="u-pp-2-0"></u>上一页</li>')+e+p+(l.pageIndex<s?'<li onclick="'+l.callback+"("+(l.pageIndex+1)+n+')">下一页<u class="u-pp-3-0"></u></li>':'<li class="disable">下一页<u class="u-pp-3-0"></u></li>')+(l.pageIndex==s?'<li class="disable">尾页<u class="u-pp-3-0"></u></li>':'<li onclick="'+l.callback+"("+s+n+')" class="">尾页<u class="u-pp-3-0"></u></li>')+"</ul></div>",0==l.totalCount?'<div class="no-record">暂无记录</div>':c};
if(typeof $ == 'function'){
    $(function(){
        $('.help-l .contact-box li').find('.weixin').remove();
    });
}
