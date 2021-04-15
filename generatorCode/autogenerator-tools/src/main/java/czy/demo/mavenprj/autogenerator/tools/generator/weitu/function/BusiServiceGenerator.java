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
 * BusiService代码生成类
 * @author zhiyic
 * @version $Id: ServiceGenerator.java, v 0.1 zhiyic Exp $
 */
public enum BusiServiceGenerator implements CodeGenerator {
    INSTANCE;

    @Override
    public void create(GenaratorBaseConfigVo baseConfigVo, CodeConfigInfoVo codeConfigInfo, Configuration configuration) throws Exception {
        ClazzInfoVo clazzInfo = codeConfigInfo.getClazzInfo();
        //设置数据并执行
        Map<String, Object> map = new HashMap<>();
        map.put("codeConfigInfo", codeConfigInfo);

        //路径地址转换
        String savePath;
        String implSavePath;
        if (SString.isBlank(SString.getTrimString(baseConfigVo.getProjectPath()))) {
            savePath = GeneratorConstants.CreateFileConstants.CREATE_FILE_DEFAULT_PATH;
            implSavePath = GeneratorConstants.CreateFileConstants.CREATE_FILE_DEFAULT_PATH;
        } else {
            savePath = SPathUtils.getCompleteJavaFilePath(baseConfigVo.getProjectPath(), baseConfigVo.getProjectPackageName(), baseConfigVo.getModule())
                    + GeneratorConstants.CreateFileConstants.BUSI_SERVICE_FILE_PATH;
            implSavePath = savePath + "impl" + File.separator;
        }

        //生成busiservice.java
        Writer serviceWriter = new OutputStreamWriter(new FileOutputStream( savePath + "I" + clazzInfo.getClassName()
                            + GeneratorConstants.CreateFileConstants.CREATE_FILE_NAME_BUSI_SERVICE_SUFFIX + GeneratorConstants.CreateFileConstants.CREATE_FILE_TYPE_JAVA));
        Template serviceTemplate = configuration.getTemplate(GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_BUSI_SERVICE_PATH_FILE_NAME + "/"
                + GeneratorConstants.FreemarkerConstants.TEMPLATE_BUSI_SERVICE_FILE_NAME + GeneratorConstants.FreemarkerConstants.FREEMARKER_TEMPLATE_FILE_TYPE);
        serviceTemplate.process(map, serviceWriter);
        //生成serviceImpl.java
        Writer serviceImplWriter = new OutputStreamWriter(new FileOutputStream(implSavePath + clazzInfo.getClassName()
                            + GeneratorConstants.CreateFileConstants.CREATE_FILE_NAME_BUSI_SERVICEIMPL_SUFFIX + GeneratorConstants.CreateFileConstants.CREATE_FILE_TYPE_JAVA));
        //获取模板
        Template serviceImplTemplate = configuration.getTemplate(GeneratorConstants.FreemarkerConstants.DEFAULT_TEMPLATE_BUSI_SERVICE_PATH_FILE_NAME + "/"
                + GeneratorConstants.FreemarkerConstants.TEMPLATE_BUSI_SERVICE_IMPL_FILE_NAME + GeneratorConstants.FreemarkerConstants.FREEMARKER_TEMPLATE_FILE_TYPE);
        serviceImplTemplate.process(map, serviceImplWriter);
        System.out.println("----- Generator BusiService SUCCESS -------");

    }

}
