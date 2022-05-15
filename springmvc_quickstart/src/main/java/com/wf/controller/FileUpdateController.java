package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUpdateController {
    /*
    * 单文件上传
    * */
    @RequestMapping("/fileupload")
    public String fileUpload(String username, MultipartFile filePic) throws IOException {
        //获取表单的提交参数,完成文件上传
        System.out.println(username);
        String originalFilename = filePic.getOriginalFilename();

            filePic.transferTo(new File("D:/upload/"+originalFilename));


        return "Success";
    }
    @RequestMapping("/filesupload")
    public String filesUpload(String username, MultipartFile[] filePic) throws IOException {
        //获取表单的提交参数,完成文件上传
        System.out.println(username);
        for (MultipartFile multipartFile : filePic) {
            //获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            //保存到服务器
            multipartFile.transferTo(new File("D:/upload/" + originalFilename));
        }
        return "Success";
    }

}
