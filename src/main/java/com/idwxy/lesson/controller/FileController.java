package com.idwxy.lesson.controller;

import com.idwxy.lesson.common.ResultObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    // 文件保存路径
    private static String FILE_PATH = "D:/project/";

    // 上传文件
    @PostMapping("/upload")
    public ResultObject add(MultipartFile file) {
        // 如果 file 为空直接返回
        if (file.isEmpty()) {
            return new ResultObject(412, "文件为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件大小
        long size = file.getSize();
        // 打印文件大小
        System.out.println(size);
        // 创建文件
        File dest = new File(FILE_PATH + fileName);
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return new ResultObject(412,"state exception");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultObject(412, "io exception");
        }
        return new ResultObject(null);
    }

}
