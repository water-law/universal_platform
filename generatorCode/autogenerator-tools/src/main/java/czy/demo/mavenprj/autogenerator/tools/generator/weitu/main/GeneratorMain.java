package czy.demo.mavenprj.autogenerator.tools.generator.weitu.main;


import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.GeneratorConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.ProjectConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.factory.CodeGeneratorFactory;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.factory.PackageGeneratorFactory;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.init.CodeConfigInit;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.CodeConfigInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.GenaratorBaseConfigVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.GeneratorTableConfigVo;
import freemarker.template.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorMain {
    
    public static void main(String[] args) throws Exception {

//        GenaratorBaseConfigVo baseConfigVo = new GenaratorBaseConfigVo("E:\\02.project\\W-sourceCode\\mpsplatform\\mps-platform-web",
//                ProjectConstants.PROJECT_PACKAGE_NAME_MPSPALTFORM,
//                ProjectConstants.PROJECT_MODULE_SUPPORT);
        GenaratorBaseConfigVo baseConfigVo = new GenaratorBaseConfigVo("E:\\Projects\\universal_platform\\test-web",
                ProjectConstants.PROJECT_PACKAGE_NAME_MOJ,
                null);
        //默认都为false，可选配
//        baseConfigVo.setCreateBusiServiceFlag(true);
//        baseConfigVo.setCreateControllerFlag(true);
//        baseConfigVo.setCreateDaoFlag(true);
//        baseConfigVo.setCreateMapperFlag(true);
//        baseConfigVo.setCreatePojoBoFlag(true);
        baseConfigVo.setCreatePojoVoFlag(true);
//        baseConfigVo.setCreateServiceFlag(true);
        List<GeneratorTableConfigVo> list = new ArrayList<>();
        //list.add(new GeneratorTableConfigVo("moj_data_third_trans_data_storage","thirdTransDataStorage", "chenzhiyi"));
        list.add(new GeneratorTableConfigVo("crs_device","Device", "chenzhiyi"));
        //list.add(new GeneratorTableConfigVo("moj_sys_statistics_chart_config","sysStatisticsChartConfig", "chenzhiyi"));
        for (GeneratorTableConfigVo tableConfig : list) {
            generatorCode(baseConfigVo, tableConfig);
        }
    }

    private static void generatorCode (GenaratorBaseConfigVo baseConfigVo, GeneratorTableConfigVo tableConfig) throws Exception {
        System.out.println("=====AUTO GENERATOR CODE START========");
        //创建Configuration对象
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //设置模板所在目录
        String path = GeneratorMain.class.getClassLoader().getResource(GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_ROOT_PATH_FILE_NAME).getPath();
        configuration.setDirectoryForTemplateLoading(new File(path));

        CodeConfigInit.init(GeneratorConstants.PersistentConstants.DEFAULT_DB_URL,
                GeneratorConstants.PersistentConstants.DEFAULT_DB_USER,
                GeneratorConstants.PersistentConstants.DEFAULT_DB_PASSWORD);

        CodeConfigInfoVo codeConfigInfo = CodeConfigInit.generateCodeConfig(tableConfig.getTableName(), tableConfig.getAliasName(), tableConfig.getAuthor());
        codeConfigInfo.setPackageInfoVo(PackageGeneratorFactory.INSTANCE.getPackageInfo(baseConfigVo.getProjectPackageName(), baseConfigVo.getModule()));
        if (baseConfigVo.getCreatePojoBoFlag()) {
            //创建POJO BO文件
            CodeGeneratorFactory.INSTANCE.getPOJOBoGenarator().create(baseConfigVo, codeConfigInfo, configuration);
        }
        if (baseConfigVo.getCreatePojoVoFlag()) {
            //创建POJO VO文件
            CodeGeneratorFactory.INSTANCE.getPOJOVoGenarator().create(baseConfigVo, codeConfigInfo, configuration);
        }
        if (baseConfigVo.getCreateControllerFlag()) {
            //创建controller文件
            CodeGeneratorFactory.INSTANCE.getControllerGenarator().create(baseConfigVo, codeConfigInfo, configuration);
        }
        if (baseConfigVo.getCreateBusiServiceFlag()) {
            //创建busiservice文件
            CodeGeneratorFactory.INSTANCE.getBusiServiceGenarator().create(baseConfigVo, codeConfigInfo, configuration);
        }
        if (baseConfigVo.getCreateServiceFlag()) {
            //创建service文件
            CodeGeneratorFactory.INSTANCE.getServiceGenarator().create(baseConfigVo, codeConfigInfo, configuration);
        }
        if (baseConfigVo.getCreateDaoFlag()) {
            //创建dao文件
            CodeGeneratorFactory.INSTANCE.getSqlDaoGenarator().create(baseConfigVo, codeConfigInfo, configuration);
        }
        if (baseConfigVo.getCreateMapperFlag()) {
            //创建dao文件
            CodeGeneratorFactory.INSTANCE.getSqlMapperGenarator().create(baseConfigVo, codeConfigInfo, configuration);
        }
        System.out.println("=====AUTO GENERATOR CODE END========");
    }
    
}
