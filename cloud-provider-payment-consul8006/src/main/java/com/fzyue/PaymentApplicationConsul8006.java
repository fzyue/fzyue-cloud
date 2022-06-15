package com.fzyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplicationConsul8006
{
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentApplicationConsul8006.class, args);
    }
}
