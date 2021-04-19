package com.weitu.mpsplatform.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Description 
 * @Author: 范森华
 * @Date 2019/7/15 15:27
 * @Param 
 * @return 
 **/
@Component
@Configuration
public class GetWayCorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);//允许cookies跨域
        corsConfiguration.addAllowedHeader("*");//头部
        corsConfiguration.addAllowedOrigin("*");//URL
        corsConfiguration.addAllowedMethod("*");//方法
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);
    }
}
