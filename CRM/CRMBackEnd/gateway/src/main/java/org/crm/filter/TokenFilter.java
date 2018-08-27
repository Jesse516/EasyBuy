package org.crm.filter;
import com.google.common.base.Strings;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {//大型项目可能会有很多过滤器（过滤器链），数字越小级别越高，越先调用去执行过滤
        return 0;
    }

    @Override
    public boolean shouldFilter() {//是否启用，true表示启用
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        String token=request.getParameter("token");
        if(Strings.isNullOrEmpty(token)&&!request.getRequestURL().equals("/api/userlogin")){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("请先登录");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return null;
    }
}
