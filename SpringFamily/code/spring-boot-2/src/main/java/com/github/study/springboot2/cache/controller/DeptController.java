//package com.github.study.springboot2.cache.controller;
//
//
//import com.github.study.springboot2.cache.bean.Department;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class DeptController {
//
//    @Autowired
//    DeptService deptService;
//
//    @GetMapping("/dept/{id}")
//    public Department getDept(@PathVariable("id") Integer id){
//        return deptService.getDeptById(id);
//    }
//}
