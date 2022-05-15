package com.wf.controller;

import com.wf.domain.QueryVo;
import com.wf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.lang.model.element.NestingKind;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.CodeSource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("username")
@RequestMapping("user") //访问一级目录
public class UserController {

    /*
    * path: 作用等同于value,同样是设置映射地址
    * method:用来限定请求的方式， RequestMethod.POST 只能以post的请求方式进行访问，其他请求方式会报错
    *
    * */
    @RequestMapping(path = "/quick",method = RequestMethod.GET)
    public String quick(){
        //业务逻辑
        System.out.println("Springmvc入门成功");
        return "Success";
    }
    /*
    * 获取基本类型请求参数
    * */

    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id,String username) {
        System.out.println(id);
        System.out.println(username);
        return "Success";
    }

    @RequestMapping("/pojoParam")
    public String pojoParam(User user){
        System.out.println(user);
        return "Success";
    }


    @RequestMapping("/arrayParam")
    public String arrayParam(Integer ids[]){
        System.out.println(Arrays.toString(ids));
        return "Success";
    }
    @RequestMapping("/queryParam")
    public String queryParam(QueryVo queryVo){
        System.out.println(queryVo);
        return "Success";
    }

    @RequestMapping("/converterParam")
    public String converterParam(Date birthday) {
        System.out.println(birthday);
        return "Success";
    }
    @RequestMapping("/findBypage")
    public String findBypage(@RequestParam(name = "pageNo",defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        return "Success";
    }

    @RequestMapping("/RequestHeader")
    public String requestHead(@RequestHeader("cookie") String cookie){
        System.out.println(cookie);
        return "Success";
    }

    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionID){
        System.out.println(jsessionID);
        return "Success";
    }

    /*
    * 原始servlet的获取
    * */
    @RequestMapping("/servlet-API")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "Success";
    }

    /*
    * 通过原始的servletApi进行页面跳转
    * */
    @RequestMapping("/returnVoid")
    public  void returnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //借用request对象，完成一次请求转发
        /*request.getRequestDispatcher("/WEB-INF/pages/Success.jsp").forward(request,response);*/


        //通过response实现重定向,两次请求，WEB-INF：安全目录，只可以进行服务器内部转发，不允许外部请求直接访问该目录资源
        /*response.sendRedirect(request.getContextPath()+"/index.jsp");*/


        /*直接返回数据*/
        response.setContentType("text/html;charset = utf-8");
        response.getWriter().write("大菜鸡");
    }
    //演示forward关键字惊醒请求转发
    @RequestMapping("/forward")
    public String forward(Model model){
        //在页面中设置一些moudle
        model.addAttribute("username","拉钩招聘");
        //既可以转发到jsp，也可以转发到其他控制器方法
        return "forward:/WEB-INF/pages/Success.jsp";
    }

    @RequestMapping("/redirect")

    public String redirect(Model model){
        //model底层还是使用request.setAttribute("username","拉钩招聘")域范围，一次请求。
        model.addAttribute("username","拉钩招聘");
        /*当写了关键字redirect和forward,是不会再走视图解析器的*/
        return "redirect:/index.jsp";

    }

    @RequestMapping("/returnString")
    public String returnString(){
        return "Success";
    }

    @RequestMapping("/returnModelAndView1")
    public ModelAndView returnModelAndView1(){
        /*
        * Model: 模型  作用封装数据
        * View: 视图  作用展示数据
        * */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","lagou");
        //设置视图名称    视图解析器ModelAndView拼接前缀和后缀
        modelAndView.setViewName("Success");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView){
        /*
         * Model: 模型  作用封装数据
         * View: 视图  作用展示数据
         * */
        //设置模型数据
        modelAndView.addObject("username","ModelAndView方式二");
        //设置视图名称
        modelAndView.setViewName("Success");
        return modelAndView;
    }


    /*
    * ajax异步交互
    * */
    @ResponseBody
    @RequestMapping("/ajaxRequest")
    public List<User> ajaxRequest(@RequestBody List<User> list){

        System.out.println(list);
        return list;
    }

}
