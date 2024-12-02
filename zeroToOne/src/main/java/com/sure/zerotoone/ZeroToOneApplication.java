package com.sure.zerotoone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sure.zerotoone.mapper")
public class ZeroToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeroToOneApplication.class, args);
    }

}
