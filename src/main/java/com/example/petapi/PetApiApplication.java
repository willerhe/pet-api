package com.example.petapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.example.petapi.dao")
public class PetApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetApiApplication.class, args);
    }

}
