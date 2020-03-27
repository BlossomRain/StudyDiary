package com.test.main;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.test.util.JDBCUtil;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: lxz
 * @Date: 2020/3/27 0027
 * @Description:数据源测试
 */
public class DataSourceTest {
    /**
     * @Description: C3P0数据源, 连接获取
     * @create: 2020/3/27 0027 16:19
     * @return: void
     */
    @Test
    public void testC3P0() throws Exception {

        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);

    }

}
