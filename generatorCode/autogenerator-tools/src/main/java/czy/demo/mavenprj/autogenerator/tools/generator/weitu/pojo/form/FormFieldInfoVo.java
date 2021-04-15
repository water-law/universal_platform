package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.form;

import java.io.Serializable;

/**
 * 表单展示字段
 * @author zhiyic
 * @version $Id: FormFieldInfo.java, v 0.1 zhiyic Exp $
 */
public class FormFieldInfoVo implements Serializable {
    

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
     *  字段数据类型（普通文本字段、下拉框、时间类型）
     */
    private String fieldInputType;
    
    /**
     * 是否必填 
     */
    private Boolean isRequired;

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

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }
    
    
}
