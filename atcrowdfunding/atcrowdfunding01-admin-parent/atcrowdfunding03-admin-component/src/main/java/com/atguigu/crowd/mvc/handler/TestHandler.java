package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/5/6 0006
 * @Description:
 */
@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/send/array.json")
    //参数接收加上[] 是jq的问题,假如采用.ajax直接发送数据的话
    public String testReceiveOne(@RequestParam("array") List<Integer> array) {
        array.forEach(System.out::println);
        return "success";
    }

    //测试mvc搭建
    @RequestMapping("/test/ssm.html")
    public String testSSM(ModelMap modelMap) {
        List<Admin> admins = adminService.getAll();
        modelMap.addAttribute("admins", admins);
        return "forward:target";
    }
}
