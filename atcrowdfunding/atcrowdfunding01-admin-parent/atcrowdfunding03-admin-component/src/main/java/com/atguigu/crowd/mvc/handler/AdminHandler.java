package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Auther: lxz
 * @Date: 2020/5/8 0008
 * @Description:
 */
@Controller
public class AdminHandler {

    @Autowired
    private AdminService adminService;

    //修改处理
    @RequestMapping("/admin/update.html")
    public String update(Admin admin,
                         @RequestParam("pageNum") Integer pageNum,
                         @RequestParam("keyword") String keyword) {

        adminService.update(admin);

        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }

    //编辑页面跳转处理
    @RequestMapping("/admin/to/edit/page.html")
    public String toEditPage(
            @RequestParam("adminId") Integer adminId,
            ModelMap modelMap
    ) {

        // 1.根据adminId查询Admin对象
        Admin admin = adminService.getAdminById(adminId);

        // 2.将Admin对象存入模型
        modelMap.addAttribute("admin", admin);

        return "admin-edit";
    }

    //新添用户
    @RequestMapping("/admin/save.html")
    public String adminSave(Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/admin/get/page.html?pageNum=" + Integer.MAX_VALUE;
    }

    //处理单行删除
    @RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyword}.html")
    public String adminRemove(@PathVariable("adminId") Integer adminId,
                              @PathVariable("pageNum") Integer pageNum,
                              @PathVariable("keyword") String keyword
    ) {
        adminService.remove(adminId);
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }

    //处理分页
    @RequestMapping("/admin/get/page.html")
    public String getPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                              ModelMap modelMap) {
        // 1.调用service的方法
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
        // 2.放入map
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
        return "admin-page";
    }

    //登出处理
    @RequestMapping("/admin/do/logout.html")
    public String doLogout(HttpSession session) {
        // 强制 Session 失效
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }


    //登陆处理
    @RequestMapping(value = "admin/do/login.html", method = RequestMethod.POST)
    public String doLogin(@RequestParam("loginAcct") String loginAcct,
                          @RequestParam("userPswd") String userPswd,
                          HttpSession session) throws Exception {
        System.out.println("-------->");
        // 调用 Service 方法执行登录检查
        // 这个方法如果能够返回 admin 对象说明登录成功，如果账号、密码不正确则会抛出 异常
        Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);
        // 将登录成功返回的 admin 对象存入 Session 域
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
        return "redirect:/admin/to/main/page.html";
    }
}

