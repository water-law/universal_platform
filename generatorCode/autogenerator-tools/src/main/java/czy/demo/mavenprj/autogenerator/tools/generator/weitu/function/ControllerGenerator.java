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
 * Controller代码生成类
 * @author zhiyic
 * @version $Id: ControllerGenerator.java, v 0.1 zhiyic Exp $
 */
public enum ControllerGenerator implements CodeGenerator {
    INSTANCE;

    @Override
    public void create(GenaratorBaseConfigVo baseConfigVo, CodeConfigInfoVo codeConfigInfo, Configuration configuration) throws Exception {
        ClazzInfoVo clazzInfo = codeConfigInfo.getClazzInfo();
        //设置数据并执行
        Map<String, Object> map = new HashMap<>();
        map.put("codeConfigInfo", codeConfigInfo);
        //路径地址转换
        String savePath;
        if (SString.isBlank(SString.getTrimString(baseConfigVo.getProjectPath()))) {
            savePath = GeneratorConstants.CreateFileConstants.CREATE_FILE_DEFAULT_PATH;
        } else {
            savePath = SPathUtils.getCompleteJavaFilePath(baseConfigVo.getProjectPath(), baseConfigVo.getProjectPackageName(), baseConfigVo.getModule())
                        + GeneratorConstants.CreateFileConstants.CONTROLLER_FILE_PATH;
        }

        Writer controllerWriter = new OutputStreamWriter(new FileOutputStream(savePath + clazzInfo.getClassName()
                            + GeneratorConstants.CreateFileConstants.CREATE_FILE_NAME_CONTROLLER_SUFFIX + GeneratorConstants.CreateFileConstants.CREATE_FILE_TYPE_JAVA));
        //获取模板
        Template controllerTemplate = configuration.getTemplate(
            GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_CONTROLLER_PATH_FILE_NAME + "/"
            + GeneratorConstants.FreemarkerConstants.TEMPLATE_CONTROLLER_FILE_NAME + GeneratorConstants.FreemarkerConstants.FREEMARKER_TEMPLATE_FILE_TYPE);
        controllerTemplate.process(map, controllerWriter);
        System.out.println("----- Generator Controller SUCCESS -------");

    }

}
