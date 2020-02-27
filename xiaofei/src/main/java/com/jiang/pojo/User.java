package com.jiang.pojo;


import java.io.Serializable;


public class User implements Serializable {
    private Integer userid;
    private String username;
    private String test;//不需要和数据库中的字段,不作为sql的一个字段

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}