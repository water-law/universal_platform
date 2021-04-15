package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.base;

import java.io.Serializable;

/**
 * 基础配置信息
 * @author zhiyic
 * @version $Id: BaseConfigInfoVo.java, v 0.1 zhiyic Exp $
 */
public class BaseConfigInfoVo implements Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;
    
    /**
     *  作者姓名 
     */
    private String authorName;
    
    /**
     *  实体对象后缀
     */
    private String pojoSuffix;
    
    /**
     *  是否重名
     */
    private Boolean isDuplicateName;
    
    /**
     *  重名时，要添加的前缀标识
     */
    private String duplicateNamePrefix;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPojoSuffix() {
        return pojoSuffix;
    }

    public void setPojoSuffix(String pojoSuffix) {
        this.pojoSuffix = pojoSuffix;
    }

    public Boolean getIsDuplicateName() {
        return isDuplicateName;
    }

    public void setIsDuplicateName(Boolean isDuplicateName) {
        this.isDuplicateName = isDuplicateName;
    }

    public String getDuplicateNamePrefix() {
        return duplicateNamePrefix;
    }

    public void setDuplicateNamePrefix(String duplicateNamePrefix) {
        this.duplicateNamePrefix = duplicateNamePrefix;
    }
    

}
