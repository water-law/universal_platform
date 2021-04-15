package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.clazz;

/**
 * 类属性字段信息
 * @author zhiyic
 * @version $Id: Field.java, v 0.1 zhiyic Exp $
 */
public class ClazzFieldInfoVo {
    
    /**
     * 字段名 
     */
    private String fieldName;
    /**
     *  字段类型
     */
    private String fieldType;
    /**
     *  字段注释
     */
    private String fieldRemarks;
    /**
     * 字段名首字母大写 
     */
    private String fieldNameUpperFirstLetter;
    
    /**
     *  数据库字段名称
     */
    private String fieldColumnName;
    
    /**
     *  数据库数据类型
     */
    private String fieldColumnType;
    
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getFieldType() {
        return fieldType;
    }
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }
    public String getFieldRemarks() {
        return fieldRemarks;
    }
    public void setFieldRemarks(String fieldRemarks) {
        this.fieldRemarks = fieldRemarks;
    }
    public String getFieldNameUpperFirstLetter() {
        return fieldNameUpperFirstLetter;
    }
    public void setFieldNameUpperFirstLetter(String fieldNameUpperFirstLetter) {
        this.fieldNameUpperFirstLetter = fieldNameUpperFirstLetter;
    }
    public String getFieldColumnName() {
        return fieldColumnName;
    }
    public void setFieldColumnName(String fieldColumnName) {
        this.fieldColumnName = fieldColumnName;
    }
    public String getFieldColumnType() {
        return fieldColumnType;
    }
    public void setFieldColumnType(String fieldColumnType) {
        this.fieldColumnType = fieldColumnType;
    }
    
    
}
