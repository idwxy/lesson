package com.idwxy.lesson.controller;

import com.idwxy.lesson.common.ResultObject;
import com.idwxy.lesson.entity.AccountEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    // 指定请求方法类型为 post，URL 为 /account/add，从请求信息体重获取 account 对象，通过 Jackson 完成反序列化
    @PostMapping("/add")
    public ResultObject add(@RequestBody AccountEntity accountEntity) {
        // 打印前端发送的 account
        System.out.println(accountEntity);
        // 将前端发送的 account 参数直接返回，观察 id 是否存在、username 的名称、password 是否存在、date 的格式
        return new ResultObject(accountEntity);
    }
}
