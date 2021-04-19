package com.weitu.mpsplatform.commons.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 
 * @author senhuaF-31049
 * @version $Id: SIpAddress.java, v 0.1 2017年6月13日 上午9:20:04 senhuaF-31049 Exp $
 */
public class SIpAddress {
    private SIpAddress(){
        
    }

    public static String getLocalMac() throws SocketException, UnknownHostException {
        InetAddress inetAddress=InetAddress.getLocalHost();
        NetworkInterface networkInterface=NetworkInterface.getByInetAddress(inetAddress);
        if(networkInterface==null) {
            String address=SString.getTrimString(inetAddress.getCanonicalHostName())+"_"+SString.getTrimString(inetAddress.getHostAddress());
            return address;
        }
        byte[] mac = networkInterface.getHardwareAddress();
        if(mac==null){
            return "";
        }
        StringBuffer macString = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            if(i!=0) {
                macString.append("-");
            }
            //字节转换为整数
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
            if(str.length()==1) {
                macString.append("0"+str);
            }else {
                macString.append(str);
            }
        }
        return macString.toString().toLowerCase();
    }
    
    public static String getLocalMac(InetAddress inetAddress) throws SocketException {
        NetworkInterface networkInterface=NetworkInterface.getByInetAddress(inetAddress);
        if(networkInterface==null) {
            String address=SString.getTrimString(inetAddress.getCanonicalHostName())+"_"+SString.getTrimString(inetAddress.getHostAddress());
            return address;
        }
        byte[] mac = networkInterface.getHardwareAddress();
        if(mac==null){
            return "";
        }
        StringBuffer macString = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            if(i!=0) {
                macString.append("-");
            }
            //字节转换为整数
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
            if(str.length()==1) {
                macString.append("0"+str);
            }else {
                macString.append(str);
            }
        }
        return macString.toString().toLowerCase();
    }

    /**
     * 获取Ip地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }

}
