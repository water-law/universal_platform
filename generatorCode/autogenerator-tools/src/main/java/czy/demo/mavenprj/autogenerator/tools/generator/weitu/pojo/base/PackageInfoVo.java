package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.base;

import java.io.Serializable;

/**
 * 包名信息
 */
public class PackageInfoVo implements Serializable {
    /**
     * 公共包名
     */
    private String commosPackageName;
    /**
     * controller包名
     */
    private String controllerPackageName;
    /**
     * busiservice包名
     */
    private String busiServicePackageName;
    /**
     * service包名
     */
    private String servicePackageName;
    /**
     * pojoVo包名
     */
    private String pojoVoPackageName;
    /**
     * pojoBo包名
     */
    private String pojoBoPackageName;
    /**
     * dao.java包名
     */
    private String daoJavaPackageName;
    /**
     * mapper.java包名
     */
    private String mapperJavaPackageName;

    public String getCommosPackageName() {
        return commosPackageName;
    }

    public void setCommosPackageName(String commosPackageName) {
        this.commosPackageName = commosPackageName;
    }

    public String getControllerPackageName() {
        return controllerPackageName;
    }

    public void setControllerPackageName(String controllerPackageName) {
        this.controllerPackageName = controllerPackageName;
    }

    public String getBusiServicePackageName() {
        return busiServicePackageName;
    }

    public void setBusiServicePackageName(String busiServicePackageName) {
        this.busiServicePackageName = busiServicePackageName;
    }

    public String getServicePackageName() {
        return servicePackageName;
    }

    public void setServicePackageName(String servicePackageName) {
        this.servicePackageName = servicePackageName;
    }

    public String getPojoVoPackageName() {
        return pojoVoPackageName;
    }

    public void setPojoVoPackageName(String pojoVoPackageName) {
        this.pojoVoPackageName = pojoVoPackageName;
    }

    public String getPojoBoPackageName() {
        return pojoBoPackageName;
    }

    public void setPojoBoPackageName(String pojoBoPackageName) {
        this.pojoBoPackageName = pojoBoPackageName;
    }

    public String getDaoJavaPackageName() {
        return daoJavaPackageName;
    }

    public void setDaoJavaPackageName(String daoJavaPackageName) {
        this.daoJavaPackageName = daoJavaPackageName;
    }

    public String getMapperJavaPackageName() {
        return mapperJavaPackageName;
    }

    public void setMapperJavaPackageName(String mapperJavaPackageName) {
        this.mapperJavaPackageName = mapperJavaPackageName;
    }
}
