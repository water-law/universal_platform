package com.weitu.mpsplatform.commons.utils;


import com.weitu.mpsplatform.commons.exception.BusinessException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * 
 *  类描述：
 * 
 *  @author:  senhuaF-31049
 *
 *  History:  2017年4月9日 下午4:34:32   senhuaF-31049   Created.
 *
 */
public final class SString {

    /**
     * 数字、小写字母、大写字母正则表达式
     */
    public static final String NUMBER_LOWERCASE_UPPERCASE_REGULAR = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{3,18}";

    private SString(){
		
	}
	
	public static boolean isBlank(String string){
	    if(string==null || string.equals("")){
	        return true;
	    }else{
	        return false;
	    }
	}
	
    public static boolean isNotBlank(String string){
        if(string!=null && !string.equals("")){
            return true;
        }else{
            return false;
        }
    }
	
    public static String getTrimString(String string){
    	return getString(string).trim();
    }
    
    public static String getTrimString(Object object){
    	return getString(object).trim();
    }
    
    /**
     * 处理字符串,将null转为""
     * @param string
     * @return String
     */
    public static String getString(String string) {
    	string = (string == null) ? "" : string;
        return string;
    }
    
    public static String getString(Object object){
    	if(object==null){
    		return "";
    	}
    	return String.valueOf(object);
    }

    /**
     * 处理字符串,如果str是null则用str1代替
     * 
     * @param oldstring
     * @param newstring
     * @return String
     */
    public static String getString(String oldstring, String newstring) {
    	oldstring=getString(oldstring);
    	oldstring = (oldstring.equals("")) ? newstring : oldstring;
        return oldstring;
    }

    /**
     * 处理字符串,如果str是null则用str1代替
     * 
     * @param oldObject
     * @param newstring
     * @return String
     */
    public static String getString(Object oldObject, String newstring) {
    	oldObject=getString(oldObject);
    	String theString = (oldObject.equals("")) ? newstring : String.valueOf(oldObject);
        return theString;
    }
    
    public static String getTrimString(String oldstring,String newstring){
    	return getString(oldstring,newstring).trim();
    }
    
    public static String getTrimString(Object object,String newstring){
    	return getString(object,newstring).trim();
    }
    
    /**
     * 如果oldstring与comparestring相等，则将oldstring用newstring代替
     * @param oldstring
     * @param comparestring
     * @param newstring
     * @return String
     */
    public static String getString(String oldstring,String comparestring,String newstring) {
    	oldstring=getString(oldstring);
    	comparestring=getString(comparestring);
    	if(comparestring.equals("")){
        	oldstring = (oldstring.equals("")) ? newstring : oldstring;
            return oldstring;
    	}else{
    		oldstring=getString(oldstring);
    		if(oldstring.equals(comparestring)){
    			oldstring=newstring;
    			return oldstring;
    		}
    	}
    	return oldstring;
    }
    
    /**
     * 如果oldstring与comparestring相等，则将oldstring用newstring代替
     * @param oldObject
     * @param comparestring
     * @param newstring
     * @return String
     */
    public static String getString(Object oldObject,String comparestring,String newstring) {
    	oldObject=getString(oldObject);
    	comparestring=getString(comparestring);
    	
    	String theString="";
    	if(comparestring.equals("")){
    		theString = (oldObject.equals("")) ? newstring : String.valueOf(oldObject);
            return theString;
    	}else{
    		theString=getString(oldObject);
    		if(theString.equals(comparestring)){
    			theString=newstring;
    			return theString;
    		}
    	}
    	return theString;
    }

    /**
     * 取得倒转的String
     * @param string
     * @return String
     */
    public static String getConvertString(String string){
    	String convertstring="";
    	
    	if(string==null){
    		return null;
    	}
    	if(string.equals("")){
    		return "";
    	}
    	
    	char nowchar='\u0000';
    	int length=string.length();
    	for(int i=0;i<length;i++){
    		nowchar=string.charAt((length-1)-i);
    		convertstring+=nowchar;
    	}
    	
    	return convertstring;
    }
    
    /**
     * 处理int类型字符串
     * 
     * @param string
     * @return int
     */
    public static int getInt(String string) {
    	string = getString(string);
    	string = (string.equals("")) ? "0" : string;
        int thestr;
        try {
            thestr = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new BusinessException(e);
        }
        return thestr;
    }

