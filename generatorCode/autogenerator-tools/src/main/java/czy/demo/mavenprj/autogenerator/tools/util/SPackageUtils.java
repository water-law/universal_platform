package czy.demo.mavenprj.autogenerator.tools.util;


import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.CommonConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.GeneratorConstants;

public class SPackageUtils {
    private SPackageUtils() {

    }

    /**
     *  获取包名
     * @param projectPackageName 项目包名称
     * @param module    模块名称
     * @param typePackageName {@link GeneratorConstants.PackageEnum} 包类型
     * @return
     */
    public static String getPackageName(String projectPackageName, String module, String typePackageName) {
        if (SString.isNotBlank(SString.getTrimString(projectPackageName))
            && SString.isNotBlank(SString.getString(typePackageName))) {
            if (SString.isNotBlank(SString.getTrimString(module))) {
                return projectPackageName + CommonConstants.Symbol.POINT + module +  CommonConstants.Symbol.POINT + typePackageName;
            } else {
                return projectPackageName + CommonConstants.Symbol.POINT + typePackageName;
            }
        }
        return "";
    }

    /**
     * 获取公共包名
     * @param projectPackageName
     * @return
     */
    public static String getCommonsPackageName(String projectPackageName) {
        if (SString.isNotBlank(SString.getString(projectPackageName))) {
            return projectPackageName + CommonConstants.Symbol.POINT + GeneratorConstants.PackageEnum.COMMONS.getCode();
        }
        return "";
    }

    public static void main(String[] args) {
        String projectPackageName = "com.weitu.mpsplatform";
        String module = "support";
        System.out.println(SPackageUtils.getCommonsPackageName(projectPackageName));
        System.out.println(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.POJO_VO.getCode()));
        System.out.println(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.POJO_BO.getCode()));
        System.out.println(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.CONTROLLER.getCode()));
        System.out.println(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.BUSI_SERVICE.getCode()));
        System.out.println(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.SERVICE.getCode()));
        System.out.println(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.DAO_JAVA.getCode()));
        System.out.println(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.MAPPER_JAVA.getCode()));

    }
}
