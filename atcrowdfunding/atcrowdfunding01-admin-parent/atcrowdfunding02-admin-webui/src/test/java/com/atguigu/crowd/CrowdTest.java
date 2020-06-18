package com.atguigu.crowd;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Auther: lxz
 * @Date: 2020/5/6 0006
 * @Description:测试spring整合
 */

//使用spring的单元测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class CrowdTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleService roleService;



    //向t_role表中插入一些数据
    @Test
    public void testInsertRole() {
        for (int i = 3; i < 25; i++) {
            Role role = new Role(null,"Role"+i);
            roleMapper.insert(role);
        }
    }

    //向t_admin表中插入一些数据
    @Test
    public void testInsertAdmin() {
//        for (int i = 0; i < 25; i++) {
//            Admin admin = new Admin(null, "admin" + i, "123", "admin" + i, "admin" + i + "@qq.com", Long.toString(System.currentTimeMillis()));
//            adminMapper.insert(admin);
//        }
        Admin admin = new Admin(null, "Test", "123", "admin", "admin@qq.com", null);
        adminService.saveAdmin(admin);
    }


    @Test
    public void testAdminService() {
        Admin admin = new Admin(null, "Jerry", "123", "杰瑞", "Jerry@126.com", Long.toString(System.currentTimeMillis()));
        adminService.saveAdmin(admin);

    }


    @Test
    public void testLogger() {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        // 获取日志记录对象
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);
        // 按照 Debug 级别打印日志
        logger.debug(admin.toString());
    }


    @Test
    public void testInsert() {
        Admin admin = new Admin(null, "Tom", "123", "汤姆", "tom@126.com", Long.toString(System.currentTimeMillis()));
        adminMapper.insert(admin);
        System.out.println(admin);
    }

    @Test
    public void testConn() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
