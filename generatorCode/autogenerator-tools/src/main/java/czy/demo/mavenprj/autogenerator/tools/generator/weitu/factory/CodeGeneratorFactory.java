package czy.demo.mavenprj.autogenerator.tools.generator.weitu.factory;


import czy.demo.mavenprj.autogenerator.tools.generator.weitu.function.*;

/**
 * 自动生成代码工厂类
 * @author zhiyic
 * @version $Id: GeneratorFactory.java, v 0.1 zhiyic Exp $
 */
public enum CodeGeneratorFactory {
    INSTANCE;
    
    /**
     * 返回POJO BO代码生成器对象
     * @author zhiyic
     * @return
     */
    public CodeGenerator getPOJOBoGenarator() {
        return PojoBoGenerator.INSTANCE;
    }


    /**
     * 返回POJO VO代码生成器对象
     * @author zhiyic
     * @return
     */
    public CodeGenerator getPOJOVoGenarator() {
        return PojoVoGenerator.INSTANCE;
    }
    
    /**
     * 返回Controller代码生成器对象
     * @author zhiyic
     * @return
     */
    public CodeGenerator getControllerGenarator() {
        return ControllerGenerator.INSTANCE;
    }

    /**
     * 返回BusiSerivce代码生成器对象
     * @author zhiyic
     * @return
     */
    public CodeGenerator getBusiServiceGenarator() {
        return BusiServiceGenerator.INSTANCE;
    }

    /**
     * 返回Serivce代码生成器对象
     * @author zhiyic
     * @return
     */
    public CodeGenerator getServiceGenarator() {
        return ServiceGenerator.INSTANCE;
    }

    /**
     * 返回Dao代码生成器对象
     * @author zhiyic
     * @return
     */
    public CodeGenerator getSqlDaoGenarator() {
        return SqlDaoGenerator.INSTANCE;
    }


    /**
     * 返回Dao代码生成器对象
     * @author zhiyic
     * @return
     */
    public CodeGenerator getSqlMapperGenarator() {
        return SqlMapperGenerator.INSTANCE;
    }


}
