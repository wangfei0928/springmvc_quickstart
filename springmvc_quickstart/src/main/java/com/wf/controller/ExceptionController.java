package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("/testException")
    public String testExeception(){
        int i = 1/0;
        return "Success";
    }
}
