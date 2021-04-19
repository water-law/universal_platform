package com.weitu.mpsplatform.commons.utils;

import com.google.gson.Gson;
import com.weitu.mpsplatform.commons.constants.SaasPlatConstants;
import com.weitu.mpsplatform.commons.constants.SaasSuppConstants;
import com.weitu.mpsplatform.commons.enums.DataPermissionLevelEnum;
import com.weitu.mpsplatform.commons.exception.BaseException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

/**
 * 系统公用方法
 * @author fansenhua
 */
public class BaseCommonTools {
    private static final Logger log = LoggerFactory.getLogger(BaseCommonTools.class);

    /**
     * 参数类型
     */
    public static final String PARAMS_FORMAT_JSON = "json";

    /**
     * GET
     */
    public static final String REQUEST_METHOD_GET_NAME = "GET";
    /**
     * GET
     */
    public static final String REQUEST_METHOD_POST_NAME = "POST";
    /**
     * CHARSET
     */
    public static final String CHARSET_KEY = "CHARSET";
    /**
     * 字符集:GBK
     */
    public static final String CHARSET_GBK = "GBK";
    /**
     * 字符集:UTF-8
     */
    public static final String CHARSET_UTF8 = "UTF-8";
    
    /**
     * 允许上次的文件类型白名单
     */
    private static final List<String> FILE_TYPES_LIST = new ArrayList<String>(Arrays.asList(
        "xls",
        "xlsx",
        "csv", 
        "doc", 
        "docx",
        "ppt", 
        "pptx",
        "wps",
        "zip", 
        "rar", 
        "7z", 
        "jpg", 
        "jpeg", 
        "png", 
        "bmp", 
        "txt", 
        "xml", 
        "html",
        "htm",
        "pdf",
        "ico",
        "gif"));
    
    /**
     * 允许上传的图片类型
     */
    private static final List<String> IMAGE_TYPES_LIST = new ArrayList<String>(Arrays.asList(
        "jpg", 
        "jpeg", 
        "png", 
        "bmp", 
        "ico",
        "gif",
        "image"));
    
    private static Gson gson = new Gson();

    private BaseCommonTools() {

    }

