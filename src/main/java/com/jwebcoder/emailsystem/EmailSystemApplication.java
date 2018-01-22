package com.jwebcoder.emailsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jwebcoder.emailsystem.dao")
@EnableJms
public class EmailSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSystemApplication.class, args);
	}
}
