package czy.demo.mavenprj.autogenerator.tools.generator.weitu.function;

import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.GeneratorConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.clazz.ClazzInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.CodeConfigInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.GenaratorBaseConfigVo;
import czy.demo.mavenprj.autogenerator.tools.util.SPathUtils;
import czy.demo.mavenprj.autogenerator.tools.util.SString;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Dao代码生成类
 * @author zhiyic
 * @version $Id: SqlDaoGenerator.java, v 0.1 zhiyic Exp $
 */
public enum SqlDaoGenerator implements CodeGenerator {
    INSTANCE;

    @Override
    public void create(GenaratorBaseConfigVo baseConfigVo, CodeConfigInfoVo codeConfigInfo, Configuration configuration) throws Exception {
        ClazzInfoVo clazzInfo = codeConfigInfo.getClazzInfo();
        //设置数据并执行
        Map<String, Object> map = new HashMap<>();
        map.put("codeConfigInfo", codeConfigInfo);
        //路径地址转换
        String sqlDaoSavePath;
        String interfaceDaoSavePath;
        if (SString.isBlank(SString.getTrimString(baseConfigVo.getProjectPath()))) {
            sqlDaoSavePath = GeneratorConstants.CreateFileConstants.CREATE_FILE_DEFAULT_PATH;
            interfaceDaoSavePath = GeneratorConstants.CreateFileConstants.CREATE_FILE_DEFAULT_PATH;
        } else {
            sqlDaoSavePath = SPathUtils.getCompleteResourcesFilePath(baseConfigVo.getProjectPath())
                            + GeneratorConstants.CreateFileConstants.SQL_DAO_FILE_PATH;
            interfaceDaoSavePath = SPathUtils.getCompleteJavaFilePath(baseConfigVo.getProjectPath(), baseConfigVo.getProjectPackageName(), baseConfigVo.getModule())
                    + GeneratorConstants.CreateFileConstants.DAO_JAVA_FILE_PATH;
        }


        //生成sql_dao.xml
        Writer sqlDaoWriter = new OutputStreamWriter(new FileOutputStream(sqlDaoSavePath + clazzInfo.getClassName()
                + GeneratorConstants.CreateFileConstants.CREATE_FILE_NAME_SQL_DAO_SUFFIX + GeneratorConstants.CreateFileConstants.CREATE_FILE_TYPE_XML));
        //获取模板
        Template sqlDaoTemplate = configuration.getTemplate(GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_DAO_PATH_FILE_NAME + "/"
                + GeneratorConstants.FreemarkerConstants.TEMPLATE_DAO_SQL_DAO_FILE_NAME + GeneratorConstants.FreemarkerConstants.FREEMARKER_TEMPLATE_FILE_TYPE);
        sqlDaoTemplate.process(map, sqlDaoWriter);

        //生成dao接口
        Writer interfaceDaoWriter = new OutputStreamWriter(new FileOutputStream(interfaceDaoSavePath + clazzInfo.getClassName()
                + GeneratorConstants.CreateFileConstants.CREATE_FILE_NAME_INTERFACE_DAO_SUFFIX + GeneratorConstants.CreateFileConstants.CREATE_FILE_TYPE_JAVA));
        //获取模板
        Template interfaceDaoTemplate = configuration.getTemplate(GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_DAO_PATH_FILE_NAME + "/"
                + GeneratorConstants.FreemarkerConstants.TEMPLATE_DAO_INTERFACE_DAO_FILE_NAME + GeneratorConstants.FreemarkerConstants.FREEMARKER_TEMPLATE_FILE_TYPE);
        interfaceDaoTemplate.process(map, interfaceDaoWriter);
        
        System.out.println("----- Generator SQL Dao SUCCESS -------");

    }

}
