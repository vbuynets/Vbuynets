package com.ls.vbuynet.service.consumer.discounts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.ls.vbuynet")
@ComponentScan(basePackages = "com.ls.vbuynet")
@MapperScan(basePackages = "com.ls.vbuynet.commons.mapper")
@EnableDiscoveryClient
public class VbuynetServiceConsumerDiscuntsApplication {
    public static void main(String[] args) {
        SpringApplication.run(VbuynetServiceConsumerDiscuntsApplication.class,args);
    }
}
