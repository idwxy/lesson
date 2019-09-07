package com.idwxy.lesson.controller;

import com.idwxy.lesson.common.ResultObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/cookie")
public class CookieController {

    // 设置 cookie,返回给前端，GET 请求方法类型
    @GetMapping("/set")
    public ResultObject setCookie(HttpServletRequest request, HttpServletResponse response) {

        // 获取当前时间
        String time = String.valueOf(System.currentTimeMillis());
        // 创建 cookie，用来记录用户最近一次访问
        Cookie cookie = new Cookie("last", time);
        // 设置 cookie 过期时间，单位秒，当前例子为一个星期
        cookie.setMaxAge(60 * 60 * 24 * 7);
        // 将 cookie 添加加到响应中
        response.addCookie(cookie);
        return new ResultObject(null);
    }

    @GetMapping("/get")
    public ResultObject getCookie(HttpServletRequest request, HttpServletResponse response) {

        // 获取请求携带的所有 cookie
        Cookie[] cookies = request.getCookies();
        // 判断，如果一个 cookie 都没有，直接返回失败
        if (cookies != null) {
            // 通过循环比较获取指定 cookie
            for (Cookie cookie : cookies) {
                if ("last".equals(cookie.getName())) {
                    // 如果有，打印出 cookie 值
                    System.out.println(cookie.getValue());
                    return new ResultObject(null);
                }
            }
        }
        return new ResultObject(412, "请求失败");
    }

    // 通过注解从前端请求中获取指定的 cookie
    @GetMapping("/getByAnnotation")
    public ResultObject getCookieByAnnotation(@CookieValue("last") String last) {
        // 打印获取指定的 cookie
        System.out.println(last);
        return new ResultObject(null);
    }
}
