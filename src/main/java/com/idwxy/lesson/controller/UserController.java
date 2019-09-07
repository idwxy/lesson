package com.idwxy.lesson.controller;

import com.idwxy.lesson.common.ResultObject;
import com.idwxy.lesson.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    // 保存用户信息，模拟数据库的作用
    private static Map<Integer, UserEntity> userMap = new HashMap<>();

    // 添加用户
    @PostMapping("/add")
    public ResultObject add(@RequestBody UserEntity user) {
        userMap.put(user.getId(), user);
        return new ResultObject(userMap);
    }

    // 删除用户
    @DeleteMapping("/delete/{id}")
    public ResultObject delete(@PathVariable int id) {
        userMap.remove(id);
        return new ResultObject(userMap);
    }

    // 修改用户
    @PutMapping("/modify")
    public ResultObject modify(@RequestBody UserEntity user) {
        userMap.put(user.getId(), user);
        return new ResultObject(userMap);
    }

    // 获取指定 id, /findByPathVariable/{id}，从url路径中获取id参数
    @GetMapping("/findByPathVariable/{id}")
    public ResultObject findByPathVariable(@PathVariable int id) {
        UserEntity user = userMap.get(id);
        return new ResultObject(user);
    }

    // 获取指定 id，/findByRequestParam?id=1，从url路径中获取id参数
    @GetMapping("/findByRequestParam")
    public ResultObject findByRequestParam(@RequestParam int id) {
        UserEntity user = userMap.get(id);
        return new ResultObject(user);
    }

    // 获取请求头中的 header 信息，
    @GetMapping("/getHeader")
    public ResultObject getHeader(@RequestHeader String token) {
        return new ResultObject(token);
    }

    // 获取请求中的参数
    @GetMapping("getRequest")
    public ResultObject getRequest(HttpServletRequest request, HttpServletResponse response) {
        String id =  request.getParameter("id");
        return new ResultObject(id);
    }
}
