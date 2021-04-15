package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config;

import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.base.BaseConfigInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.base.PackageInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.clazz.ClazzInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.form.FormInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.grid.GridInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.querycondition.QueryConditionInfoVo;

import java.io.Serializable;

/**
 * 代码配置信息
 * @author zhiyic
 * @version $Id: CodeConfigInfo.java, v 0.1 zhiyic Exp $
 */
public class CodeConfigInfoVo implements Serializable {
    
    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    /**
     *  类信息
     */
    private ClazzInfoVo clazzInfo;
    
    /**
     *  查询条件信息
     */
    private QueryConditionInfoVo queryConditionInfo;
    
    /**
     *  grid表格信息
     */
    private GridInfoVo gridInfo;
    
    /**
     * form表单信息 
     */
    private FormInfoVo formInfo;
    
    /**
     *  基础信息
     */
    private BaseConfigInfoVo baseConfigInfoVo;
    /**
     * 包名信息
     */
    private PackageInfoVo packageInfoVo;
    
    /**
     *  是否开启查询列表操作
     */
    private Boolean isOpeQuery;
    
    /**
     *  是否开启新增操作
     */
    private Boolean isOpeAdd;
    
    /**
     * 是否开启修改操作 
     */
    private Boolean isOpeUpdate;
    
    /**
     * 是否开启删除操作 
     */
    private Boolean isOpeDelete;
    
    /**
     *  是否开启查看详情操作
     */
    private Boolean isOpeDetail;

    public ClazzInfoVo getClazzInfo() {
        return clazzInfo;
    }

    public void setClazzInfo(ClazzInfoVo clazzInfo) {
        this.clazzInfo = clazzInfo;
    }

    public QueryConditionInfoVo getQueryConditionInfo() {
        return queryConditionInfo;
    }

    public void setQueryConditionInfo(QueryConditionInfoVo queryConditionInfo) {
        this.queryConditionInfo = queryConditionInfo;
    }

    public GridInfoVo getGridInfo() {
        return gridInfo;
    }

    public void setGridInfo(GridInfoVo gridInfo) {
        this.gridInfo = gridInfo;
    }

    public FormInfoVo getFormInfo() {
        return formInfo;
    }

    public void setFormInfo(FormInfoVo formInfo) {
        this.formInfo = formInfo;
    }

    public Boolean getIsOpeAdd() {
        return isOpeAdd;
    }

    public void setIsOpeAdd(Boolean isOpeAdd) {
        this.isOpeAdd = isOpeAdd;
    }

    public Boolean getIsOpeUpdate() {
        return isOpeUpdate;
    }

    public void setIsOpeUpdate(Boolean isOpeUpdate) {
        this.isOpeUpdate = isOpeUpdate;
    }

    public Boolean getIsOpeDelete() {
        return isOpeDelete;
    }

    public void setIsOpeDelete(Boolean isOpeDelete) {
        this.isOpeDelete = isOpeDelete;
    }

    public Boolean getIsOpeDetail() {
        return isOpeDetail;
    }

    public void setIsOpeDetail(Boolean isOpeDetail) {
        this.isOpeDetail = isOpeDetail;
    }

    public Boolean getIsOpeQuery() {
        return isOpeQuery;
    }

    public void setIsOpeQuery(Boolean isOpeQuery) {
        this.isOpeQuery = isOpeQuery;
    }

    public BaseConfigInfoVo getBaseConfigInfoVo() {
        return baseConfigInfoVo;
    }

    public void setBaseConfigInfoVo(BaseConfigInfoVo baseConfigInfoVo) {
        this.baseConfigInfoVo = baseConfigInfoVo;
    }

    public PackageInfoVo getPackageInfoVo() {
        return packageInfoVo;
    }

    public void setPackageInfoVo(PackageInfoVo packageInfoVo) {
        this.packageInfoVo = packageInfoVo;
    }
}
