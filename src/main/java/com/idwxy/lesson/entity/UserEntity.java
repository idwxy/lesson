package com.idwxy.lesson.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

    // 用户 id
    private Integer id;
    // 用户姓名
    private String name;
    // 用户性别
    private Integer gender;
    // 用户年龄
    private Integer age;

    // 构造函数
    public UserEntity() {
        super();
    }
    public UserEntity(String name, Integer gender, Integer age) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "User [id=" + id + ",name=" + name + ",gender=" + gender + ",age=" + age +"]";
    }
}
