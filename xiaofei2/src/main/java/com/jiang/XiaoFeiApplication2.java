package com.jiang;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class XiaoFeiApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(XiaoFeiApplication2.class, args);
    }
}
