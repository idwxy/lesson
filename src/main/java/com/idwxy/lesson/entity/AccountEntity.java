package com.idwxy.lesson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class AccountEntity implements Serializable {

    // 帐户 id 只有在非 null 的情况下才序列化
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    // 账户名称，重命名为 name
    @JsonProperty("name")
    private String username;
    // 账户密码
    private String password;
    // 帐户创造世界，格式化时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date date;

    // 构造函数
    public AccountEntity() {
        super();
    }

    public AccountEntity(String username, String password, Date date) {
        super();
        this.username = username;
        this.password = password;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // 向前端接受参数的时候，忽略 password，该属性不参加序列化，防止泄露密码
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    // 从前端接受参数的时候，可以正常反序列化
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    // 重写 toString 方法
    @Override
    public String toString() {
        return "Account [id=" + id + ",username=" + username + ",password=" + password + ",date=" + date + "]";
    }
}
