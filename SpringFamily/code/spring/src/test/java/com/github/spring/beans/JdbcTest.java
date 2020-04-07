package com.github.spring.beans;

import com.mysql.fabric.xmlrpc.base.Param;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lxz
 * @Date: 2020/4/5 0005
 * @Description:测试spring对jdbc的支持
 */
public class JdbcTest {
    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

    {
        ctx = new ClassPathXmlApplicationContext("jdbc.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
    }


    //测试spring的namedParameterJdbcTemplate 的测试
    @Test//比原来方便
    public void testNameInsert2() {
        String sql = "insert into customers(name,address)values(:name,:address)";
        Customer customer = new Customer("嘴平伊之助", "山下", "9900", new Date(System.currentTimeMillis()));
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(customer);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }

    @Test//麻烦,但是便于维护
    public void testNameInsert() {
        String sql = "insert into customers(name,address)values(:n,:a)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("n", "我妻善逸");
        paramMap.put("a", "山下");

        namedParameterJdbcTemplate.update(sql, paramMap);
    }


    //测试spring的jdbcTempla 的查询

    //jdbcTemplate 测试聚集函数
    @Test
    public void testValue() {
        String sql = "select count(*) from customers";
        long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(aLong);

    }


    //jdbcTemplate.queryForOne(sql, Customer.class);不是用这个方法
    @Test
    public void testQueryForOne() {
        String sql = "select id,name,address,birth from customers where id=9";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customers = jdbcTemplate.queryForObject(sql, rowMapper);
        System.out.println(customers);
    }

    @Test
    public void testQueryForList() {
        String sql = "select id,name,address,birth from customers ";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        List<Customer> query = jdbcTemplate.query(sql, rowMapper);
        for (Customer customer : query) {
            System.out.println(customer);
        }
    }

    //测试spring的jdbcTempla 的批量处理
    @Test
    public void testBatch() {
        String sql = "insert into customers(name,address,phone)values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"灶门炭治郎", "山上", 999});
        batchArgs.add(new Object[]{"灶门祢豆子", "山上", 666});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    //测试spring的jdbcTempla 的 update---->INSERT UPDATE DELETE
    @Test
    public void testUpdate() {
        String sql = "update customers set name=? where id = ?";
        int update = jdbcTemplate.update(sql, "弥豆子", 2);
        System.out.println(update);
    }


    @Test
    public void testDatasource() throws SQLException {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

}
