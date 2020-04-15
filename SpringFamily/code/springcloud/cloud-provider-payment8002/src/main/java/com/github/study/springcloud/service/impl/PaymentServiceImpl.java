package com.github.study.springcloud.service.impl;

import com.github.study.springcloud.dao.PaymentDao;
import com.github.study.springcloud.entities.Payment;
import com.github.study.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: lxz
 * @Date: 2020/4/14 0014
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
