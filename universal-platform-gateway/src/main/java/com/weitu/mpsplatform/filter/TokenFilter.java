package com.weitu.mpsplatform.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.weitu.mpsplatform.common.GateWayConstants;
import com.weitu.mpsplatform.feign.BaseServiceFeign;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 网关路由
 * @Author: 邱恒森
 * @CreateDate: 2019/3/16 18:09
 * @UpdateUser: 邱恒森
 * @UpdateDate: 2019/3/16 18:09
 * <p>
 * copyright: Copyright (c) 2019
 **/
public class TokenFilter extends ZuulFilter {

    public static final Logger log = Logger.getLogger(TokenFilter.class);
    @Autowired
    private BaseServiceFeign baseServiceFeign;

    @Value("${filter.exclude-path}")
    private String excludePathString;

    private String[] excludePaths;

    @Override
    public String filterType() {
        return "pre";// 前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0;// 优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() {
        JSONObject responseObj = new JSONObject();
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            String url = request.getRequestURI();//获取访问URL
            request.getParameterMap();
            String authorization = request.getHeader("Authorization");
            ctx.addZuulRequestHeader("Authorization", authorization);
            ctx.setResponseStatusCode(200);
            ctx.setSendZuulResponse(true);// 对该请求进行路由
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
            ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
            //String ip = ServiceCommon.getIpAddr(request);//获取访问IP地址
            Integer status =  urlFilter( url,authorization);
            log.info("=======status========"+status);
            Integer statusCode =  urlFilter( url,authorization);
            if(GateWayConstants.RespnseMsgEnum.SUCCESS.getStateCode() != statusCode){
                ctx.setResponseStatusCode(statusCode);
                //getResponseObj(status, responseObj);
                responseObj.put("messageContent", GateWayConstants.RespnseMsgEnum.getMsgByCode(statusCode));
                responseObj.put("data", null);
                ctx.setSendZuulResponse(false);// 过滤该请求， ctx.setResponseBody(responseObj.toString());不对其进行路由
                ctx.set("isSuccess", false);
                //ctx.setResponseStatusCode(HttpStatus.OK.value());// 返回错误码
                ctx.setResponseBody(responseObj.toString());
            }
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("网关路由拦截器：{}", e);
        }
        return null;
    }

//    /**
//     * 返回值
//     *
//     * @param status 状态
//     * @param responseObj 返回结果
//     */
//    private JSONObject getResponseObj(Integer status, JSONObject responseObj){
//        if(2 == status){//拒绝访问
//            responseObj.put("status",402);
//            responseObj.put("message","此账号在其他地方登录，为了账号安全，建议您修改密码");
//        }else if(3 == status){
//            responseObj.put("status",401);
//            responseObj.put("message","登录超时或未登录，请重新登录");
//        }else if(0 == status){
//            responseObj.put("status",403);
//            responseObj.put("message","登录超时或未登录，请重新登录");
//        }
//        return responseObj;
//    }

    /**
     * 验证
     *
     * @param url dd
     * @param authorization dd
     * @return 403：拒绝；200：通过；402：token变更；401：token失效
     */
    private Integer urlFilter(String url, String authorization) {
        String[] excludePaths = getExcludePaths();
        for (String s : excludePaths) {
            if (StringUtils.isNotEmpty(s) & url.contains(s)) {
                //return 1;
                return GateWayConstants.RespnseMsgEnum.SUCCESS.getStateCode();
            }
        }
        if (StringUtils.isNotBlank(authorization)) {//需要验证
            try {
                if("undefined".equals(authorization)){
                    //return 3;
                    return GateWayConstants.RespnseMsgEnum.NOT_LOGIN.getStateCode();
                }
                String redisToken = baseServiceFeign.tokenVerify(authorization);
                if (StringUtils.isNotBlank(redisToken)) {
                    if (authorization.equals(redisToken)) {
                        //return 1;
                        return GateWayConstants.RespnseMsgEnum.SUCCESS.getStateCode();
                    } else {
                        //return 2;
                        return GateWayConstants.RespnseMsgEnum.LOGIN_REPEAT.getStateCode();
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
                log.error("网关路由拦截器 --- urlFilter：{}", e);
            }
        }
        //return 0;
        return GateWayConstants.RespnseMsgEnum.NOT_ACCESS.getStateCode();
    }

    private String[] getExcludePaths() {
        if (excludePaths == null) {
            this.excludePaths = excludePathString.split(",");
        }
        return excludePaths;
    }

}
