package org.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.crm.mapper")
public class ApplicationSale {
    public static void main(String[] args){
        SpringApplication.run(ApplicationSale.class,args);
    }
}
