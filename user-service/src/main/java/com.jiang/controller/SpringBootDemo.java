package com.jiang.controller;

import com.jiang.LisnterenPort.ServerPort;
import com.jiang.dao.UserMapper;
import com.jiang.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SpringBootDemo {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private ServerPort serverPort;

    @GetMapping("hello/{id}")
    public User testSpringBoot(@PathVariable int id) {
        log.info("port:" + serverPort.getServerPort());
        return userMapper.selectByPrimaryKey(id);
    }
}