    /**
     * 处理float类型字符串
     * 
     * @param string
     * @return float
     */
    public static float getFloat(String string) {
    	string = getString(string);
    	string = (string.equals("")) ? "0" : string;
        float thestr = 0;
        try {
            thestr = Float.parseFloat(string);
        } catch (NumberFormatException e) {
            throw new BusinessException(e);
        }
        return thestr;
    }

    /**
     * 处理double类型字符串
     * 
     * @param string
     * @return double
     */
    public static double getDouble(String string) {
    	string = getString(string);
    	string = (string.equals("")) ? "0" : string;
        double thestr = 0;
        try {
            thestr = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            throw new BusinessException(e);
        }
        return thestr;
    }

    /**
     * 处理long类型字符串
     * 
     * @param string
     * @return long
     */
    public static long getLong(String string) {
    	string = getString(string);
    	string = (string.equals("")) ? "0" : string;
        long thestr = 0;
        try {
            thestr = Long.parseLong(string);
        } catch (NumberFormatException e) {
            throw new BusinessException(e);
        }
        return thestr;
    }

    /**
     * 将字符串转为encoding的类型
     * @param string
     * @param encoding
     * @return String
     */
    public static String getEncodingString(String string,String encoding) {
    	try{
    		string = (string == null) ? "" : new String(string.getBytes("ISO-8859-1"), encoding);
    	}catch(UnsupportedEncodingException e){
            throw new BusinessException(e);
    	}
        return string;
    }
    
    /**
     * 将字符串由oldEncoding转为newEncoding的类型
     * @param string
     * @param oldEncoding
     * @param newEncoding
     * @return String
     */
    public static String getEncodingString(String string,String oldEncoding,String newEncoding) {
    	try{
    		string = (string == null) ? "" : new String(string.getBytes(oldEncoding), newEncoding);
    	}catch(UnsupportedEncodingException e){
            throw new BusinessException(e);
    	}
        return string;
    }
    
    /**
     * 将字符串转为GBK
     * @param string
     * @return String
     */
    public static String getGBKString(String string){
    	try{
    		string = (string == null) ? "" : new String(string.getBytes("ISO-8859-1"), "GBK");
    	}catch(UnsupportedEncodingException e){
            throw new BusinessException(e);
    	}
        return string;
    }
    
    /**
     * 将字符串转为ISO8859_1
     * @param string
     * @return String
     */
    public static String getISOString(String string){
    	try{
    		string = (string == null) ? "" : new String(string.getBytes("GBK"), "ISO-8859-1");
    	}catch(Exception e){
            throw new BusinessException(e);
    	}
        return string;
    }

