package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.querycondition;

import java.io.Serializable;

/**
 * 查询字段信息
 * @author zhiyic
 * @version $Id: QueryFieldInfo.java, v 0.1 zhiyic Exp $
 */
public class QueryFieldInfoVo implements Serializable {
    
    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    /**
     *  字段名称（英文）
     */
    private String fieldName;
    
    /**
     *  字段名称（中文）
     */
    private String fieldLabel;
    
    /**
     *  字段类型（文本框、下拉框等）
     */
    private String fieldInputType;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getFieldInputType() {
        return fieldInputType;
    }

    public void setFieldInputType(String fieldInputType) {
        this.fieldInputType = fieldInputType;
    }

}
