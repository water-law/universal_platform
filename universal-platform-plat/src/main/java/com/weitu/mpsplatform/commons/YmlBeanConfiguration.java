//package com.weitu.mpsplatform.commons;
//
//import com.weitu.mpsplatform.commons.utils.YamlConfigurerUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//import java.util.Properties;
//
///**
// * @Description: ymlBean配置
// * @Author: senhuaF
// * @CreateDate: 2019/10/28 10:20
// * @Version 1.0
// **/
//@Configuration
//public class YmlBeanConfiguration {
//
//    private static final Logger log = LoggerFactory.getLogger(YmlBeanConfiguration.class);
//
//    // 配置单个配置文件方式
////    @Bean
////    public YamlConfigurerUtil ymlConfigurerUtil() {
////        //1:加载配置文件
////        Resource app = new ClassPathResource("bootstrap.yml");
////        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
////        // 2:将加载的配置文件交给 YamlPropertiesFactoryBean
////        yamlPropertiesFactoryBean.setResources(app);
////        // 3：将yml转换成 key：val
////        Properties properties = yamlPropertiesFactoryBean.getObject();
////        // 4: 将Properties 通过构造方法交给我们写的工具类
////        YamlConfigurerUtil ymlConfigurerUtil = new YamlConfigurerUtil(properties);
////        return ymlConfigurerUtil;
////    }
//
//    // springboot优雅的获取yml配置（区分生产环境和测试环境）
//    // 参考https://blog.csdn.net/weixin_43995403/article/details/89713426
//    @Bean
//    public YamlConfigurerUtil ymlConfigurerUtil() {
//
//        //1:加载配置文件
//        Resource app = new ClassPathResource("bootstrap.yml");
//        Resource appDev = new ClassPathResource("bootstrap-dev.yml");
//        Resource appProd = new ClassPathResource("bootstrap-prod.yml");
//        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
//        // 2:将加载的配置文件交给 YamlPropertiesFactoryBean
//        yamlPropertiesFactoryBean.setResources(app);
//        // 3：将yml转换成 key：val
//        Properties properties = yamlPropertiesFactoryBean.getObject();
//        String active = properties.getProperty("spring.profiles.active");
//        if (active == "" || active == null) {
//            log.error("未找到spring.profiles.active配置！");
//        }else {
//            //判断当前配置是什么环境
//            if ("dev".equals(active)) {
//                yamlPropertiesFactoryBean.setResources(app,appDev);
//            }else if("prod".equals(active)){
//                yamlPropertiesFactoryBean.setResources(app,appProd);
//            }
//        }
//        // 4: 将Properties 通过构造方法交给我们写的工具类
//        YamlConfigurerUtil ymlConfigurerUtil = new YamlConfigurerUtil(yamlPropertiesFactoryBean.getObject());
//        return ymlConfigurerUtil;
//    }
//
//}