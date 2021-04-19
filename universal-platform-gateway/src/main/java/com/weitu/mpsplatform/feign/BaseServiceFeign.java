package com.weitu.mpsplatform.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能描述: 基础服务，服务之间的调用
 * @Author: senhuaF
 * @Date: 2019/7/23 17:00
 * @Version 1.0
 **/
@FeignClient(name = "mps-platform-web")
public interface BaseServiceFeign {

    /**
     * token生成
     * @param token    token值
     * @return
     */
    @PostMapping("/token/verify")
    String tokenVerify(
            @RequestParam(name = "token") String token
    );
}
