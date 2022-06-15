package com.fzyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderApplicationConsul {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplicationConsul.class, args);
    }
}
