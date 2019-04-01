package com.zhangyue.mybatispluslearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.zhangyue.mybatispluslearning.mapper",
"com.zhangyue.mybatispluslearning.config","com.zhangyue.mybatispluslearning.controller",
"com.zhangyue.mybatispluslearning.service","com.zhangyue.mybatispluslearning"})
@EnableSwagger2
public class MybatispluslearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatispluslearningApplication.class, args);
	}

}
