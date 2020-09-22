package com.it.security.distributed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/9/21 19:18
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServer {
    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class, args);
    }
}
