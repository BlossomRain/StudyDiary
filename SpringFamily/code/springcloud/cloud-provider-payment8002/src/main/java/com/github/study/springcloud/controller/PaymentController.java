package com.github.study.springcloud.controller;

import com.github.study.springcloud.entities.CommonResult;
import com.github.study.springcloud.entities.Payment;
import com.github.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/4/14 0014
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int i = service.create(payment);
        log.info("*****插入" + payment);
        if (i > 0) {
            return new CommonResult<>(200, "插入数据成功-->port" + serverPort, payment);
        } else {

            return new CommonResult<>(400, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = service.getPaymentById(id);
        log.info("*****查询" + id);
        if (paymentById != null) {
            return new CommonResult<>(200, "查询数据成功--->port" + serverPort, paymentById);
        } else {
            return new CommonResult<>(400, "插入数据失败,没有id=" + id, null);
        }
    }

    @RequestMapping("/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service----->" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("--->" + instance.getUri());
        }
        return discoveryClient;
    }
}
