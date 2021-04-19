package com.weitu.mpsplatform.commons.http;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Map;


/**
 * HttpClientUtil
 * 
 * @author 
 */
public class HttpClientUtil {
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);
    private static PoolingHttpClientConnectionManager cm;  
    private static String EMPTY_STR = "";  
    private static String UTF_8 = "UTF-8";  
  
    private static void init() {  
        if (cm == null) {  
            cm = new PoolingHttpClientConnectionManager();  
            // 整个连接池最大连接数
            cm.setMaxTotal(50);  
            // 每路由最大连接数，默认值是2 
            cm.setDefaultMaxPerRoute(5); 
        }  
    }  
  
    /** 
     * 通过连接池获取HttpClient 
     *  
     * @return 
     */  
    private static CloseableHttpClient getHttpClient() {  
        init();  
        return (CloseableHttpClient)(wrapClient(HttpClients.custom().setConnectionManager(cm).build()));  
    }  
  
    /** 
     *  
     * @param url 
     * @return 
     */  
    public static String httpGetRequest(String url) {  
        HttpGet httpGet = new HttpGet(url);  
        return getResult(httpGet);  
    }  
  
    public static String httpGetRequest(String url, Map<String, Object> params) throws URISyntaxException {  
        URIBuilder ub = new URIBuilder(url);
//        ub.setPath(url);
  
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);  
        ub.setParameters(pairs);  
  
        HttpGet httpGet = new HttpGet(ub.build());  
        return getResult(httpGet);  
    }  
  
    public static String httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params)  
            throws URISyntaxException {  
        URIBuilder ub = new URIBuilder(url);
//        ub.setPath(url);
  
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);  
        ub.setParameters(pairs);  
  
        HttpGet httpGet = new HttpGet(ub.build());  
        for (Map.Entry<String, Object> param : headers.entrySet()) {  
            httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));  
        }  
        return getResult(httpGet);  
    }  
    
    public static String httpPostRequest(String url) {  
        HttpPost httpPost = new HttpPost(url);  
        return getResult(httpPost);  
    }  
  
    public static String httpPostRequest(String url, Map<String, Object> params) throws UnsupportedEncodingException {  
        HttpPost httpPost = new HttpPost(url);  
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);  
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));  
        return getResult(httpPost);  
    }  
  
    public static String httpPostRequest(String url, Map<String, Object> headers, Map<String, Object> params)  
            throws UnsupportedEncodingException {  
        HttpPost httpPost = new HttpPost(url);  
  
        for (Map.Entry<String, Object> param : headers.entrySet()) {  
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));  
        }  
  
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);  
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));  
  
        return getResult(httpPost);  
    }  
    
    public static String httpPostRequest(String url, String paramJson)  
            throws ClientProtocolException, IOException {  
        HttpPost post = new HttpPost(url);  
        post.setHeader("Content-Type", "application/json");
        
        // json传递
        StringEntity postingString = new StringEntity(paramJson,"UTF-8");  
        postingString.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(postingString); 
        
        return getResult(post);
    }
    
  
    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {  
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();  
        for (Map.Entry<String, Object> param : params.entrySet()) {  
            pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));  
        }  
  
        return pairs;  
    }  
  
    /** 
     * 处理Http请求 
     *  
     * @param request 
     * @return 
     */  
    private static String getResult(HttpRequestBase request) {  
        // CloseableHttpClient httpClient = HttpClients.createDefault();  
        CloseableHttpClient httpClient = getHttpClient();  
        try {  
            CloseableHttpResponse response = httpClient.execute(request);  
            // response.getStatusLine().getStatusCode();  
            HttpEntity entity = response.getEntity();  
            if (entity != null) {  
                // long len = entity.getContentLength();// -1 表示长度未知  
                String result = EntityUtils.toString(entity,"UTF-8");  
                response.close();  
                // httpClient.close();  
                return result;  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
            log.error("{}", e);
        } catch (IOException e) {  
            log.error("{}", e);
        } finally {  

        }  
  
        return EMPTY_STR;  
    } 
    public static HttpClient wrapClient(HttpClient base) {  
        try {  
            SSLContext ctx = SSLContext.getInstance("TLS");  
            X509TrustManager tm = new X509TrustManager() {  
                @Override
                public X509Certificate[] getAcceptedIssuers() {  
                    return null;  
                }  
      
                @Override
                public void checkClientTrusted(X509Certificate[] arg0,  
                        String arg1) throws CertificateException {  
                }  
      
                @Override
                public void checkServerTrusted(X509Certificate[] arg0,  
                        String arg1) throws CertificateException {  
                }  
            };  
            ctx.init(null, new TrustManager[] { tm }, null);  
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx,NoopHostnameVerifier.INSTANCE);  
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(ssf).build();  
            return httpclient;  
        } catch (Exception ex) {  
            return HttpClients.createDefault();  
        }  
    }  
    
    public static String postForObject(String url,Map<String, Object> params) throws UnsupportedEncodingException{
        String result2="";
        Gson gson = new Gson();
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        String jsonObj = gson.toJson(params);
        org.springframework.http.HttpEntity<String> formEntity = new org.springframework.http.HttpEntity<String>(jsonObj, headers);
        String result = restTemplate.postForObject(url,formEntity,String.class);
        result2 = new String(result.getBytes("iso-8859-1"), "UTF-8");
        return result2;
    }
    
    public static String httpPostForObject(String url,String jsonObj) throws UnsupportedEncodingException{
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        org.springframework.http.HttpEntity<String> formEntity = new org.springframework.http.HttpEntity<String>(jsonObj, headers);
        String result = restTemplate.postForObject(url,formEntity,String.class);
        return result;
    }
    
    public static String sendPost(String url, String param) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST"); 
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            log.error("sendPost-----------",e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                log.error("sendPost",ex);
            }
        }
        return result;
    }
    
}