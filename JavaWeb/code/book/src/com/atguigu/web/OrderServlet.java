package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: lxz
 * @Date: 2020/4/3 0003
 * @Description:
 */
public class OrderServlet extends BaseServlet {

    private OrderService service = new OrderServiceImpl();

    //创建订单
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User loginUser = (User) request.getSession().getAttribute("user");
        //如果用户没有登陆,转到登陆页面
        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }

        Integer userId = loginUser.getId();
        //生成订单 需要事务管理 采用Filter进行控制

        /*String orderId = null;
        try {
            orderId = service.createOrder(cart, userId);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();
        }*/
        String orderId = service.createOrder(cart, userId);
        request.getSession().setAttribute("orderId", orderId);
        //重定向,阻止重复提交
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
//        request.getRequestDispatcher("").forward(request, response);
    }


}
