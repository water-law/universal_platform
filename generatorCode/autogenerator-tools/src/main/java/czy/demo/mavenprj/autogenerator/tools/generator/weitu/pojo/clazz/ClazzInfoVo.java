package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.clazz;

import java.io.Serializable;
import java.util.List;

/**
 * 类信息
 * @author zhiyic
 * @version $Id: ClazzInfo.java, v 0.1 zhiyic Exp $
 */
public class ClazzInfoVo implements Serializable{
    
    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    /**
     *  类名
     */
    private String className;
    
    /**
     *  类名首字母小写
     */
    private String classNameFirstLowerCase;
    
    /**
     * 表名 
     */
    private String tableName;
    /**
     * 表注释
     */
    private String tableRemark;
    
    /**
     *  字段集合
     */
    private List<ClazzFieldInfoVo> fieldList;

    /**
     * 主键属性名
     */
    private String primaryKeyName;
    /**
     * 主键字段名
     */
    private String primaryKeyColumnName;
    /**
     * 主键字段类型
     */
    private String primaryKeyColumnType;

    /**
     * 主键字段名,首字母大写
     */
    private String primaryKeyNameFirstUpper;

    /**
     * 所属产品名称（英文，如果是子产品，则命名为产品名称.子产品名称）
     */
    private String moduleName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ClazzFieldInfoVo> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<ClazzFieldInfoVo> fieldList) {
        this.fieldList = fieldList;
    }

    public String getClassNameFirstLowerCase() {
        return classNameFirstLowerCase;
    }

    public void setClassNameFirstLowerCase(String classNameFirstLowerCase) {
        this.classNameFirstLowerCase = classNameFirstLowerCase;
    }

    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    public void setPrimaryKeyName(String primaryKeyName) {
        this.primaryKeyName = primaryKeyName;
    }

    public String getPrimaryKeyNameFirstUpper() {
        return primaryKeyNameFirstUpper;
    }

    public void setPrimaryKeyNameFirstUpper(String primaryKeyNameFirstUpper) {
        this.primaryKeyNameFirstUpper = primaryKeyNameFirstUpper;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTableRemark() {
        return tableRemark;
    }

    public void setTableRemark(String tableRemark) {
        this.tableRemark = tableRemark;
    }

    public String getPrimaryKeyColumnName() {
        return primaryKeyColumnName;
    }

    public void setPrimaryKeyColumnName(String primaryKeyColumnName) {
        this.primaryKeyColumnName = primaryKeyColumnName;
    }

    public String getPrimaryKeyColumnType() {
        return primaryKeyColumnType;
    }

    public void setPrimaryKeyColumnType(String primaryKeyColumnType) {
        this.primaryKeyColumnType = primaryKeyColumnType;
    }
}
