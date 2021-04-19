package com.weitu.mpsplatform.commons.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 输出流操作
 * 
 * @author 
 */
public class SInputStreamUtil {
	/**
	 * 空InputStream
	 */
	private static InputStream EMPTY_ISTREAM = new ByteArrayInputStream(new byte[0]);
	
	private SInputStreamUtil(){
		
	}
	
	/**
	 * 字符串转InputStream
	 * @param string
	 * @param charsetName
	 * @return InputStream
	 * @throws UnsupportedEncodingException
	 */
	public static InputStream stringToInputStream(String string,String charsetName) throws UnsupportedEncodingException{
		InputStream  inputStream = null;
		inputStream = new  ByteArrayInputStream(string.getBytes(charsetName));
		return inputStream;
	}
	
	/**
	 * 从InputStream里面取得byte[]
	 * @param inputStream
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] getBytes(InputStream inputStream) throws IOException{
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		byte[] returnByte=null;
		try{
			int b;
			while((b=inputStream.read())>=0){
				baos.write(b);
			}
			returnByte=baos.toByteArray();
		}finally{
		    baos.close();
		}
		return returnByte;
	}
	
	/**
	 * 从InputStream里面取得固定长度的byte[]
	 * @param inputStream
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] getBytes(InputStream inputStream,int length) throws IOException{
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		int b;
		int i = 0;
		byte[] bytes=null;
		try{
	        while(((b=inputStream.read())>=0)&&(i<length)){
	            baos.write(b);
	            i++;
	        }
	        bytes=baos.toByteArray();
		}finally{
		    baos.close();
		}
		
		return bytes;
	}
	
	/**
	 * 把InputStream转换成encoding类型的字符串
	 * @param inputStream
	 * @param encoding
	 * @return String
	 */
    public static String getContentsAsString(InputStream inputStream, String encoding){
        String string="";
        try{
            if(encoding!=null) {
            	string=new String(getBytes(inputStream), encoding);
            }else {
            	string=new String(getBytes(inputStream));
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return string;
    }
    
	/**
	 * 把InputStream中的固定长度的部分转换成encoding类型的字符串
	 * @param inputStream
	 * @param encoding
	 * @return String
	 */
    public static String getContentsAsString(InputStream inputStream, int length,String encoding){
        String string="";
        try{
            if(encoding!=null) {
            	string=new String(getBytes(inputStream,length), encoding);
            }else {
            	string=new String(getBytes(inputStream,length));
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return string;
    }
    
    /**
     * 比较两个InputStream是否完全一样
     * @param inputStream1
     * @param inputStream2
     * @return boolean
     * @throws IOException
     */
    public static boolean compare(InputStream inputStream1, InputStream inputStream2) throws IOException {
		for (int b = 0; b >= 0;){
			if ((b = inputStream1.read()) != inputStream2.read()){
				return false;
			}
		}
		return true;
	}
    
    /**
	 * 关闭InputStream
	 * 
	 * @param inputStream
	 */
    public static void closeInputStream(InputStream inputStream){
    	try{
    		if(inputStream!=null){
    			inputStream.close();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 取得一个空的InputStream
     *
     */
    public static InputStream getEmptyInputStream(){
    	return EMPTY_ISTREAM;
    }
    
    public static InputStream bytesToInputStream(byte[] theBytes){
    	return new ByteArrayInputStream(theBytes);
    }


	/**
	 * 转换BufferedImage 数据为byte数组
	 *
	 * @param bImage
	 * Image对象
	 * @param format
	 * image格式字符串.如"gif","png"
	 * @return byte数组
	 */
	public static byte[] imageToBytes(BufferedImage bImage, String format) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(bImage, format, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toByteArray();
	}

	/**
	 * 转换byte数组为Image
	 *
	 * @param bytes
	 * @return Image
	 */
	public static Image bytesToImage(byte[] bytes) {
		Image image = Toolkit.getDefaultToolkit().createImage(bytes);
		try {
			MediaTracker mt = new MediaTracker(new Label());
			mt.addImage(image, 0);
			mt.waitForAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return image;
	}
}
