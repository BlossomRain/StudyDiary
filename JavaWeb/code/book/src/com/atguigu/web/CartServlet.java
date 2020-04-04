package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lxz
 * @Date: 2020/4/3 0003
 * @Description:购物车功能模块
 */
public class CartServlet extends BaseServlet {

    private BookService service = new BookServiceImpl();

    //修改商品数量
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    //清空购物车
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            response.sendRedirect(request.getHeader("Referer"));
        }

    }

    //删除商品项
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.removeItem(id);
        }
        response.sendRedirect(request.getHeader("Referer"));

    }

    //加入购物车
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数,加入购物车

        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //查询图书信息
        Book book = service.queryBookById(id);

        //转成CartItem,加入购物车

        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        cart.addItem(item);
        request.getSession().setAttribute("bookName", book.getName());

//      response.sendRedirect(request.getContextPath() + "/index.jsp");
        response.sendRedirect(request.getHeader("Referer"));
    }

    //加入购物车 Ajax版本
    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数,加入购物车

        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //查询图书信息
        Book book = service.queryBookById(id);

        //转成CartItem,加入购物车

        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        cart.addItem(item);
//        request.getSession().setAttribute("bookName", book.getName());
        //返回json对象
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("bookName", book.getName());
        resultMap.put("totalCount", cart.getTotalCount());

        String s = new Gson().toJson(resultMap);
        response.getWriter().write(s);
    }
}
