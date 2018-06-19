package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class Demo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
}
