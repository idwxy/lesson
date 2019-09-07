package com.idwxy.lesson.controller;

import com.idwxy.lesson.common.ResultObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionController {

    // 创建 session 和 设置 session 属性
    @GetMapping("/set")
    public ResultObject setSession(HttpServletRequest request, HttpServletResponse response) {
        // 若 session 不存在则创建，若存在则获取
        HttpSession session = request.getSession();
        // 获取 sessionId
        String sessionId = session.getId();
        // 打印 sessionId
        System.out.println(sessionId);
        // 设置 session 属性
        session.setAttribute("company", "wxy");
        return new ResultObject(null);
    }

    @GetMapping("/get")
    public ResultObject getSession(HttpServletRequest request, HttpServletResponse response) {
        // 获取 session，不存在则创建
        HttpSession session = request.getSession();
        // 获取 session 属性
        String name = (String) session.getAttribute("company");
        return new ResultObject(name);
    }
}
