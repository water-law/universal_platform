package czy.demo.mavenprj.autogenerator.tools.util;


import java.util.StringTokenizer;


/**
 * 
 * @author zhiyic
 * @version $Id: SString.java, v 0.1 zhiyic Exp $
 */
public final class SString {
	private SString(){
		
	}
	
	public static boolean isBlank(String string){
	    if(string == null || string.equals("")){
	        return true;
	    }else{
	        return false;
	    }
	}
	
    public static boolean isNotBlank(String string){
        if(string != null && !string.equals("")){
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
     * 去除字符串空格、空白等
     * 
     * @param string
     * @return
     */
    public static String getAllTrimString(String string){
        string = getString(string);
        return string.replaceAll("\\s*", "");
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
     * 取得倒转的String
     * @param string
     * @return String
     */
    public static String getConvertString(String string){
    	String convertstring="";
    	
    	if(string==null){
    		return null;
    	}
    	if("".equals(string)){
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
     * 数据库字段转骆峰
     * 
     * @param colName
     * @return
     */
    public static String getFieldName(String colName) {
    	if ( colName.indexOf("_") <= 0 ) {
    		return colName;
    	}
		String handleColName = colName.trim();
		int colLenth = handleColName.length();
		char buf[] = new char[colLenth];
		int pos = 0;
		boolean isToUp = false;
		for (int i = 0; i < colLenth; i++) {
			char ch = handleColName.charAt(i);
			if (ch == '_') {
				isToUp = true;
			} else {
				if ((pos > 1) && isToUp) {
					buf[pos] = Character.toUpperCase(ch);
					pos++;
				} else {
					buf[pos] = Character.toLowerCase(ch);
					pos++;
				}
				isToUp = false;
			}
		}
		return new String(buf, 0, pos);

	}
    
    /**
     * 属性名首字母转大写
     * 
     * @param fieldName
     * @return
     */
    public static String getFirstToUpper(String fieldName) {
    	if ( SString.isBlank(fieldName)) {
    		return fieldName;
    	}
    	byte[] items = fieldName.getBytes();
    	if ( items[0] >= 'a' && items[0] <= 'z' ) {
    		items[0] = (byte) ((char) items[0] - 'a' + 'A');
    	}
		return new String(items);
    }
    
    /**
     * 属性名首字母转小写
     * 
     * @param fieldName
     * @return
     */
    public static String getFirstToLowerCase(String fieldName) {
    	if ( SString.isBlank(fieldName)) {
    		return fieldName;
    	}
    	byte[] items = fieldName.getBytes();
    	if ( items[0] >= 'A' && items[0] <= 'Z' ) {
    		items[0] = (byte) ((char) items[0] - 'A' + 'a');
    	}
		return new String(items);
    }
    
    /**
     * 数据库字段类型转换成属性类型
     * @author zhiyic
     * @param columnType
     * @return
     */
    public static String columnTypeToFieldType(String columnType) {
        String fieldType = null;
        switch (columnType) {
            case "INT":
                fieldType = "Integer";
                break;
            case "TINYINT":
                fieldType = "Boolean";
                break;
            case "BIT":
                fieldType = "Boolean";
                break;
            case "SMALLINT":
                fieldType = "Integer";
                break;
            case "VARCHAR":
                fieldType = "String";
                break;
            case "CHAR":
                fieldType = "String";
                break;
            case "DATE":
                fieldType = "Date";
                break;
            case "DATETIME":
                fieldType = "Date";
                break;
            case "TIMESTAMP":
                fieldType = "Date";
                break;
            case "BIGINT":
                fieldType = "Long";
                break;
            case "DECIMAL":
                fieldType = "Double";
                break;
            case "DOUBLE":
                fieldType = "Double";
                break;
            default:
                fieldType = "String";
                break;
        }
        return fieldType;
    }

    /**
     * 表字典类型过滤
     * @param columnType
     * @return
     */
    public static String columnTypeFilter (String columnType) {
        String fileterColumnType;
        switch (columnType) {
            case "DATE":
                fileterColumnType = "TIMESTAMP";
                break;
            case "DATETIME":
                fileterColumnType = "TIMESTAMP";
                break;
            case "TIMESTAMP":
                fileterColumnType = "TIMESTAMP";
                break;
            case "INT":
                fileterColumnType = "INTEGER";
                break;
            case "TINYINT":
                fileterColumnType = "BIT";
                break;
            case "LONGTEXT":
                fileterColumnType = "LONGVARCHAR";
                break;
            default:
                fileterColumnType = columnType;
                break;
        }
        return fileterColumnType;
    }


}