package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.form;

import java.io.Serializable;
import java.util.List;

/**
 * 表单信息
 * @author zhiyic
 * @version $Id: FormInfo.java, v 0.1 zhiyic Exp $
 */
public class FormInfoVo implements Serializable {
    
    /**
     *  
     */
    private static final long serialVersionUID = 1L;
    /**
     *  
     */
    public List<FormFieldInfoVo> formFieldList;

    public List<FormFieldInfoVo> getFormFieldList() {
        return formFieldList;
    }

    public void setFormFieldList(List<FormFieldInfoVo> formFieldList) {
        this.formFieldList = formFieldList;
    }
    
    
}
