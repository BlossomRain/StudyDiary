package com.test.main;

import com.test.bean.Customer;
import com.test.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Auther: lxz
 * @Date: 2020/3/27 0027
 * @Description:测试DBUtils
 */
public class QueryRunnerTest {

    //测试查询
    @Test
    public void testQueryOne() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select id,name,address,phone from customers where id = ?";

        ResultSetHandler<Customer> rsh = new BeanHandler<>(Customer.class);
        runner.query(conn, sql, rsh, 8);
        JDBCUtil.release(conn, null);
    }


    //测试queryRunner的增删改操作
    @Test
    public void testUpdate() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtil.getConnection();
        String sql = "INSERT INTO customers(id,name,address)values(?,?,?)";

        runner.update(connection, sql, 8, "蔡徐坤", "caixukun");

        JDBCUtil.release(connection, null);
    }


}
