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
 * @version $Id: SqlMapperGenerator.java, v 0.1 zhiyic Exp $
 */
public enum SqlMapperGenerator implements CodeGenerator {
    INSTANCE;

    @Override
    public void create(GenaratorBaseConfigVo baseConfigVo, CodeConfigInfoVo codeConfigInfo, Configuration configuration) throws Exception {
        ClazzInfoVo clazzInfo = codeConfigInfo.getClazzInfo();
        //设置数据并执行
        Map<String, Object> map = new HashMap<>();
        map.put("codeConfigInfo", codeConfigInfo);
        //路径地址转换
        String sqlMapperSavePath;
        String interfaceMapperSavePath;
        if (SString.isBlank(SString.getTrimString(baseConfigVo.getProjectPath()))) {
            sqlMapperSavePath = GeneratorConstants.CreateFileConstants.CREATE_FILE_DEFAULT_PATH;
            interfaceMapperSavePath = GeneratorConstants.CreateFileConstants.CREATE_FILE_DEFAULT_PATH;
        } else {
            sqlMapperSavePath = SPathUtils.getCompleteResourcesFilePath(baseConfigVo.getProjectPath())
                    + GeneratorConstants.CreateFileConstants.SQL_MAPPER_FILE_PATH;
            interfaceMapperSavePath = SPathUtils.getCompleteJavaFilePath(baseConfigVo.getProjectPath(), baseConfigVo.getProjectPackageName(), baseConfigVo.getModule())
                    + GeneratorConstants.CreateFileConstants.MAPPER_JAVA_FILE_PATH;
        }

        //生成sql_mapper.xml
        Writer sqlMapperWriter = new OutputStreamWriter(new FileOutputStream(sqlMapperSavePath + clazzInfo.getClassName()
                            + GeneratorConstants.CreateFileConstants.CREATE_FILE_NAME_SQL_MAPPER_SUFFIX + GeneratorConstants.CreateFileConstants.CREATE_FILE_TYPE_XML));
        //获取模板
        Template sqlMapperTemplate = configuration.getTemplate(GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_DAO_PATH_FILE_NAME + "/"
                + GeneratorConstants.FreemarkerConstants.TEMPLATE_DAO_SQL_MAPPER_FILE_NAME + GeneratorConstants.FreemarkerConstants.FREEMARKER_TEMPLATE_FILE_TYPE);
        sqlMapperTemplate.process(map, sqlMapperWriter);

        //生成mapper接口
        Writer interfaceMapperWriter = new OutputStreamWriter(new FileOutputStream(interfaceMapperSavePath + clazzInfo.getClassName()
                + GeneratorConstants.CreateFileConstants.CREATE_FILE_NAME_INTERFACE_MAPPER_SUFFIX + GeneratorConstants.CreateFileConstants.CREATE_FILE_TYPE_JAVA));
        //获取模板
        Template interfaceMapperTemplate = configuration.getTemplate(GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_DAO_PATH_FILE_NAME + "/"
                + GeneratorConstants.FreemarkerConstants.TEMPLATE_DAO_INTERFACE_MAPPER_FILE_NAME + GeneratorConstants.FreemarkerConstants.FREEMARKER_TEMPLATE_FILE_TYPE);
        interfaceMapperTemplate.process(map, interfaceMapperWriter);

        System.out.println("----- Generator SQL Mapper SUCCESS -------");

    }

}
