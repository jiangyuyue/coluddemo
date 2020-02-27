package com.jiang.controller;

import com.jiang.feignclient.UserClient;
import com.jiang.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class XiaoFei2Controller {

    @Resource
    private UserClient userClient;
 //   @GetMapping("hello/{id}")
    @GetMapping("GetUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userClient.getUserbyID(id);
    }

}
