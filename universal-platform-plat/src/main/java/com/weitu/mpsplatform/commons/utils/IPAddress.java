package com.weitu.mpsplatform.commons.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: 获取IP地址工具类
 * @Author: fansenhua
 * @CreateDate: 2019/8/16 19:39
 * @Version 1.0
 **/
public final class IPAddress {
    /**
     * 功能描述: 私有化构造器
     * @Author: senhuaF
     * @Date: 2019/9/9 15:57
     * @Version 1.0
     **/
    private IPAddress(){

    }

    /**
     * 获取Ip地址
     * @param request
     * @return
     */
    public static String getAddr(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(SString.isNotBlank(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(SString.isNotBlank(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (SString.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (SString.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (SString.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (SString.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (SString.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
        }
        // ipAddress = this.getRequest().getRemoteAddr();

        return ipAddress;
    }

//    /**
//     * 功能描述: 获取Ip地址
//     * @Author: senhuaF
//     * @Date: 2019/8/16 19:41
//     * @Version 1.0
//     **/
//    public static String getAddr(HttpServletRequest request){
//        String clientIp =request.getHeader("x-forwarded-for");
//        if(clientIp ==null || clientIp.length()==0 || "unknown".equalsIgnoreCase(clientIp)){
//            clientIp =request.getHeader("Proxy-Client-IP");
//        }
//        if(clientIp==null || clientIp.length()==0 || "unknown".equalsIgnoreCase(clientIp)){
//            clientIp=request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
//            clientIp = request.getHeader("X-Real-IP");
//        }
//        if (clientIp != null && clientIp.length() != 0) {
//            clientIp = clientIp.split(",")[0];
//        }
//        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
//            clientIp = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
//            clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
//            clientIp = request.getRemoteAddr();
//        }
//        /*
//         * 对于获取到多ip的情况下，找到公网ip.
//         */
//        String sIP = null;
//        if (clientIp != null && !clientIp.contains("unknown") && clientIp.indexOf(",") > 0) {
//            String[] ipsz = clientIp.split(",");
//            for (String anIpsz : ipsz) {
//                if (!isInnerIP(anIpsz.trim())) {
//                    sIP = anIpsz.trim();
//                    break;
//                }
//            }
//            /*
//             * 如果多ip都是内网ip，则取第一个ip.
//             */
//            if (null == sIP) {
//                sIP = ipsz[0].trim();
//            }
//            clientIp = sIP;
//        }
//        if (clientIp != null && clientIp.contains("unknown")){
//            clientIp =clientIp.replaceAll("unknown,", "");
//            clientIp = clientIp.trim();
//        }
//        if ("".equals(clientIp) || null == clientIp){
//            clientIp = "127.0.0.1";
//        }
//        return clientIp;
//    }
//
//    /**
//     * 判断IP是否是内网地址
//     * @param ipAddress ip地址
//     * @return 是否是内网地址
//     */
//    public static boolean isInnerIP(String ipAddress) {
//        boolean isInnerIp;
//        long ipNum = getIpNum(ipAddress);
//        /**
//         私有IP：A类  10.0.0.0-10.255.255.255
//         B类  172.16.0.0-172.31.255.255
//         C类  192.168.0.0-192.168.255.255
//         当然，还有127这个网段是环回地址
//         **/
//        long aBegin = getIpNum("10.0.0.0");
//        long aEnd = getIpNum("10.255.255.255");
//
//        long bBegin = getIpNum("172.16.0.0");
//        long bEnd = getIpNum("172.31.255.255");
//
//        long cBegin = getIpNum("192.168.0.0");
//        long cEnd = getIpNum("192.168.255.255");
//        isInnerIp = isInner(ipNum, aBegin, aEnd) || isInner(ipNum, bBegin, bEnd) || isInner(ipNum, cBegin, cEnd)
//                || ipAddress.equals("127.0.0.1");
//        return isInnerIp;
//    }
//    private static long getIpNum(String ipAddress) {
//        String[] ip = ipAddress.split("\\.");
//        long a = Integer.parseInt(ip[0]);
//        long b = Integer.parseInt(ip[1]);
//        long c = Integer.parseInt(ip[2]);
//        long d = Integer.parseInt(ip[3]);
//        return a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
//    }
//
//    private static boolean isInner(long userIp, long begin, long end) {
//        return (userIp >= begin) && (userIp <= end);
//    }
//    public static String getRealIP(HttpServletRequest request){
//        // 获取客户端ip地址
//        String clientIp = request.getHeader("x-forwarded-for");
//        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
//            clientIp = request.getRemoteAddr();
//        }
//        String[] clientIps = clientIp.split(",");
//        if(clientIps.length <= 1) return clientIp.trim();
//        // 判断是否来自CDN
//        if(isComefromCDN(request)){
//            if(clientIps.length>=2) return clientIps[clientIps.length-2].trim();
//        }
//        return clientIps[clientIps.length-1].trim();
//    }
//    private static boolean isComefromCDN(HttpServletRequest request) {
//        String host = request.getHeader("host");
//        return host.contains("www.189.cn") ||host.contains("shouji.189.cn") || host.contains(
//                "image2.chinatelecom-ec.com") || host.contains(
//                "image1.chinatelecom-ec.com");
//    }
}