    /**
     * 对UTF-8进行中文解码
     * @param string
     * @return String
     * @throws IOException
     */
    public static String getStringFromUtf8(String string){
        try {
        	string=URLDecoder.decode(string,"utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(e);
        }
        return string;
    }
    
    /**
     * 对中文进行UTF-8编码
     * @param string
     * @return String
     */
    public static String getUtf8String(String string){
        try {
        	string=URLEncoder.encode(string, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(e);
        }
        return string;
    }

    /**
     * 将数据库中取出的字符串在页面上按原来的格式输出
     * 
     * @param string
     * @return String
     */
    public static String getHTMLFormatString(String string) {
    	string = getString(string);
        String replacement1 = "<br>";
        String replacement2 = "&nbsp;";
        String replacement3 = "&lt;";
        String replacement4 = "&gt;";
        String replacement5="’";
        String replacement6="“";
        
        string = string.replaceAll("\r\n", replacement1);
        string = string.replaceAll(" ", replacement2);
        string = string.replaceAll("<", replacement3);
        string = string.replaceAll(">", replacement4);
        string = string.replaceAll("'", replacement5);
        string = string.replaceAll("\"", replacement6);
        return string;
    }
    
    /**
     * 将数据库中取出的字符串在页面上按原来的格式输出
     * 
     * @param string
     * @return String
     */
    public static String getFilterHtmlString(String string) {
    	string = getString(string);
        string = string.replaceAll("<", "&lt;");
        string = string.replaceAll(">", "&gt;");
        
        return string;
    }
    
    /**
     * 替换不能写入数据库的字符
     * @param string
     * @return String
     */
    public static String getDatabaseFormatString(String string){
    	string = getString(string);
    	String replacement1="\"";
    	string = string.replaceAll("'", replacement1);
    	return string;
    }

    /**
     * 截取在字符 begin 到 end 之间的字符串，将这些字符串保存在ArrayList中并返回一个 ArrayList 对象
     * 
     * @param begin 只能是单个字符
     * @param end 只能是单个字符
     * @param longstring
     * @return List
     */
    public static List getInterString(String begin, String end,String longstring) {

    	longstring = (longstring == null) ? "" : longstring;
        int beginnum = 0;
        int endnum = 0;
        int strlength = 0;
        List stringlist = new ArrayList();
        String str = "";
        String temp = "";
        String beginstr = "", endstr = "";

        for (strlength = 0; strlength < longstring.length(); strlength++) {
            temp = longstring.substring(strlength, strlength + 1);
            if ((temp.equals(begin))&&(!beginstr.equals(begin))) {
                beginnum = strlength;
                beginstr = begin;
            }else if ((temp.equals(end))&&(beginstr.equals(begin))) {
                endnum = strlength;
                endstr = end;
            }

            while ((endstr.equals(end)) && (beginstr.equals(begin))) {
                str = longstring.substring(beginnum + 1, endnum);
                stringlist.add(str);
                beginnum = 0;
                endnum = 0;
                beginstr = "";
                endstr = "";
            }
        }

        return stringlist;
    }

    /**
     * 在字符串的固定位置插入新的字符串
     * @param oldstring
     * @param index
     * @param insertstring
     * @return String
     */
    public static String insert(String oldstring,String insertstring,int index){
    	String newstring="";
    	if(oldstring.length()<=index){
    		newstring=oldstring+insertstring;
    	}else{
    		String startstring=oldstring.substring(0,index);
    		String endstring=oldstring.substring(index);
    		newstring=startstring+insertstring+endstring;
    	}
    	return newstring;
    }
    
    /**
     * 删除所有begin和end之间的字符串,包括begin和end
     * @param longString
     * @param begin
     * @param end
     * @return String
     */
    public static String remove(String longString,String begin,String end) {
    	List contentList=getInterString(begin,end,longString);
		if((contentList!=null)&&(contentList.size()>0)) {
			int length=contentList.size();
			for(int i=0;i<length;i++) {
				try {
					String nowcontent=(String)contentList.get(i);
					longString=getReplaceString(longString,begin+nowcontent+end,"");
				}catch(Exception e) {
		            throw new BusinessException(e);
				}
			}
		}
    	return longString;
    }
    
    /**
     * 把字符串从一个位置开始删除一个固定长度的字符串
     * @param oldstring
     * @param startindex
     * @param length
     * @return String
     */
    public static String remove(String oldstring, int startindex, int length) {
		String newstring = "";
		if (oldstring.length() <= startindex) {
			return oldstring;
		} else {
			String startstring = oldstring.substring(0, startindex);
			String endstring = "";
			if (oldstring.length()-startindex <= length) {
				endstring = "";
				//oldstring.substring(startindex + 1);
			} else {
				endstring = oldstring.substring(startindex + length + 1);
			}
			newstring = startstring + endstring;
		}
		return newstring;
	}
    
    /**
	 * 把字符串thestring截取为按str分割的字符串ArrayList
	 * 
	 * @param shortstring shortString可以是由多个字符组成的字符串
	 * @param longstring
	 * @return ArrayList 如果失败返回null,如果logstring中不包含shortstring则返回整个longstring
	 */
    public static List getInterString(String shortstring, String longstring) {
    	shortstring = getString(shortstring,"");
        longstring = getString(longstring,"");
        boolean flag=false;
        
        if (longstring.equals(""))
            return null;

        String string = null;

        List arraylist = new ArrayList();

        String tempstring="";
        for (int j = 0; j < longstring.length(); j++) {
        	tempstring+=String.valueOf(longstring.charAt(j));
            if (!tempstring.equals(shortstring)) {
            	if(!shortstring.startsWith(tempstring)){
                	string=getString(string,"");
                    if(flag){
                    	string+=tempstring;
                    }else{
                    	string = string + String.valueOf(longstring.charAt(j));
                    }
                    flag=false;
                    tempstring="";
            	}else{
            		flag=true;
            	}
            } else if (tempstring.equals(shortstring)) {
                if (string!=null) {
                    arraylist.add(string);
                }
                string = null;
                tempstring="";
            }
        }
        if (string != null) {
            arraylist.add(string);
        }
        string = null;
        return (arraylist);
    }
    
    /**
     * 把字符串longString截取为按splitString分割的字符串List
     * @param longString
     * @param splitString
     * @return List
     */
    public static List getSpiltStringList(String longString,String splitString) {
    	List list=new ArrayList();
    	longString = getString(longString,"");
    	splitString = getString(splitString,"");
    	if(longString.equals("")){
    		return null;
    	}
    	String[] splitArray=longString.split(splitString);
    	if(splitArray==null){
    		return null;
    	}
    	int length=splitArray.length;
    	for(int i=0;i<length;i++){
    		list.add(splitArray[i]);
    	}
    	return list;
    }

    /**
     * 取得longstring中从最后一个str开始到longstring结束的字符串
     * 
     * @param longstring
     * @param shortstring
     * @return String  如果longstring不包含shortstring没有则返回""
     */
    public static String getLastString(String longstring, String shortstring) {
        int i = longstring.indexOf(shortstring);
        if (i > -1)
            return (longstring.substring((longstring.lastIndexOf(shortstring)) + 1,
                    longstring.length()));
        else
            return "";
    }

    /**
     * 取得longstring中从开始到最后一个str字符串
     * 
     * @param longstring
     * @param shortstring
     * @return String 如果longstring不包含shortstring则返回longstring
     */
    public static String getPreString(String longstring, String shortstring) {
        int i = 0;
        try{
        	i = longstring.indexOf(shortstring);
        }catch(Exception e){
        	return (longstring);
        }
        if (i > -1) {
        	String newstring="";
        	try {
        		newstring=longstring.substring(0, longstring.lastIndexOf(shortstring));
        	}catch(Exception e) {
        		return longstring;
        	}
        	return newstring;
        }else {
        	return longstring;
        }
    }

    /**
     * 取得longstring中从开始到第一个str字符串
     * 
     * @param longstring
     * @param shortString shortString可以是由多个字符组成的字符串
     * @return String 如果longstring不包含shortstring则返回longstring
     */
    public static String getFirstInterString(String longstring,String shortString){
    	List arraylist=getInterString(shortString,longstring);
    	String string=null;
    	if((arraylist!=null)&&(!arraylist.isEmpty())){
    		string=(String)arraylist.get(0);
    	}
    	return string;
    }

    /**
     * 取得longstring中从第一个str字符串到结束
     * 
     * @param longstring
     * @param shortString shortString可以是由多个字符组成的字符串
     * @return String 如果longstring不包含shortstring则返回longstring
     */
    public static String getLastInterString(String longstring,String shortString){
    	String firstString=getFirstInterString(longstring,shortString)+shortString;
    	longstring=longstring.replaceFirst(firstString,"");
    	return longstring;
    }
    
    /**
     * 获取字符串前几位的字符
     * @param longstring
     * @param length
     * @return String
     */
    public static String getFirstString(String longstring,int length){
    	String shortstring="";
    	shortstring=longstring.substring(0,length);
    	return shortstring;
    }
    
    /**
     * 获取字符串最后的几位字符
     * @param longstring
     * @param length
     * @return String
     */
    public static String getLastString(String longstring,int length){
    	String shortstring="";
    	shortstring=longstring.substring(longstring.length()-length);
    	return shortstring;
    }
    
    /**
     * 将longstring中的所有oldstring替换成newstring
     * 
     * @param longstring
     * @param oldstring
     * @param newstring
     * @return String
     */
    public static String getReplaceString(String longstring, String oldstring,String newstring) {
        longstring = longstring.replaceAll(oldstring, newstring);
        return (longstring);
    }
    
    /**
     * 将longstring中的所有oldstring替换成newstring
     * @param longstring
     * @param replaceStringMap 新旧字符串表，key保存需要被替换的字符串，value保存将被替换成的字符串
     * @return String
     */
    public static String getReplaceString(String longstring, Map replaceStringMap) {
    	Object[][] objects=SCollectionTools.getMapKeyValue(replaceStringMap);
    	int objectslength=objects.length;
    	if(objectslength>0) {
    		for(int i=0;i<objectslength;i++) {
    			String oldString=(String)objects[i][0];
    			String newString=(String)objects[i][1];
    			longstring=getReplaceString(longstring,oldString,newString);
    		}
    	}
        return (longstring);
    }
    
    /**
     * 用新的字符串替换其中的一段字符
     * @param longstring
     * @param stringindex
     * @param endindex
     * @param shortstring
     * @return String
     */
    public static String getReplaceString(String longstring,int stringindex,int endindex,String shortstring){
    	String newstring="";
    	newstring+=getFirstString(longstring,stringindex);
    	newstring+=shortstring;
    	newstring+=getLastString(longstring,longstring.length()-endindex);
    	return newstring;
    }
    
    /**
     * 将longstring中的所有oldstring替换成newstring
     * 
     * @param longstring
     * @param oldstring
     * @param newstring
     * @return String
     */
    public static String getSpecialReplaceString(String longstring, String oldstring,String newstring) {
    	String string="";
		while(longstring.length()>0){
    	    int index=longstring.indexOf(oldstring);
    	    if(index>-1){
    			String tempstring=longstring.substring(0,index);
    			string+=tempstring;
        		string+=newstring;
        		if(longstring.length()>oldstring.length()){
        			longstring=longstring.substring(index+oldstring.length());
        		}else{
        			string+=longstring;
        			longstring="";
        		}
    		}else{
    			string+=longstring;
    			longstring="";
    		    break;
    	    }
        }
        return (string);
    }

    /**
     * 功能描述: 截取字符串中第几个，逗号或;分号后面的内容
     * @Param: longstring 原字符串
     * @Param: str 要按哪个字符串截取
     * @Param: length 第几个
     * @Author: senhuaF
     * @Date: 2019/8/14 13:10
     * @Version 1.0
     **/
    public static String getWhichPositionLaterStr(String longstring, String str, int length) {
        int index = 0;
        for (int i = 0;i<length;i++) {
            //获得第一个点的位置
            if (i == 0) {
                index = longstring.indexOf(str);
            } else {
                index=longstring.indexOf(str, index+1);
            }
        }
        //获取第几个位置后的字符串信息。得到结果 result
        String result=longstring.substring(index+1);
        return  result;
    }

    /**
     * 功能描述: 截取字符串中第几个，逗号或;分号前面的内容
     * @Param: longstring 原字符串
     * @Param: str 要按哪个字符串截取
     * @Param: length 第几个
     * @Author: senhuaF
     * @Date: 2019/8/14 13:10
     * @Version 1.0
     **/
    public static String getWhichPositionBeforeStr(String longstring, String str, int length) {
        int index = 0;
        for (int i = 0;i<length;i++) {
            //获得第一个点的位置
            if (i == 0) {
                index = longstring.indexOf(str);
            } else {
                index=longstring.indexOf(str, index+1);
            }
        }
        //获取第几个位置前的字符串信息。得到结果 result
        String result=longstring.substring(0,index);
        return  result;
    }

    /**
     * 判断字符串中是否包含有指定的单词
     * 
     * @param longString
     *            将要被检查的字符串
     * @param shortString
     *            单词
     * @return boolean
     */
    public static boolean isWordExist(String longString, String shortString) {
        StringTokenizer tokenizer = new StringTokenizer(longString);
        while (tokenizer.hasMoreTokens()) {
            String tempString = tokenizer.nextToken();
            if (shortString.equals(tempString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回一个字符串中包含的单词列表
     * 
     * @param string
     * @return ArrayList
     */
    public static List getWordList(String string) {
        StringTokenizer tokenizer = new StringTokenizer(string);
        List list = new ArrayList();

        while (tokenizer.hasMoreTokens()) {
            String tempString = tokenizer.nextToken();
            list.add(tempString);
        }
        return list;
    }
    
    /**
     * 前一个句子是否包含后一个句子
     * @param longString
     * @param shortString
     * @return int
     */
    public static int indexOf(String longString,String shortString){
    	List longStringList=getWordList(longString);
    	StringBuffer longWordString=new StringBuffer();
    	if((longStringList!=null)&&(longStringList.size()>0)){
    		int length=longStringList.size();
    		for(int i=0;i<length;i++) {
    			longWordString.append((String)longStringList.get(i)+" ");
    		}
    	}
    	List shortStringList=getWordList(shortString);
    	StringBuffer shortWordString=new StringBuffer();
    	if((shortStringList!=null)&&(shortStringList.size()>0)){
    		int length=shortStringList.size();
    		for(int i=0;i<length;i++) {
    			shortWordString.append((String)shortStringList.get(i)+" ");
    		}
    	}
        String tempLongString=longWordString.toString().trim();
        String tempShortString=shortWordString.toString().trim();
        int indexOf=tempLongString.indexOf(tempShortString);
        return indexOf;
    }
    
    /**
     * 从第几位开始等于比较的字符串
     * @param longString
     * @param startindex 从0开始
     * @param shortString
     * @return int
     */
    public static int indexOf(String longString,int startindex,String shortString){
    	if(startindex+1>longString.length()){
    		return -1;
    	}
    	
    	if(shortString.length()>(longString.length()-(startindex+1))){
    		return -1;
    	}
    	String tempstring=longString.substring(startindex,shortString.length());
    	if(tempstring.equals(shortString)){
    		return startindex;
    	}else{
    		return -1;
    	}
    }
    /**
     * 返回字符串转为数组后经过过滤的数组
     * @param longString 
     * @param filter 转换分割符
     * @param replaceString 需要被过滤的字符
     * @return ArrayList
     */
    public static List getFilterArrayString(String longString,String filter,String replaceString){
    	ArrayList resultStrings=new ArrayList();
    	String[] strings=longString.split(filter);
    	for(int i=0;i<strings.length;i++){
    		if(!strings[i].equals(replaceString)){
    			resultStrings.add(strings[i]);
    		}
    	}
    	return resultStrings;
    }

    /**
     * 是否含有中文
     * @param fileName
     * @return
     */
    public static boolean isContainChinese(String fileName) {
        String regex = "[\u4e00-\u9fa5]";
        if (SRegex.find(fileName, regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 按照指定长度对字符串左侧补0
     * @param oldStr
     * @param count
     * @return
     */
    public static String strPadZeroLeft(String oldStr, int count) {
        StringBuffer stringBuffer = new StringBuffer();
        if (isBlank(getTrimString(oldStr))) {
            return oldStr;
        }
        if (isNotBlank(getTrimString(oldStr)) && count > 0) {
            int length = getTrimString(oldStr).length();
            if (length < count) {
                for(int i = 0 ; i < count - length; i++) {
                    stringBuffer.append("0");
                }
            }
        }
        return stringBuffer.append(oldStr).toString();
    }

    /**
     * 校验密码格式，密码格式应该满足：
     * 1.密码长度8-18（公安要求）
     * 2.密码包含大写字母、小写字母和数字组合
     * 3.数字部分不能包含连续3位及以上相同或串联，如包含abc、DCB、321、aaa、222、123
     *
     * @param pwd
     * @return
     * 返回内容1：表示输入密码位空
     * 返回内容2：表示密码长度不在[8,18]之间
     * 返回内容3：表示密码不包含6个数字、大小写字母
     * 返回内容3个字符：表示连续的字符
     * 返回内容null：表示符合条件
     */
    public static String checkPwdFormat(String pwd) {
        if (pwd == null || "".equals(pwd)) {
            return "1";
        }
        if (pwd.trim().length() < 8 || pwd.trim().length() > 18) {
            return "2";
        }
        if (!isContainNumberLowUpWord(pwd, 6)) {
            return "3";
        }
        String result = null;
        String str = "";
        for (int i = 0; i < pwd.length() - 2; i++) {
            str = pwd.substring(i, (i + 3));
            if (isDifferOneFromThreeChar(pwd.substring(i, (i + 3)))) {
                result = str;
            }
        }
        return result;
    }

    /**
     * 校验3个字符之间均相差1或0
     *
     * @param str
     * @return
     */
    private static boolean isDifferOneFromThreeChar(String str) {
        if (str.length() != 3) {
            return false;
        }
        return (Integer.valueOf(Integer.toOctalString(str.charAt(1))) - Integer.valueOf(Integer.toOctalString(str.charAt(0))) == 1
                && Integer.valueOf(Integer.toOctalString(str.charAt(2))) - Integer.valueOf(Integer.toOctalString(str.charAt(1))) == 1)
                || (Integer.valueOf(Integer.toOctalString(str.charAt(1))) - Integer.valueOf(Integer.toOctalString(str.charAt(0))) == -1
                && Integer.valueOf(Integer.toOctalString(str.charAt(2))) - Integer.valueOf(Integer.toOctalString(str.charAt(1))) == -1)
                || (Integer.valueOf(Integer.toOctalString(str.charAt(1))) - Integer.valueOf(Integer.toOctalString(str.charAt(0))) == 0
                && Integer.valueOf(Integer.toOctalString(str.charAt(2))) - Integer.valueOf(Integer.toOctalString(str.charAt(1))) == 0);
    }

    /**
     * 判断str是否包含numberCount个数字、大小写字母
     * @param str
     * @param numberCount 应包含数字个数
     * @return
     */
    private static boolean isContainNumberLowUpWord(String str, int numberCount) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return str.matches(NUMBER_LOWERCASE_UPPERCASE_REGULAR) && getNumberCount(str) >= numberCount;
    }

    /**
     * 获取str包含数字的个数
     * @param str
     * @return
     */
    private static int getNumberCount(String str){
        int result = 0;
        for (int i = 0;i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(checkPwdFormat("788E5m80"));
    }

}
