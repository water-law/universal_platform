package czy.demo.mavenprj.autogenerator.tools.generator.weitu.constant;

import java.io.File;

/**
 * 自动生成代码常量类
 * @author zhiyic
 * @version $Id: GeneratorConstants.java, v 0.1 zhiyic Exp $
 */
public class GeneratorConstants {
    
    private GeneratorConstants() {
        
    }
    
    /**
     * 通用常量
     * @author zhiyic
     * @version $Id: GeneratorConstants.java, v 0.1 zhiyic Exp $
     */
    public static class CommonConstants {
        
        /**
         *  重名标识前缀
         */
        public static final String COMMON_DUPLICATE_NAME_PREFIX_CODE = "tempPrefix";
    }
    
    /**
     * freemarker相关常量
     * @author zhiyic
     * @version $Id: GeneratorConstants.java, v 0.1 zhiyic Exp $
     */
    public static class FreemarkerConstants {
        
        /**
         *  模板文件类型
         */
        public static final String FREEMARKER_TEMPLATE_FILE_TYPE = ".ftl";
        /**
         * 默认模板存放根目录名称：template
         */
        public static final String DEFAULT_TEMPLATE_ROOT_PATH_FILE_NAME = "template";
        /**
         *  默认pojo模板存放目录名称：pojo
         */
        public static final String DEFAULT_TEMPLATE_POJO_PATH_FILE_NAME = "weitu/pojo";
        /**
         *  默认controller模板存放目录名称：controller
         */
        public static final String DEFAULT_TEMPLATE_CONTROLLER_PATH_FILE_NAME = "weitu/controller";
        /**
         * 默认busiservice模板存放目录名称：busiservice
         */
        public static final String DEFAULT_TEMPLATE_BUSI_SERVICE_PATH_FILE_NAME = "weitu/busiservice";
        
        /**
         * 默认service模板存放目录名称：service
         */
        public static final String DEFAULT_TEMPLATE_SERVICE_PATH_FILE_NAME = "weitu/service";
        /**
         *  默认dao模板存放目录名称：dao
         */
        public static final String DEFAULT_TEMPLATE_DAO_PATH_FILE_NAME = "weitu/dao";

        /**
         *  POJO VO模板文件名称：pojoVotemplate
         */
        public static final String TEMPLATE_POJO_VO_FILE_NAME = "pojoVotemplate";

        /**
         *  POJO BO模板文件名称：pojoBotemplate
         */
        public static final String TEMPLATE_POJO_BO_FILE_NAME = "pojoBotemplate";
        /**
         *  CONTROLLER模板文件名称：controllertemplate
         */
        public static final String TEMPLATE_CONTROLLER_FILE_NAME = "controllertemplate";
        /**
         * BUSISERVICE模板文件名称：busiservicetemplate
         */
        public static final String TEMPLATE_BUSI_SERVICE_FILE_NAME = "busiservicetemplate";
        /**
         * BUSISERVICE_IMPL模板文件名称：busiserviceimpltemplate
         */
        public static final String TEMPLATE_BUSI_SERVICE_IMPL_FILE_NAME = "busiserviceimpltemplate";
        /**
         * SERVICE模板文件名称：servicetemplate
         */
        public static final String TEMPLATE_SERVICE_FILE_NAME = "servicetemplate";
        /**
         * SERVICE_IMPL模板文件名称：serviceimpltemplate
         */
        public static final String TEMPLATE_SERVICE_IMPL_FILE_NAME = "serviceimpltemplate";
        /**
         *  DAO_SQL_MAPPER模板文件名称：sql_mapper_template
         */
        public static final String TEMPLATE_DAO_SQL_MAPPER_FILE_NAME = "sql_mapper_template";
        /**
         *  DAO_SQL_DAO模板文件名称：sql_dao_template
         */
        public static final String TEMPLATE_DAO_SQL_DAO_FILE_NAME = "sql_dao_template";
        /**
         *  DAO_INTERFACE_MAPPER模板文件名称：sql_mapper_template
         */
        public static final String TEMPLATE_DAO_INTERFACE_MAPPER_FILE_NAME = "interface_mapper_template";
        /**
         *  DAO_INTERFACE_DAO模板文件名称：sql_dao_template
         */
        public static final String TEMPLATE_DAO_INTERFACE_DAO_FILE_NAME = "interface_dao_template";
    }
    
    /**
     * 持久层常量
     * @author zhiyic
     * @version $Id: GeneratorConstants.java, v 0.1 zhiyic Exp $
     */
    public static class PersistentConstants {
        /**
         * 数据库默认地址 
         */
        public static final String DEFAULT_DB_ADDRESS = "jdbc:mysql://172.16.10.11:3306";
        /**
         * 数据库默认库
         */
        public static final String DEFAULT_DB_SCHEMA = "crs";
        /**
         * 数据库默认请求路径 
         */
        public static final String DEFAULT_DB_URL = DEFAULT_DB_ADDRESS + "/" + DEFAULT_DB_SCHEMA + "?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        /**
         *  数据库默认用户
         */
        public static final String DEFAULT_DB_USER = "root";
        /**
         *  数据库默认用户名
         */
        public static final String DEFAULT_DB_PASSWORD = "weitu@123";
    }

