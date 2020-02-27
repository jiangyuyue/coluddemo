package com.jiang.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Table(name = "user_tab")
public class User implements Serializable {

    @Id//数据库中主键
    @KeySql(useGeneratedKeys = true)
    private Integer userid;

    private String username;

    @Transient
    private String test;//不需要和数据库中的字段,不作为sql的一个字段

}