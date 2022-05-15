package com.wf.controller;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController  //组合注解组合了@Controller+@ResponseBody
@RequestMapping("restful")
public class RestfulController {
    /*
    *   根据id进行查询
    * localhost:8080/项目路径/restful/user/2+get请求方法
    * */

   // @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)

    @GetMapping( "/user/{id}")   //相当于@RequestMapping  必须是get请求
    public String findById(@PathVariable Integer id){
        //调用service方法完成对id等于2的这条记录的查询
        //findById方法中怎么才能获取到restful编程风格中的url里面的占位符的值

        return "findById:"+id;
    }

    /*
    * 新增方法
    * */
    @PostMapping("/user")   //相当于@RequestMapping  method = RequestMethod.POST
    public String post(){
        //新增
        return "post";
    }

    /*更新方法*/
    @PutMapping("/user")
    public String put(){
        //更新方法
        return "put";
    }

    /*
    * 删除方法
    * */
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Integer id){
        return "delete"+id;
    }

}
