package com.fzyue.controller;

import com.fzyue.entities.CommonResult;
import com.fzyue.entities.Payment;
import com.fzyue.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderOpenFeignController {

    @Resource
    public PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment)
    {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/feign-timeout")
    public String feignTimeout(){
        return paymentFeignService.feignTimeout();
    }
}
