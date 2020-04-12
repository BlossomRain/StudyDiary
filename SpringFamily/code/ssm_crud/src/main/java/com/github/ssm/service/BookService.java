package com.github.ssm.service;

import com.github.ssm.bean.Book;
import com.github.ssm.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/4/11 0011
 * @Description:
 */
@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    //查询所有书
    public List<Book> getBooks() {
        return bookMapper.selectByExample(null);
    }

    public List<Integer> getSales() {
        //这里模拟销量从数据库查出并封装到List,并没有实际意义,只是为了模拟添加页面下拉框的效果
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    //保存书的信息
    public int saveBook(Book book) {
        return bookMapper.insertSelective(book);
    }
}
