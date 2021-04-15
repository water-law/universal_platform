package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config;

import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.ProjectConstants;

import java.io.Serializable;

/**
 * 生成代码基础配置
 */
public class GenaratorBaseConfigVo implements Serializable {

    /**
     * 项目地址
     */
    private String projectPath;

    /**
     * 项目包名
     */
    private String projectPackageName;
    /**
     * 项目模块， business / support
     */
    private String module = ProjectConstants.PROJECT_MODULE_BUSINESS;
    /**
     *是否生成controller
     */
    private Boolean createControllerFlag = false;
    /**
     *是否生成BusiService
     */
    private Boolean createBusiServiceFlag = false;
    /**
     *是否生成Service
     */
    private Boolean createServiceFlag = false;
    /**
     *是否生成Dao
     */
    private Boolean createDaoFlag = false;
    /**
     *是否生成 DAO - Mapper
     */
    private Boolean createMapperFlag = false;
    /**
     *是否生成Pojo-Bo对象
     */
    private Boolean createPojoBoFlag = false;

    /**
     * 是否生成POJO-Vo对象
     */
    private Boolean createPojoVoFlag = false;

    public GenaratorBaseConfigVo() {

    }

    public GenaratorBaseConfigVo(String projectPath) {
        this.projectPath = projectPath;
    }

    public GenaratorBaseConfigVo(String projectPath, String projectPackageName, String module) {
        this.projectPath = projectPath;
        this.projectPackageName = projectPackageName;
        this.module = module;
    }

    public GenaratorBaseConfigVo(String projectPath, String projectPackageName, String module, Boolean createControllerFlag, Boolean createBusiServiceFlag, Boolean createServiceFlag, Boolean createDaoFlag, Boolean createMapperFlag, Boolean createPojoBoFlag, Boolean createPojoVoFlag) {
        this.projectPath = projectPath;
        this.projectPackageName = projectPackageName;
        this.module = module;
        this.createControllerFlag = createControllerFlag;
        this.createBusiServiceFlag = createBusiServiceFlag;
        this.createServiceFlag = createServiceFlag;
        this.createDaoFlag = createDaoFlag;
        this.createMapperFlag = createMapperFlag;
        this.createPojoBoFlag = createPojoBoFlag;
        this.createPojoVoFlag = createPojoVoFlag;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public Boolean getCreateControllerFlag() {
        return createControllerFlag;
    }

    public void setCreateControllerFlag(Boolean createControllerFlag) {
        this.createControllerFlag = createControllerFlag;
    }

    public Boolean getCreateBusiServiceFlag() {
        return createBusiServiceFlag;
    }

    public void setCreateBusiServiceFlag(Boolean createBusiServiceFlag) {
        this.createBusiServiceFlag = createBusiServiceFlag;
    }

    public Boolean getCreateServiceFlag() {
        return createServiceFlag;
    }

    public void setCreateServiceFlag(Boolean createServiceFlag) {
        this.createServiceFlag = createServiceFlag;
    }

    public Boolean getCreateDaoFlag() {
        return createDaoFlag;
    }

    public void setCreateDaoFlag(Boolean createDaoFlag) {
        this.createDaoFlag = createDaoFlag;
    }

    public Boolean getCreatePojoBoFlag() {
        return createPojoBoFlag;
    }

    public void setCreatePojoBoFlag(Boolean createPojoBoFlag) {
        this.createPojoBoFlag = createPojoBoFlag;
    }

    public Boolean getCreatePojoVoFlag() {
        return createPojoVoFlag;
    }

    public void setCreatePojoVoFlag(Boolean createPojoVoFlag) {
        this.createPojoVoFlag = createPojoVoFlag;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Boolean getCreateMapperFlag() {
        return createMapperFlag;
    }

    public void setCreateMapperFlag(Boolean createMapperFlag) {
        this.createMapperFlag = createMapperFlag;
    }

    public String getProjectPackageName() {
        return projectPackageName;
    }

    public void setProjectPackageName(String projectPackageName) {
        this.projectPackageName = projectPackageName;
    }
}
