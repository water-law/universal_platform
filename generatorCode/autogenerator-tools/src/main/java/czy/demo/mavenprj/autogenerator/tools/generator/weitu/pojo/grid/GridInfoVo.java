package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.grid;

import java.io.Serializable;
import java.util.List;

/**
 * grid表单信息
 * @author zhiyic
 * @version $Id: GridInfo.java, v 0.1 zhiyic Exp $
 */
public class GridInfoVo implements Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;
    
    List<GridFieldInfoVo> gridFieldList;

    public List<GridFieldInfoVo> getGridFieldList() {
        return gridFieldList;
    }

    public void setGridFieldList(List<GridFieldInfoVo> gridFieldList) {
        this.gridFieldList = gridFieldList;
    }
    
}
