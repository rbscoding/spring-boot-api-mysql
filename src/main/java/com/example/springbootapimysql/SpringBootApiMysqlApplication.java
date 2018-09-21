package com.example.springbootapimysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootApiMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiMysqlApplication.class, args);
    }

}
