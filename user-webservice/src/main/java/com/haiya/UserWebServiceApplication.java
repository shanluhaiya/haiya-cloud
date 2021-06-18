package com.haiya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserWebServiceApplication.class, args);
    }
}