    public static boolean isAjax(HttpServletRequest request) {
        boolean ajaxType = SString.getTrimString(request.getHeader("X-Requested-With"))
            .equalsIgnoreCase("XMLHttpRequest");
        return ajaxType;
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    /**
     * 获取ip
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = SString.getTrimString(request.getHeader("X-Forwarded-For"));
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(",") > -1) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }

    /**
     * 并列条件对象判断处理
     * 
     * @param value 
     *  等于0为true，否则为false
     *  暂时处理小数点后两位的小数
     * @return
     */
    public static boolean convertObjectZERO(Object value) {
        if (value != null && !value.equals(null)) {
            if ("0.00".equals(value.toString()) || "0.0".equals(value.toString())
                || "0".equals(value.toString()) || "0.000".equals(value.toString())
                || "0.0000".equals(value.toString()) || "0.00000".equals(value.toString())
                || "0.000000".equals(value.toString())) {
                value = new BigDecimal(0);
            }
            if (value.equals(BigDecimal.ZERO)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将BigDecimal对象转换成负数
     * 
     * 
     * @param value
     * @param expStr 表达式
     * @return
     */
    public static BigDecimal negativeNumFromBigDecimal(Object value, String expStr) {
        BigDecimal returnBigDec = new BigDecimal("0.00");
        if (value != null && !value.equals(null)) {
            if (!convertObjectZERO(value)) {
                BigDecimal decimal = (BigDecimal) value;
                String bigdecStr = SString.getString(value);
                //负数情况
                if (SString.isNotBlank(expStr) && expStr.startsWith("-")
                    && !bigdecStr.startsWith("-")) {
                    returnBigDec = decimal.multiply(new BigDecimal(-1));
                //正数情况
                } else if (SString.isBlank(expStr) && bigdecStr.startsWith("-")) {
                    returnBigDec = decimal.abs();
                } else {//返回正常
                    returnBigDec = new BigDecimal(bigdecStr);
                }
            }
        }
        return returnBigDec.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 异步请求通知参数转换
     * 
     * @param requestParams
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map<String, String> getParameterMap(Map requestParams) {
        Map<String, String> params = new LinkedHashMap<String, String>();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                    : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
            log.debug("异步请求通知SPI参数转换---------------------------------------- " + name + ">>>" + valueStr);
        }
        return params;
    }

    /**
     * 异步请求通知参数转换
     * 
     * @param request
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, String> getParameterMapForReq(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String, String>();
        Enumeration enumeration = request.getParameterNames();
        if (enumeration == null) {
            return params;
        }
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = request.getParameter(key);
            params.put(key, value);

            log.debug("异步请求通知SPI参数转换---------------------------------------- " + key + ">>>" + value);
        }
        return params;
    }
    
    /**
     * 从request中获取流数据得到字符串
     * 
     * @param request
     * @return
     */
    public static String getRequestInputStreamStr(HttpServletRequest request) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), CHARSET_UTF8));
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            log.error("从request中获取流数据得到字符串错误",e);
        } finally {
            if( reader !=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("从request中获取流数据得到字符串错误",e);
                }
            }
        }
        
        log.info("从request.getInputStream中获取流数据得到字符串---------------------------------------- " + stringBuilder.toString());
        return stringBuilder.toString();
    }
    
    /**
     * request中读取流数据，返回字符串
     * 
     * @author fsh
     * @param request
     * @return
     */
    public static String getRequestWechatNotifyXml(HttpServletRequest request) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = request.getReader();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            log.error("从request中读取流数据，返回字符串错误",e);
        } finally {
            if( reader !=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("从request中读取流数据，返回字符串错误",e);
                }
            }
        }
        
        log.info("从request.getReader中获取流数据得到字符串---------------------------------------- " + stringBuilder.toString());
        return stringBuilder.toString();
    } 

    
    /**
     * 异步请求通知参数转换
     *  剔除sign、sign_type两个参数
     *    在通知返回参数列表中，除去sign、sign_type两个参数外，
     *    凡是通知返回回来的参数皆是待验签的参数。
     * 
     * @param params
     * @return
     */
    public static String getSignContentOfParams(Map<String, String> params) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
        params.remove("sign");
        params.remove("sign_type");
        if (params instanceof TreeMap) {
            return getSignContent(params);
        } else {
            sortedMap.putAll(params);
            return getSignContent(sortedMap);
        }
    }
    
    /**
     * 异步请求通知参数转换
     *    凡是通知返回回来的参数皆是待验签的参数。
     * 
     * @param params
     * @return
     */
    public static String getSignContentOfParamsNoRemove(Map<String, String> params) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
        if (params instanceof TreeMap) {
            return getSignContent(params);
        } else {
            sortedMap.putAll(params);
            return getSignContent(sortedMap);
        }
    }
    

    /**
     * 返回验签内容
     *  // 待优化，使用entrySet处理
     * 
     * @param sortedParams
     * @return
     */
    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = sortedParams.get(key);
            if (SString.isNotBlank(key) && value !=null) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    /** 
     * 校验密码 
     * 1、长度不小于6位 
     * 2、必须以字母开头 
     * 3、必须包含特殊字符 --false
     * 4、必须包含数字 
     * @param pwd 
     * @return 
     */
    public static boolean validPwd(String pwd) {
        if (SString.isBlank(pwd)) {
            return false;
        }
        if (pwd.length() < 6) {
            return false;
        }
        if (pwd.matches("(.*)[a-zA-z](.*)") && pwd.matches("(.*)\\d+(.*)")) {
            return true;
        }
        return false;
    }

    /**
     * 构造URL附带的请求参数串
     * 格式：aa=1&b=2&c=3
     * 
     * @param params
     * @param charset
     * @return
     * @throws IOException
     */
    public static String buildQuery(Map<String, String> params, String charset) throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }
        if(SString.isBlank(charset)){
            charset = CHARSET_UTF8;
        }

        StringBuilder query = new StringBuilder();
        Set<Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (StringUtil.areNotEmpty(name, value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }

                query.append(name).append("=").append(URLEncoder.encode(value, charset));
            }
        }
        return query.toString();
    }
    
    /**
     * 从URL中提取所有的参数。
     * 
     * @param query URL地址
     * @return 参数映射
     */
    public static Map<String, Object> splitUrlQuery(String query) {
        Map<String, Object> result = new HashMap<String, Object>(16);

        String[] pairs = query.split("&");
        if (pairs != null && pairs.length > 0) {
            for (String pair : pairs) {
                String[] whStr = pair.split("\\?");
                if(whStr.length >0 ){
                    for(String whs : whStr){
                        String[] whsparam = whs.split("=", 2);
                        if (whsparam != null && whsparam.length == 2) {
                            result.put(whsparam[0],whsparam[1]);
                        }
                    }
                } else {
                    String[] param = pair.split("=", 2);
                    if (param != null && param.length == 2) {
                        result.put(param[0], param[1]);
                    }
                }
            }
        }
        return result;
    }
    
    public static URL getPlatCommonResList(String filePath){
        if(SString.isBlank(SString.getTrimString(filePath))){
            return null;
        }
        if(filePath.startsWith("/")){
            filePath = filePath.substring(1);
        }
        
        String saasplatResFiles = "classpath*:META-INF/res/" + filePath;
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = null;
        URL path = null;
        try {
            resources = resolver.getResources(saasplatResFiles);
            String[] fileArray = new String[resources.length];
            for (int i = 0; i < fileArray.length; i++) {
                log.debug(" ~~~~~ file--resources[i].getFile() ~~~~~~" + resources[i].getURL().getFile());
                
                path = resources[i].getURL();
                if(path !=null){
                    break;
                } else {
                    continue;
                }
            }
        } catch (IOException e) {
        }
        return path;
    }
    
    /**
     * 生成png -base64图片字符串
     * 
     * @param imageByte
     * @return
     */
    public static String getImagePng(byte[] imageByte) {
        String preStr = "data:image/png;base64,";
        String content = new String(Base64.encodeBase64(imageByte));
        return preStr + content;
    }
    
    
    /**
     * 生成jpg -base64图片字符串
     * 
     * @param imageByte
     * @return
     */
    public static String getImageJPEG(byte[] imageByte) {
        String preStr = "data:image/jpeg;base64,";
        String content = new String(Base64.encodeBase64(imageByte));
        return preStr + content;
    }
    
    
    /**
     * 图片url转base64
     * 
     * @author fsh
     * @param url 图片Url
     * @return
     * @throws Exception
     */
    public static String getUrlImageToBase64(String url){  
        String res = "";
        try {
            if (url == null || "".equals(url.trim()))  
                return null;  
            URL u = new URL(url);  
            // 打开图片路径  
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();  
            // 设置请求方式为GET  
            conn.setRequestMethod("GET");  
            // 设置超时响应时间为5秒  
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            // 通过输入流获取图片数据  
            InputStream inStream = conn.getInputStream(); 
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
            byte[] buff = new byte[1024];  
            int rc = 0;  
            while ((rc = inStream.read(buff, 0, 1024)) > 0) {  
                swapStream.write(buff, 0, rc);  
            }  
            byte[] in2b = swapStream.toByteArray();
            // 读取图片字节数组  
            inStream.close();  
            // 返回Base64编码过的字节数组字符串 
            String result = Base64Utils.encodeToString(in2b);
            res = "data:image/jpg;base64,"+result;
        } catch (Exception e) {
            log.error("图片url转base64失败", e);
            throw new BaseException(e);
        }  
        return res;    
    }
    
    /**
     * 处理第三方返回url没有https路径
     * 
     * @author fsh
     * @param url
     * @return
     */
    public static String getThirdRequestFullUrl(String url) {
        if (SString.isBlank(url)) {
            return null;
        }
        if (url.toLowerCase().startsWith("https:") || url.toLowerCase().startsWith("http:")) {
            return url;
        }
        url = new StringBuilder().append("https://").append(url).toString();
        return url;
    }

    /**
     * 获取数据权限级别值
     * @param request
     * @return
     */
    private static Integer getMenuDataLevelValue(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        return (Integer) request.getAttribute(SaasPlatConstants.CustomAttributeConstants.REQUEST_ATTRIBUTE_MENU_DATA_LEVEL);
    }

    /**
     * 获取数据权限级别枚举对象
     * @param request
     * @return
     */
    public static DataPermissionLevelEnum getMenuDataLevel(HttpServletRequest request) {
        Integer levelValue = BaseCommonTools.getMenuDataLevelValue(request);
        if (null != levelValue) {
            return DataPermissionLevelEnum.getByLevelValue(levelValue);
        }
        return null;
    }

}