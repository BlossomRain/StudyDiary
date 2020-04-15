package com.gihub.study.springboot.component;

import com.gihub.study.springboot.dao.EmployeeDao;
import com.gihub.study.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @Auther: lxz
 * @Date: 2020/4/13 0013
 * @Description:
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao dao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = dao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }
}
