package com.fzyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerOrderApplicationOpenfeign {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplicationOpenfeign.class, args);
    }
}
