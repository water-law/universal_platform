package com.weitu.mpsplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class MpsPlatFormEurekaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MpsPlatFormEurekaApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MpsPlatFormEurekaApplication.class);
    }
}
