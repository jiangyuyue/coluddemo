package com.jiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
public class XiaoFeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoFeiApplication.class, args);

    }

    @LoadBalanced//开启负载均衡默认轮询
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
