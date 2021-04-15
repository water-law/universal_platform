package czy.demo.mavenprj.autogenerator.tools.util;

import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.CommonConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.GeneratorConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.ProjectConstants;

import java.io.File;

/**
 * 路径转换工具类
 */
public class SPathUtils {
    private SPathUtils() {

    }

    /**
     * 获取存放Java文件的完整地址
     * @param projectPath           项目存放地址
     * @param projectPackageName    项目包名
     * @param module                所属模块
     * @return
     */
    public static final String getCompleteJavaFilePath(String projectPath, String projectPackageName, String module) {
        return projectPath  + GeneratorConstants.CreateFileConstants.JAVA_FILE_ROOT_PATH + getProjectPackagePath(projectPackageName) + getModulePath(module);
    }

    /**
     * 获取存放resources文件的完整地址
     * @param projectPath           项目存放地址
     * @return
     */
    public static final String getCompleteResourcesFilePath(String projectPath) {
        return projectPath  + GeneratorConstants.CreateFileConstants.RESOURCES_FILE_ROOT_PATH;
    }

    /**
     * 获取项目包路径
     * @param projectPackageName 项目包名
     * @return
     */
    private static final String getProjectPackagePath(String projectPackageName) {
        if (SString.isNotBlank(SString.getString(projectPackageName))) {
            return projectPackageName.replace(CommonConstants.Symbol.POINT, File.separator) + File.separator;
        }
        return "";
    }

    private static final String getModulePath(String module) {
        if (SString.isNotBlank(SString.getTrimString(module))) {
            return module + File.separator;
        }
        return "";
    }

    public static void main(String[] args) {
        String projectPath = "F:\\01.devProgram\\M-sourceCode\\czytest";
        String domain = ProjectConstants.PROJECT_PACKAGE_NAME_MPSPALTFORM;
        String module = ProjectConstants.PROJECT_MODULE_BUSINESS;
        System.out.println(getCompleteJavaFilePath(projectPath, domain , module) + GeneratorConstants.CreateFileConstants.CONTROLLER_FILE_PATH);
        System.out.println(getCompleteJavaFilePath(projectPath, domain , module) + GeneratorConstants.CreateFileConstants.BUSI_SERVICE_FILE_PATH);
        System.out.println(getCompleteJavaFilePath(projectPath, domain , module) + GeneratorConstants.CreateFileConstants.SERVICE_FILE_PATH);
        System.out.println(getCompleteJavaFilePath(projectPath, domain , module) + GeneratorConstants.CreateFileConstants.DAO_JAVA_FILE_PATH);
        System.out.println(getCompleteJavaFilePath(projectPath, domain , module) + GeneratorConstants.CreateFileConstants.MAPPER_JAVA_FILE_PATH);
        System.out.println(getCompleteJavaFilePath(projectPath, domain , module) + GeneratorConstants.CreateFileConstants.POJO_VO_FILE_PATH);
        System.out.println(getCompleteJavaFilePath(projectPath, domain , module) + GeneratorConstants.CreateFileConstants.POJO_BO_FILE_PATH);
        System.out.println(getCompleteResourcesFilePath(projectPath) + GeneratorConstants.CreateFileConstants.SQL_MAPPER_FILE_PATH);
        System.out.println(getCompleteResourcesFilePath(projectPath) + GeneratorConstants.CreateFileConstants.SQL_DAO_FILE_PATH);
    }

}
