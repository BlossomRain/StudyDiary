package com.github.springmvc.handlers;

import com.github.springmvc.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @Auther: lxz
 * @Date: 2020/4/6 0006
 * @Description:测试注解的使用
 */


//只能放在类上面,属性名相同的话,添加时候也会添加进session域中
//@SessionAttributes(value = "time", types = {String.class})
@Controller
@RequestMapping("/springMVC")
public class SpringMVCTest {

    private static final String SUCCESS = "success";


    //测试重定向
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }

    //测试自定义的视图解析器
    @RequestMapping("/testView")
    public String testView() {
        System.out.println("test View ");
        return "helloView";
    }

    //测试ModelAttribute,User对象不是新创建出来的,而是从数据库查询出来的
    //标记以后会在每个目标方法前面都执行
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map) {
        System.out.println("ModelAttribute被调用啦!!!");
        if (id != null) {
            User user = new User("Tom", "123456", 99, null);
            user.setId(id);
            System.out.println("从数据库中获取一个User对象" + user);
            //注意,这里Key名称要和目标方法的入参名称第一个字母小写一致
            map.put("user", user);
        }
    }

    //测试ModelAttribute,User对象不是新创建出来的,而是从数据库查询出来的
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println(user);
        return SUCCESS;
    }

    //ModelAndView====还可以将一个Map map设置为入参,springmvc会自动将里面的键值对自动取出并放到req里面
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView(SUCCESS);
        //添加数据
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    //还可以获取原生的servletAPI对象
    //测试POJO
    @RequestMapping(value = "/testPojo")
    public String testPojo(User user, HttpServletRequest request) {
        System.out.println(user);
        System.out.println(request);
        return SUCCESS;
    }

    //测试cookie
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("JSESSIONID" + cookieValue);
        return SUCCESS;
    }

    //测试请求头 请求参数
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String name,
                                   @RequestParam(value = "age", required = false, defaultValue = "0") Integer age,
                                   @RequestHeader(value = "Accept-Language") String al) {
        System.out.println(name + "--->" + age);
        System.out.println("Accept-Language" + al);
        return SUCCESS;
    }

    //测试REST风格的请求---视图解析DELETE和PUT会发生问题,原因是Servlet2.3后只支持HEAD
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable("id") Integer id) {
        System.out.println("testRest  Get  " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest() {
        System.out.println("testRest  Post  ");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.HEAD)
    public String testRestD(@PathVariable("id") Integer id) {
        System.out.println("testRest  DELETE  " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPUT(@PathVariable("id") Integer id) {
        System.out.println("testRest  PUT  " + id);
        return SUCCESS;
    }

    /**
     * @Description: 测试Url参数映射到目标方法的参数中
     */
    @RequestMapping(value = "/testPathVariable/{pathId}")
    public String testPathVariable(@PathVariable("pathId") String id) {
        System.out.println("testPathVariable" + id);
        return SUCCESS;
    }

    /**
     * @Description: 测试参数限制请求映射
     */
    @RequestMapping(value = "/testParamAndHeader", params = {"username", "age!=10"})
    public String testParamAndHeader() {
        System.out.println("testParamAndHeader");
        return SUCCESS;
    }

    /**
     * @Description: 测试参数限制请求映射
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * @Description: 测试reqMapping注解
     */
    @RequestMapping("/testRequsetMapping")
    public String testRequsetMapping() {

        System.out.println("testRequsetMapping");
        return SUCCESS;
    }

}
