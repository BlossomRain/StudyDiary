package com.github.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.ssm.bean.Book;
import com.github.ssm.bean.Msg;
import com.github.ssm.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/4/11 0011
 * @Description:处理书籍的增删改查
 */
@Controller
public class BookController {
    @Autowired
    BookService bookService;


    //书籍保存
    @ResponseBody
    @PostMapping("/book")
    public Msg saveBook(Book book) {
        int i = bookService.saveBook(book);
        System.out.println(book);
        return i == 0 ? Msg.failed() : Msg.successed();
    }

    //获取所有的销量信息并返回,模拟下拉框
    @ResponseBody
    @RequestMapping("/sales")
    public Msg getSales() {
        Msg msg = Msg.successed();
        List<Integer> sales = bookService.getSales();
        msg.add("sales", sales);
        return msg;
    }

    //直接返回json数据
    @RequestMapping("/books")
    @ResponseBody
    public Msg getBooksWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //为了分页查询方便,使用PageHelper插件,传入页数和每页大小
        PageHelper.startPage(pn, 5);
        //获取分页所有书籍
        List<Book> books = bookService.getBooks();
        //包装查询出来的书籍以及其他信息
        PageInfo page = new PageInfo(books, 5);
        return Msg.successed().add("page", page);
    }

    //查询书籍数据,分页查询,直接返回页面不能通用
//    @RequestMapping("/books")
    public String getBooks(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                           Model model) {
        //为了分页查询方便,使用PageHelper插件,传入页数和每页大小
        PageHelper.startPage(pn, 5);
        //获取分页所有书籍
        List<Book> books = bookService.getBooks();
        //包装查询出来的书籍以及其他信息
        PageInfo page = new PageInfo(books, 5);
        model.addAttribute("page", page);
        return "list";
    }
}
