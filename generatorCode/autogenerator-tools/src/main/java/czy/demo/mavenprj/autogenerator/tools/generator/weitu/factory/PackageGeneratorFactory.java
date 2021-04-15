package czy.demo.mavenprj.autogenerator.tools.generator.weitu.factory;

import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.GeneratorConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.base.PackageInfoVo;
import czy.demo.mavenprj.autogenerator.tools.util.SPackageUtils;

/**
 * 包名初始化工厂类
 */
public enum PackageGeneratorFactory {
    INSTANCE;

    public synchronized PackageInfoVo getPackageInfo(String projectPackageName, String module) {
        PackageInfoVo packageInfoVo = new PackageInfoVo();
        packageInfoVo.setCommosPackageName(SPackageUtils.getCommonsPackageName(projectPackageName));
        packageInfoVo.setControllerPackageName(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.CONTROLLER.getCode()));
        packageInfoVo.setBusiServicePackageName(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.BUSI_SERVICE.getCode()));
        packageInfoVo.setServicePackageName(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.SERVICE.getCode()));
        packageInfoVo.setDaoJavaPackageName(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.DAO_JAVA.getCode()));
        packageInfoVo.setMapperJavaPackageName(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.MAPPER_JAVA.getCode()));
        packageInfoVo.setPojoVoPackageName(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.POJO_VO.getCode()));
        packageInfoVo.setPojoBoPackageName(SPackageUtils.getPackageName(projectPackageName, module, GeneratorConstants.PackageEnum.POJO_BO.getCode()));
        return packageInfoVo;
    }
}
