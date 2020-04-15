package com.github.study.springcloud.service;

import com.github.study.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: lxz
 * @Date: 2020/4/14 0014
 * @Description:
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
