package com.ls.vbuynet.service.consumer.site;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.ls.vbuynet", exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class VbuynetServiceConsumerSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(VbuynetServiceConsumerSiteApplication.class,args);
    }

}
