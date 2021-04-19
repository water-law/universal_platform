package com.weitu.mpsplatform.common;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

/**
 * @Description 共用类
 * @Author: 范森华
 * @Date 2019/7/15 15:27
 * @Param
 * @return
 **/
public class ServiceCommon {
    public static final Logger log = Logger.getLogger(ServiceCommon.class);
    public static SimpleDateFormat ymdhmsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static JSONObject getResponseObj(){
        JSONObject responseObj = new JSONObject();
        responseObj.put("status",200);
        responseObj.put("message","成功");
        responseObj.put("data",null);
        return responseObj;

    }



    /**
     * 写入错误日志
     * @param e
     */
    public static void writerErrorLog(Exception e){
        Writer writer = new StringWriter();
        PrintWriter p   = new PrintWriter(writer);
        e.printStackTrace(p);
        System.out.println("打印错误:"+writer.toString());
        JSONObject obj = new JSONObject();
        obj.put("logType","error");
        obj.put("logInfo",writer.toString());
        log.info(obj);
        if(null != writer){
            try{
                writer.flush();
                writer.close();
                p.flush();
                p.close();
            }catch (Exception ef){}
        }
    }

    /**
     * 获取访问IP
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 验证
     * @param mobilesId
     * @return
     */
    public static boolean resultVerify(String phone,String mobilesId){
        try{
            StringBuilder result = new StringBuilder();
            int [] snNum = new int[11];
            String code   =  mobilesId.substring(0,4);
            String resultData = mobilesId.substring(4,mobilesId.length()-5);
            for(int i=0;i<phone.length();i++){
                int j = i%code.length();
                snNum[i]=phone.charAt(i)^code.charAt(j);
            }
            for(int k=0;k<phone.length();k++){
                result.append(snNum[k]+"");
            }
            if(resultData.equals(result.toString())){

                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
