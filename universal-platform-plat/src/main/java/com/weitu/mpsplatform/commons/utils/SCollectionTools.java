package com.weitu.mpsplatform.commons.utils;

import java.util.*;

/**
 * 
 * 
 * @author senhuaF-31049
 * @version $Id: SCollectionTools.java, v 0.1 2016年9月19日 上午10:07:03 senhuaF-31049 Exp $
 */
public final class SCollectionTools {
	private SCollectionTools(){
		
	}
	
	public static List nullToEmpty(List list){
		if(list==null){
			list = new ArrayList();
		}
		return (ArrayList)list;
	}
	
	public static Map nullToEmpty(Map map){
		if(map==null){
			map = new HashMap();
		}
		return (HashMap)map;
	}
	
	public static HashSet nullToEmpty(Set set){
		if(set==null){
			set = new HashSet();
		}
		return (HashSet)set;
	}
	
	/**
	 * ArrayList转String[]
	 * @param arraylist 
	 * @return 如果arraylist==null或者arraylist.size()<1返回null
	 */
	public static String[] toStringArray(List arraylist){
		String[] array=null;
		if((arraylist!=null)&&(arraylist.size()>0)){
			int length=arraylist.size();
			array=new String[length];
			for(int i=0;i<length;i++){
				array[i]=(String)arraylist.get(i);
			}
		}
		return array;
	}
	
	/**
	 * ArrayList转Object[]
	 * @param arraylist
	 * @return 如果arraylist==null或者arraylist.size()<1返回null
	 */
	public static Object[] toObjectArray(List arraylist){
		Object[] array=null;
		if((arraylist!=null)&&(arraylist.size()>0)){
			int length=arraylist.size();
			array=new Object[length];
			for(int i=0;i<length;i++){
				array[i]=arraylist.get(i);
			}
		}
		return array;
	}
	
	/**
	 * Object[] 转 String[]
	 * @param objects
	 * @return String[]
	 */
	public static String[] toStringArray(Object[] objects){
		String[] array=null;
		if(objects==null){
			return null;
		}
		int length=objects.length;
		array=new String[length];
		for(int i=0;i<length;i++){
			array[i]=(String)objects[i];
		}
		return array;
	}
	
	/**
	 * String[] 转 ArrayList
	 * @param array
	 * @return 如果array==null或者array.size()<1返回null
	 */
	public static List<String> toList(String[] array){
		List arraylist=null;
		if(array!=null){
			int length=array.length;
			arraylist=new ArrayList();
			for(int i=0;i<length;i++){
				arraylist.add(array[i]);
			}
		}
		return arraylist;
	}
	
	/**
	 * Object[] 转 ArrayList
	 * @param array
	 * @return 如果array==null或者array.size()<1返回null
	 */
	public static List<Object> toList(Object[] array){
		List arraylist=null;
		if(array!=null){
			int length=array.length;
			arraylist=new ArrayList();
			for(int i=0;i<length;i++){
				arraylist.add(array[i]);
			}
		}
		return arraylist;
	}
	
	/**
	 * 将Map中的key和value保存到Object[][]中，数组的第一位保存key，第二位保存value
	 * @param map
	 * @return Object[][] if(hashtable==null) return null;
	 */
	public static Object[][] getMapKeyValue(Map map){
		Object[][] object=null;
		if ((map != null) && (!map.isEmpty())){
			int hashtableSize = map.size();
			object=new Object[hashtableSize][2];
			Iterator iterator = map.entrySet().iterator();
			for (int i = 0; i < hashtableSize; i++) {
				Map.Entry entry = (Map.Entry) iterator.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				object[i][0]=key;
				object[i][1]=value;
			}
		}
		return object;
	}
	
	public static Object[] getMapKeys(Map map){
		Object[] object=null;
		if ((map != null) && (!map.isEmpty())){
			int hashtableSize = map.size();
			object=new Object[hashtableSize][2];
			Iterator iterator = map.entrySet().iterator();
			for (int i = 0; i < hashtableSize; i++) {
				Map.Entry entry = (Map.Entry) iterator.next();
				Object key = entry.getKey();
				object[i]=key;
			}
		}
		return object;
	}
	
	public static Object[] getMapValues(Map map){
		Object[] object=null;
		if ((map != null) && (!map.isEmpty())){
			int hashtableSize = map.size();
			object=new Object[hashtableSize][2];
			Iterator iterator = map.entrySet().iterator();
			for (int i = 0; i < hashtableSize; i++) {
				Map.Entry entry = (Map.Entry) iterator.next();
				Object value = entry.getValue();
				object[i]=value;
			}
		}
		return object;
	}
	
	public static void arrayReverse(byte[] array) {
	    for (int i = 0; i <= array.length / 2 - 1; i++) {  
            byte temp1 = array[i];
            byte temp2 = array[array.length - i - 1];
            array[i] = temp2;
            array[array.length - i - 1] = temp1;
        }
	}
    
    public static void arrayReverse(String[] array) {
        for (int i = 0; i <= array.length / 2 - 1; i++) {  
            String temp1 = array[i];
            String temp2 = array[array.length - i - 1];
            array[i] = temp2;
            array[array.length - i - 1] = temp1;
        }
    }
    
    public static void arrayReverse(int[] array) {
        for (int i = 0; i <= array.length / 2 - 1; i++) {  
            int temp1 = array[i];
            int temp2 = array[array.length - i - 1];
            array[i] = temp2;
            array[array.length - i - 1] = temp1;
        }
    }
    
    public static void arrayReverse(long[] array) {
        for (int i = 0; i <= array.length / 2 - 1; i++) {  
            long temp1 = array[i];
            long temp2 = array[array.length - i - 1];
            array[i] = temp2;
            array[array.length - i - 1] = temp1;
        }
    }
    
    public static void arrayReverse(char[] array) {
        for (int i = 0; i <= array.length / 2 - 1; i++) {  
            char temp1 = array[i];
            char temp2 = array[array.length - i - 1];
            array[i] = temp2;
            array[array.length - i - 1] = temp1;
        }
    }
	
}
