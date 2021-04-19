## mps-platform-fileServer

公安文件服务器

直接运行主函数，遇到如下错误：

```$xslt

org.springframework.beans.factory.BeanDefinitionStoreException: Failed to parse configuration class [com.weitu.fileserver.Application]; nested exception is java.lang.IllegalStateException: Failed to introspect annotated methods on class org.springframework.boot.web.support.SpringBootServletInitializer
	at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:181) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:308) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:228) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:270) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:93) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:686) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:524) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:737) [spring-boot-1.5.3.RELEASE.jar:1.5.3.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:370) [spring-boot-1.5.3.RELEASE.jar:1.5.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:314) [spring-boot-1.5.3.RELEASE.jar:1.5.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1162) [spring-boot-1.5.3.RELEASE.jar:1.5.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1151) [spring-boot-1.5.3.RELEASE.jar:1.5.3.RELEASE]
	at com.weitu.fileserver.Application.main(Application.java:22) [classes/:na]
Caused by: java.lang.IllegalStateException: Failed to introspect annotated methods on class org.springframework.boot.web.support.SpringBootServletInitializer
	at org.springframework.core.type.StandardAnnotationMetadata.getAnnotatedMethods(StandardAnnotationMetadata.java:163) ~[spring-core-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.retrieveBeanMethodMetadata(ConfigurationClassParser.java:380) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.doProcessConfigurationClass(ConfigurationClassParser.java:314) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.processConfigurationClass(ConfigurationClassParser.java:245) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:198) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:167) ~[spring-context-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	... 12 common frames omitted
Caused by: java.lang.NoClassDefFoundError: javax/servlet/ServletContext
	at java.lang.Class.getDeclaredMethods0(Native Method) ~[na:1.8.0_181]
	at java.lang.Class.privateGetDeclaredMethods(Class.java:2701) ~[na:1.8.0_181]
	at java.lang.Class.getDeclaredMethods(Class.java:1975) ~[na:1.8.0_181]
	at org.springframework.core.type.StandardAnnotationMetadata.getAnnotatedMethods(StandardAnnotationMetadata.java:152) ~[spring-core-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	... 17 common frames omitted
Caused by: java.lang.ClassNotFoundException: javax.servlet.ServletContext
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381) ~[na:1.8.0_181]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_181]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349) ~[na:1.8.0_181]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_181]
	... 21 common frames omitted
```

解决办法：

引入插件,并且用插件执行(spring-boot:run)

```$xslt
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

mongo 4.0 添加用户
```$xslt
use test
db.createUser({user:"weitu2019", pwd:"weitu2019!", roles:[{role:"dbOwner", db:'test'}]})
```

