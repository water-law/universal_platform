package com.weitu.mpsplatform.commons.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;

/**
 * 
 * 
 * @author senhuaF-31049
 * @version $Id: SPath.java, v 0.1 2016年9月19日 上午10:07:26 senhuaF-31049 Exp $
 */
public final class SPath {
	
	private SPath(){
		
	}
	
    /**
     * 将路径中的"\"全部替换成"/"
     * 
     * @param path
     * @return String
     */
    public static String getFormatFilePath(String path) {
    	String fileFlag="file://";
        path = path.replaceAll("\\\\", "/");
        path = path.replaceAll("//", "/");
        if(path.startsWith("file:/")&&(!path.startsWith(fileFlag))){
        	path=fileFlag+path.substring("file:/".length());
        }
        return path;
    }

    public static String getFormatFilePathWithoutPrefix(String path){
    	path=getFormatFilePath(path);
    	if(path.equals("")){
    		return "";
    	}
    	if(path.startsWith("file:/")){
    		path=path.replaceFirst("file:/", "");
    	}
    	return path;
    }

	/**
	 * 取得绝对路径
	 * @param base
	 * @param relative 相对路径
	 * @return URI
	 * @throws URISyntaxException 
	 */
	public static URI getResolved(String base,String relative) throws Exception{
		relative=SString.getString(relative,"");		
		
		URI uriBase=new URI(base);
		URI uriRelative=new URI(relative);
		URI uriResolved = uriBase.resolve(uriRelative);
		return uriResolved;
	}

	/**
	 * 取得相对路径
	 * @param base
	 * @param resolve
	 * @return URI
	 * @throws URISyntaxException 
	 */
	public static URI getRelativize(String base,String resolve) throws Exception{
		resolve=SString.getString(resolve,"");
		URI uriBase=new URI(base);
		URI uriResolve=new URI(resolve);
		URI uriRelativize = uriBase.relativize(uriResolve);
		return uriRelativize;
	}
	
	/**
	 * 取得Query
	 * @param base
	 * @return String
	 * @throws URISyntaxException 
	 */
	public static String getQuery(String base) throws Exception{
		URI uriBase=new URI(base);
		String query=uriBase.getQuery();
		query=SString.getString(query,"");
		if(!query.equals("")){
			query="?"+query;
		}
		return query;
	}
	/**
	 * uri地址补齐，最后带"/"
	 * @param uriPath
	 * @return
	 */
	public static String getPadUri(String uriPath) {
		StringBuffer stringBuffer = new StringBuffer();
		if (SString.isNotBlank(SString.getTrimString(uriPath))) {
			if (!uriPath.equals("/") && !uriPath.endsWith("/")) {
				stringBuffer.append(SString.getTrimString(uriPath)).append("/");
			}
		}
		return stringBuffer.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(URLDecoder.decode(SPath.getResolved("C:/Program Files/Common Files", "../Internet Explorer").toString(),"utf-8"));
	}
	
}
