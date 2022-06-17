package com.fzyue.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixFallbackService  paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentHystrixFallbackService  paymentInfo_TimeOut";
    }
}