    /**
     * 包名枚举类
     */
    public enum PackageEnum {
        /**
         * 基础工具类存放包名
         */
        COMMONS("commons", "commons"),
        /**
         * Vo对象存放包名
         */
        POJO_VO("entity", "entity"),
        /**
         * BO对象存放包名
         */
        POJO_BO("model.gen", "model.gen"),
        /**
         * controller对象存放包名
         */
        CONTROLLER("controller", "controller"),
        /**
         * busiservice对象存放包名
         */
        BUSI_SERVICE("busiservice", "busiservice"),
        /**
         * service对象存放包名
         */
        SERVICE("service", "service"),
        /**
         * dao.java存放包名
         */
        DAO_JAVA("dao.custom", "dao.custom"),
        /**
         * mapper.java存放包名
         */
        MAPPER_JAVA("dao.gen", "dao.gen");
        private String code;
        private String desc;

        PackageEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

    }
    
    /**
     * 创建文件相关常量
     * @author zhiyic
     * @version $Id: GeneratorConstants.java, v 0.1 zhiyic Exp $
     */
    public static class CreateFileConstants {
        /**
         *  创建java文件类型
         */
        public static final String CREATE_FILE_TYPE_JAVA = ".java";
        
        /**
         * 创建xml文件类型 
         */
        public static final String CREATE_FILE_TYPE_XML = ".xml";

        /**
         * 创建pojo文件名后缀：Vo 
         */
        public static final String CREATE_FILE_NAME_POJO_VO_SUFFIX = "Vo";
        /**
         *  创建Controller文件名后缀：Controller 
         */
        public static final String CREATE_FILE_NAME_CONTROLLER_SUFFIX = "Controller";
        /**
         *  创建BusiService文件名后缀：BusiService 
         */
        public static final String CREATE_FILE_NAME_BUSI_SERVICE_SUFFIX = "BusiService";
        /**
         *  创建ServiceImpl文件名后缀：BusiService
         */
        public static final String CREATE_FILE_NAME_BUSI_SERVICEIMPL_SUFFIX = "BusiService";
        /**
         *  创建Service文件名后缀：Service 
         */
        public static final String CREATE_FILE_NAME_SERVICE_SUFFIX = "Service";
        /**
         *  创建ServiceImpl文件名后缀：Service
         */
        public static final String CREATE_FILE_NAME_SERVICEIMPL_SUFFIX = "Service";
        /**
         * 创建sql_Mapper文件名后缀：Mapper
         */
        public static final String CREATE_FILE_NAME_SQL_MAPPER_SUFFIX = "Mapper";
        /**
         * 创建sql_Dao文件名后缀：Dao
         */
        public static final String CREATE_FILE_NAME_SQL_DAO_SUFFIX = "Dao";
        /**
         * 创建interface_Mapper文件名后缀：Mapper
         */
        public static final String CREATE_FILE_NAME_INTERFACE_MAPPER_SUFFIX = "Mapper";
        /**
         * 创建interface_Dao文件名后缀：Dao
         */
        public static final String CREATE_FILE_NAME_INTERFACE_DAO_SUFFIX = "Dao";

        /**
         * 创建文件默认存放地址，"F:/"
         */
        public static final String CREATE_FILE_DEFAULT_PATH = "F:" + File.separator;

        /**
         * Java文件存放根目录
         */
        public static final String JAVA_FILE_ROOT_PATH =  File.separator + "src" + File.separator +"main" + File.separator +"java" + File.separator;

        /**
         * 资源文件存放根目录
         */
        public static final String RESOURCES_FILE_ROOT_PATH =  File.separator + "src" + File.separator +"main" + File.separator +"resources" + File.separator;


        /**
         * Vo对象存放目录
         */
        public static final String POJO_VO_FILE_PATH = PackageEnum.POJO_VO.code +  File.separator;
        /**
         * BO对象存放目录
         */
        public static final String POJO_BO_FILE_PATH = "model" +  File.separator + "gen" + File.separator;

        /**
         * controller对象存放目录
         */
        public static final String  CONTROLLER_FILE_PATH = PackageEnum.CONTROLLER.code +  File.separator;
        /**
         * busiservice对象存放目录
         */
        public static final String  BUSI_SERVICE_FILE_PATH = PackageEnum.BUSI_SERVICE.code +  File.separator;
        /**
         * service对象存放目录
         */
        public static final String  SERVICE_FILE_PATH = PackageEnum.SERVICE.code +  File.separator;
        /**
         * dao.java存放目录
         */
        public static final String DAO_JAVA_FILE_PATH ="dao" +  File.separator + "custom" + File.separator;
        /**
         * mapper.java存放目录
         */
        public static final String MAPPER_JAVA_FILE_PATH ="dao" +  File.separator + "gen" + File.separator;
        /**
         * 生成sql_dao对象存放目录
         */
        public static final String SQL_DAO_FILE_PATH = "mapper" +  File.separator + "custom" + File.separator;
        /**
         * 生成sql_mappere对象存放目录
         */
        public static final String SQL_MAPPER_FILE_PATH = "mapper" +  File.separator + "gen" + File.separator;
    }

}
