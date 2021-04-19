package com.weitu.mpsplatform.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 
 * @author senhuaF-31049
 * @version $Id: SRegex.java, v 0.1 2016年9月19日 上午10:07:46 senhuaF-31049 Exp $
 */
public final class SRegex {
	
	private SRegex(){
		
	}
	
	/**
	 * 根据正则表达式替换所有字符串
	 * @param oldString
	 * @param replaceString
	 * @param regex
	 * @return String
	 */
	public static String getReplaceAll(String oldString,String replaceString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		String newString=matcher.replaceAll(replaceString);
		return newString;
	}	
	/**
	 * 根据正则表达式替换所有字符串
	 * @param oldString
	 * @param replaceString
	 * @param regex
	 * @param flag
	 * @return String
	 */
	public static String getReplaceAll(String oldString,String replaceString,String regex,int flag){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex,flag);
		matcher=pattern.matcher(oldString);
		String newString=matcher.replaceAll(replaceString);
		return newString;
	}
	
	/**
	 * 根据正则表达式替换第一个符合要求的字符串
	 * @param oldString
	 * @param replaceString
	 * @param regex
	 * @return String
	 */
	public static String getReplaceFirst(String oldString,String replaceString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		String newString=matcher.replaceFirst(replaceString);
		return newString;
	}
	
	/**
	 * 根据正则表达式替换第一个符合要求的字符串
	 * @param oldString
	 * @param replaceString
	 * @param regex
	 * @param flag
	 * @return String
	 */
	public static String getReplaceFirst(String oldString,String replaceString,String regex,int flag){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex,flag);
		matcher=pattern.matcher(oldString);
		String newString=matcher.replaceFirst(replaceString);
		return newString;
	}
	
	/**
	 * 根据正则表达式查找字符串是否存在
	 * @param oldString
	 * @param regex
	 * @return boolean
	 */
	public static boolean find(String oldString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		boolean flag=matcher.find();
		return flag;
	}
	
	/**
	 * 根据正则表达式查找字符串是否存在
	 * @param oldString
	 * @param regex
	 * @param flag
	 * @return boolean
	 */
	public static boolean find(String oldString,String regex,int flag){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex,flag);
		matcher=pattern.matcher(oldString);
		boolean result=matcher.find();
		return result;
	}
	
	/**
	 * 根据正则表达式从某一位开始查找字符串是否存在
	 * @param oldString
	 * @param regex
	 * @param startIndex
	 * @return boolean
	 */
	public static boolean findIndex(String oldString,String regex,int startIndex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		boolean flag=false;
		if(startIndex>oldString.length()){
			return flag;
		}
		flag=matcher.find(startIndex);
		return flag;
	}
	
	/**
	 * 根据正则表达式从某一位开始查找字符串是否存在
	 * @param oldString
	 * @param regex
	 * @param flag
	 * @param startIndex
	 * @return boolean
	 */
	public static boolean findIndex(String oldString,String regex,int flag,int startIndex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex,flag);
		matcher=pattern.matcher(oldString);
		boolean result=false;
		if(startIndex>oldString.length()){
			return result;
		}
		result=matcher.find(startIndex);
		return result;
	}
	
	/**
	 * 根据正则表达式查找字符串出现的次数
	 * @param oldString
	 * @param regex
	 * @return int
	 */
	public static int findCount(String oldString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		int count=0;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		while(matcher.find()){
			count++;
		}
		return count;
	}
	
	/**
	 * 根据正则表达式查找字符串出现的次数
	 * @param oldString
	 * @param regex
	 * @param flag
	 * @return int
	 */
	public static int findCount(String oldString,String regex,int flag){
		Pattern pattern=null;
		Matcher matcher=null;
		int count=0;
		pattern=Pattern.compile(regex,flag);
		matcher=pattern.matcher(oldString);
		while(matcher.find()){
			count++;
		}
		return count;
	}
	
	/**
	 * 获取所有符合正则表达式的字符串
	 * @param oldString
	 * @param regex
	 * @return List
	 */
	public static List group(String oldString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		List stringList=new ArrayList();
		while(matcher.find()){
			stringList.add(matcher.group());
		}
		return stringList;
	}
	
	/**
	 * 获取所有符合正则表达式的字符串
	 * @param oldString
	 * @param regex
	 * @param flag
	 * @return List
	 */
	public static List group(String oldString,String regex,int flag){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex,flag);
		matcher=pattern.matcher(oldString);
		List stringList=new ArrayList();
		while(matcher.find()){
			stringList.add(matcher.group());
		}
		return stringList;
	}
	
	/**
	 * 将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里,并返回这个字符串
	 * @param oldString
	 * @param appendString
	 * @param regex
	 * @return String
	 */
	public static String appendTail(String oldString,String appendString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		StringBuffer newStringBuffer=new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(newStringBuffer,appendString);
		}
		matcher.appendTail(newStringBuffer);
		return newStringBuffer.toString();
	}
	
	/**
	 * 将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里,并返回这个字符串
	 * @param oldString
	 * @param appendString
	 * @param regex
	 * @param flag
	 * @return String
	 */
	public static String appendTail(String oldString,String appendString,String regex,int flag){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex,flag);
		matcher=pattern.matcher(oldString);
		StringBuffer newStringBuffer=new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(newStringBuffer,appendString);
		}
		matcher.appendTail(newStringBuffer);
		return newStringBuffer.toString();
	}
	
	/**
	 * 将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里,并返回这个字符串
	 * @param oldString
	 * @param appendString
	 * @param regex
	 * @return String
	 */
	public static String appendReplacement(String oldString,String appendString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		StringBuffer newStringBuffer=new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(newStringBuffer,appendString);
		}
		matcher.appendTail(newStringBuffer);
		return newStringBuffer.toString();
	}
	
	/**
	 * 将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里,并返回这个字符串
	 * @param oldString
	 * @param appendString
	 * @param regex
	 * @param flag
	 * @return String
	 */
	public static String appendReplacement(String oldString,String appendString,String regex,int flag){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex,flag);
		matcher=pattern.matcher(oldString);
		StringBuffer newStringBuffer=new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(newStringBuffer,appendString);
		}
		matcher.appendTail(newStringBuffer);
		return newStringBuffer.toString();
	}
	
	/**
	 * 检测目标字符串是否以匹配的子串起始
	 * @param oldString
	 * @param regex
	 * @return boolean
	 */
	public static boolean lookingAt(String oldString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		boolean flag=matcher.lookingAt();
		return flag;
	}
	
	/**
	 * 尝试对整个目标字符展开匹配检测，也就是只有整个目标字符串完全匹配时才返回真值
	 * @param oldString
	 * @param regex
	 * @return boolean
	 */
	public static boolean matches(String oldString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		boolean flag=matcher.matches();
		return flag;
	}
	
	/**
	 * 返回当前匹配的子串的最后一个字符在原目标字符串中的索引位置
	 * @param oldString
	 * @param regex
	 * @return int
	 */
	public static int end(String oldString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		int endIndex=matcher.end();
		return endIndex;
	}
	
	/**
	 * 返回与匹配模式里指定的组相匹配的子串最后一个字符的位置
	 * @param oldString
	 * @param regex
	 * @param group
	 * @return int
	 */
	public static int end(String oldString,String regex,int group){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		int endIndex=matcher.end(group);
		return endIndex;
	}
	
	/**
	 * 返回当前查找所获子串的开始字符在原目标字符串中的位置
	 * @param oldString
	 * @param regex
	 * @return int
	 */
	public static int start(String oldString,String regex){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		int startIndex=matcher.start();
		return startIndex;
	}
	
	/**
	 * 返回当前查找所获得的和指定组匹配的子串的第一个字符在原目标字符串中的位置
	 * @param oldString
	 * @param regex
	 * @param group
	 * @return int
	 */
	public static int start(String oldString,String regex,int group){
		Pattern pattern=null;
		Matcher matcher=null;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(oldString);
		int startIndex=matcher.start(group);
		return startIndex;
	}
	
	public static void main(String[] args){
		SRegex regex=new SRegex();
		String regexString="^[0-9]{11}$";
		boolean flag=regex.find("13600854670", regexString);
		System.out.println("flag="+flag);
	}
}
