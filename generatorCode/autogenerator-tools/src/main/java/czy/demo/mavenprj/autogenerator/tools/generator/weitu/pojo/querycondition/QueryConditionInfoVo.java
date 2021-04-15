package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.querycondition;

import java.io.Serializable;
import java.util.List;

/**
 * 查询条件参数
 * @author zhiyic
 * @version $Id: QueryConditionInfo.java, v 0.1 zhiyic Exp $
 */
public class QueryConditionInfoVo implements Serializable {
    
    /**
     *  
     */
    private static final long serialVersionUID = 1L;
    
    /**
     *  查询字段列表
     */
    private List<QueryFieldInfoVo> queryFieldList;

    public List<QueryFieldInfoVo> getQueryFieldList() {
        return queryFieldList;
    }

    public void setQueryFieldList(List<QueryFieldInfoVo> queryFieldList) {
        this.queryFieldList = queryFieldList;
    }
    

}
