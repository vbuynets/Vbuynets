package com.ls.vbuynet.service.provider.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.ls.vbuynet")
@ComponentScan(basePackages = "com.ls.vbuynet")
@MapperScan(basePackages = "com.ls.vbuynet.commons.mapper")
@EnableDiscoveryClient
public class VbuynetServiceProviderOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(VbuynetServiceProviderOrderApplication.class,args);
    }
}
