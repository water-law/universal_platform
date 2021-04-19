package com.weitu.mpsplatform.commons.utils;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//import org.apache.log4j.Logger;

public class HttpRequestProxy {
	/**
	 * 连接超时
	 */
	private static int connectTimeOut = 5000;

	/**
	 * 读取数据超时
	 */
	private static int readTimeOut = 10000;

	/**
	 * 请求编码
	 */
	private static String requestEncoding = "utf-8";

//	private static Logger logger = Logger.getLogger(HttpRequestProxy.class);

	/**
	 * <pre>
	 * 发送带参数的GET的HTTP请求
	 * </pre>
	 *
	 * @param reqUrl     HTTP请求URL
	 * @param parameters 参数映射表
	 * @return HTTP响应的字符串
	 */
	public static String doGet(String reqUrl, Map parameters,
	                           String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		try {
			StringBuffer params = new StringBuffer();
			buildRequestParameter(parameters, params);

			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}

			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("GET");
			System.setProperty("sun.net.client.defaultConnectTimeout",
					String.valueOf(HttpRequestProxy.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
			System.setProperty("sun.net.client.defaultReadTimeout",
					String.valueOf(HttpRequestProxy.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时
			// url_con.setConnectTimeout(5000);//（单位：毫秒）jdk
			// 1.5换成这个,连接超时
			// url_con.setReadTimeout(5000);//（单位：毫秒）jdk 1.5换成这个,读操作超时
			url_con.setDoOutput(true);
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			InputStream in = url_con.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(in,
					recvEncoding));
			String tempLine = rd.readLine();
			StringBuffer temp = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			while (tempLine != null) {
				temp.append(tempLine);
				temp.append(crlf);
				tempLine = rd.readLine();
			}
			responseContent = temp.toString();
			rd.close();
			in.close();
		} catch (IOException e) {
//			logger.error("网络故障", e);
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}

		return responseContent;
	}

	/**
	 * <pre>
	 * 发送不带参数的GET的HTTP请求
	 * </pre>
	 *
	 * @param reqUrl HTTP请求URL
	 * @return HTTP响应的字符串
	 */
	public static String doGet(String reqUrl, String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		try {
			StringBuffer params = new StringBuffer();
			String queryUrl = reqUrl;
			int paramIndex = reqUrl.indexOf("?");

			if (paramIndex > 0) {
				queryUrl = reqUrl.substring(0, paramIndex);
				String parameters = reqUrl.substring(paramIndex + 1,
						reqUrl.length());
				String[] paramArray = parameters.split("&");
				for (int i = 0; i < paramArray.length; i++) {
					String string = paramArray[i];
					int index = string.indexOf("=");
					if (index > 0) {
						String parameter = string.substring(0, index);
						String value = string.substring(index + 1,
								string.length());
						params.append(parameter);
						params.append("=");
						params.append(URLEncoder.encode(value,
								HttpRequestProxy.requestEncoding));
						params.append("&");
					}
				}

				params = params.deleteCharAt(params.length() - 1);
			}

			URL url = new URL(queryUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("GET");
			System.setProperty("sun.net.client.defaultConnectTimeout",
					String.valueOf(HttpRequestProxy.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
			System.setProperty("sun.net.client.defaultReadTimeout",
					String.valueOf(HttpRequestProxy.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时
			// url_con.setConnectTimeout(5000);//（单位：毫秒）jdk
			// 1.5换成这个,连接超时
			// url_con.setReadTimeout(5000);//（单位：毫秒）jdk 1.5换成这个,读操作超时
			url_con.setDoOutput(true);
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();
			InputStream in = url_con.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(in,
					recvEncoding));
			String tempLine = rd.readLine();
			StringBuffer temp = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			while (tempLine != null) {
				temp.append(tempLine);
				temp.append(crlf);
				tempLine = rd.readLine();
			}
			responseContent = temp.toString();
			rd.close();
			in.close();
		} catch (IOException e) {
//			logger.error("网络故障", e);
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}

		return responseContent;
	}

	/**
	 *
	 * @param apiUrl 接口请求地址
	 * @param paramsMap 请求参数集合
	 * @return xml字符串，格式请参考文档说明
	 * String
	 */
	public static String sendHttpPost(String apiUrl, Map<String, String> paramsMap) {
		CloseableHttpClient client = HttpClients.createDefault();
		String responseText = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost method = new HttpPost(apiUrl);
			if (paramsMap != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (Entry<String, String> param : paramsMap.entrySet()) {
					NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
					paramList.add(pair);
				}
				method.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
			}
			response = client.execute(method);
			org.apache.http.HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseText = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseText;
	}


	/**
	 * <pre>
	 * 发送带参数的POST的HTTP请求
	 * </pre>
	 *
	 * @param reqUrl     HTTP请求URL
	 * @param parameters 参数映射表
	 * @return HTTP响应的字符串
	 */
	public static String doPost(String reqUrl, Map parameters,
	                            String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		try {
			StringBuffer params = new StringBuffer();
			buildRequestParameter(parameters, params);

			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}

			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("POST");
			System.setProperty("sun.net.client.defaultConnectTimeout",
					String.valueOf(HttpRequestProxy.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
			System.setProperty("sun.net.client.defaultReadTimeout",
					String.valueOf(HttpRequestProxy.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时
			// url_con.setConnectTimeout(5000);//（单位：毫秒）jdk
			// 1.5换成这个,连接超时
			// url_con.setReadTimeout(5000);//（单位：毫秒）jdk 1.5换成这个,读操作超时
			url_con.setDoOutput(true);
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			InputStream in = url_con.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(in,
					recvEncoding));
			String tempLine = rd.readLine();
			StringBuffer tempStr = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			while (tempLine != null) {
				tempStr.append(tempLine);
				tempStr.append(crlf);
				tempLine = rd.readLine();
			}
			responseContent = tempStr.toString();
			rd.close();
			in.close();
		} catch (IOException e) {
//			logger.error("网络故障", e);
			System.out.println(e);
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;
	}

	private static HttpClient getClient() {
		HttpClient httpClient = new HttpClient();
		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header("Content-Type", "application/json;charset=UTF-8"));
		httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
		return httpClient;
	}

	public static String excetePost(String url, String jsonStr) {
		HttpClient httpClient = getClient();
		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestEntity(new StringRequestEntity(jsonStr));
		InputStream responseBody = null;
		try {
			httpClient.executeMethod(postMethod);
			responseBody = postMethod.getResponseBodyAsStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader reader = null;
		if (responseBody != null) {
			try {
				reader = new BufferedReader(new InputStreamReader(responseBody, "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String returnString = "";
		if (reader != null) {
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e1) {
				line = null;
			}
			while (line != null) {
				returnString += line;
				try {
					line = reader.readLine();
				} catch (IOException e) {
					line = null;
				}
			}
		}
		return returnString;
	}

	private static void buildRequestParameter(Map parameters, StringBuffer params) throws UnsupportedEncodingException {
		if (parameters != null) {
			for (Iterator iter = parameters.entrySet().iterator(); iter.hasNext(); ) {
				Entry element = (Entry) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(),
						HttpRequestProxy.requestEncoding));
				params.append("&");
			}
		}
	}

	/**
	 * @return 连接超时(毫秒)
	 */
	public static int getConnectTimeOut() {
		return HttpRequestProxy.connectTimeOut;
	}

	/**
	 * @return 读取数据超时(毫秒)
	 */
	public static int getReadTimeOut() {
		return HttpRequestProxy.readTimeOut;
	}

	/**
	 * @return 请求编码
	 */
	public static String getRequestEncoding() {
		return requestEncoding;
	}

	/**
	 * @param connectTimeOut 连接超时(毫秒)
	 */
	public static void setConnectTimeOut(int connectTimeOut) {
		HttpRequestProxy.connectTimeOut = connectTimeOut;
	}

	/**
	 * @param readTimeOut 读取数据超时(毫秒)
	 */
	public static void setReadTimeOut(int readTimeOut) {
		HttpRequestProxy.readTimeOut = readTimeOut;
	}

	/**
	 * @param requestEncoding 请求编码
	 */
	public static void setRequestEncoding(String requestEncoding) {
		HttpRequestProxy.requestEncoding = requestEncoding;
	}

	/*
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("actionType", "1");
		// map.put("issueId", "33");
		String temp = HttpRequestProxy.doPost(
				"http://192.168.0.99/AgentPortal/autoHandler", map, "GBK");
		System.out.println("返回的消息是:" + temp);

	}
	*/
}
