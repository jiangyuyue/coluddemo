package com.jiang.feignclient;

import com.jiang.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {

    // 实现UserClient 接口，熔断会调用这个方法
    @Override
    public User getUserbyID(Integer id) {
        User user = new User();
        user.setUsername("未知用户");
        return user;
    }
}
