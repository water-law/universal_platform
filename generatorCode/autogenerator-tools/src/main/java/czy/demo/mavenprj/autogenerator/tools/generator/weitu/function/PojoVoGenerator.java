package czy.demo.mavenprj.autogenerator.tools.generator.weitu.function;

import czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant.GeneratorConstants;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.clazz.ClazzInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.CodeConfigInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.GenaratorBaseConfigVo;
import czy.demo.mavenprj.autogenerator.tools.util.SPathUtils;
import czy.demo.mavenprj.autogenerator.tools.util.SString;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Pojo代码生成类
 * @author zhiyic
 * @version $Id: Pojo.java, v 0.1 zhiyic Exp $
 */
public enum PojoVoGenerator implements CodeGenerator {
    INSTANCE;

    @Override
    public void create(GenaratorBaseConfigVo baseConfigVo, CodeConfigInfoVo codeConfigInfo, Configuration configuration) throws Exception {
        //创建pojo文件
        ClazzInfoVo clazzInfo = codeConfigInfo.getClazzInfo();
        //生成VO对象
        //设置数据并执行
        Map<String, Object> map = new HashMap<>();
        map.put("codeConfigInfo", codeConfigInfo);

        //路径地址转换
        String voSavePath;
        if (SString.isBlank(SString.getTrimString(baseConfigVo.getProjectPath()))) {
            voSavePath = GeneratorConstants.CreateFileConstants.CREATE_FILE_DEFAULT_PATH;
        } else {
            voSavePath =  SPathUtils.getCompleteJavaFilePath(baseConfigVo.getProjectPath(), baseConfigVo.getProjectPackageName(), baseConfigVo.getModule())
                    + GeneratorConstants.CreateFileConstants.POJO_VO_FILE_PATH;
        }

        Writer pojoVoWriter = new OutputStreamWriter(new FileOutputStream(voSavePath + clazzInfo.getClassName()
                            + GeneratorConstants.CreateFileConstants.CREATE_FILE_NAME_POJO_VO_SUFFIX + GeneratorConstants.CreateFileConstants.CREATE_FILE_TYPE_JAVA));
        //获取模板
        Template pojoVoTemplate = configuration.getTemplate(
            GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_POJO_PATH_FILE_NAME + "/" 
            + GeneratorConstants.FreemarkerConstants.TEMPLATE_POJO_VO_FILE_NAME + GeneratorConstants.FreemarkerConstants.FREEMARKER_TEMPLATE_FILE_TYPE);
        pojoVoTemplate.process(map, pojoVoWriter);
        System.out.println("----- Generator POJO VO SUCCESS -------");

    }

}
