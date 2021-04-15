package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.grid;

import java.io.Serializable;

public class GridFieldInfoVo implements Serializable {

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
     *  字段数据类型（普通文本字段、标准代码下拉框、时间类型）
     */
    private String fieldDataType;

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

    public String getFieldDataType() {
        return fieldDataType;
    }

    public void setFieldDataType(String fieldDataType) {
        this.fieldDataType = fieldDataType;
    }

    
}
