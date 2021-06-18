package com.haiya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderWebServiceApplication.class, args);
    }
}
