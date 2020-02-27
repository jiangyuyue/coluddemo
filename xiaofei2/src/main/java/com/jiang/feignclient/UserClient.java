package com.jiang.feignclient;

import  com.jiang.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", fallback = UserClientImpl.class)
public interface UserClient {
    @GetMapping("hello/{id}")
    User getUserbyID(@PathVariable("id") Integer id);
}
