package com.julong.deanInquire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.julong.deanInquire.mapper")
@ComponentScan(basePackages={"com.julong.deanInquire.*"})
@EnableCaching
public class DeanInquiryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeanInquiryApplication.class, args);
    }

}
