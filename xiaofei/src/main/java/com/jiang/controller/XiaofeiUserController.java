package com.jiang.controller;

import com.jiang.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@DefaultProperties(defaultFallback = "getUsercallback")//方法加上HystrixCommand注解 服务降级默认调用getUsercallback（）方法
public class XiaofeiUserController {
    @Autowired
    private RestTemplate restTemplate;

//    @Resource
//    private RibbonLoadBalancerClient ribbonLoadBalancerClient;//负载均衡器


    //        List<ServiceInstance> instances = hhh.getInstances("user-service");//根据服务id查询列表
//        System.out.println("user-service列表有："+instances.size());
//        ServiceInstance serviceInstance = instances.get(0);

    //        ServiceInstance choose = ribbonLoadBalancerClient.choose("user-service");//默认是轮询
//        String url="http://"+ choose.getHost()+":"+ choose.getPort()+"/hello/"+id;
    @GetMapping("getuser/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")//修改超时时间
    })//开启线程隔离和服务降级(熔断机制)
    public String getUser(@PathVariable Integer id) {

        String url = "http://user-service/hello/" + id;
        String user = restTemplate.getForObject(url, String.class);//默认是轮询
        System.out.println("user" + user);
        return user;
    }
    /*
     *
     * */

    public String getUsercallback() {
        return "服务器繁忙";
    }
}
