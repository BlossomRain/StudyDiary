package com.github.study.springcloud.dao;

import com.github.study.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: lxz
 * @Date: 2020/4/14 0014
 * @Description:
 */


@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}