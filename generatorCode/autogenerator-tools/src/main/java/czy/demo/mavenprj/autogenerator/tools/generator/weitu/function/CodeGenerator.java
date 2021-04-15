package czy.demo.mavenprj.autogenerator.tools.generator.weitu.function;

import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.CodeConfigInfoVo;
import czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config.GenaratorBaseConfigVo;
import freemarker.template.Configuration;

/**
 * 自动生成代码公共方法接口
 * @author zhiyic
 * @version $Id: GeneratorCommonInterface.java, v 0.1 zhiyic Exp $
 */
public interface CodeGenerator {
    
    /**
     * 生成代码
     * @author zhiyic
     * @param baseConfigVo
     * @param codeConfigInfo
     * @param configuration
     */
    void create(GenaratorBaseConfigVo baseConfigVo, CodeConfigInfoVo codeConfigInfo, Configuration configuration) throws Exception;
}
