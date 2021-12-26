package com.testAOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class TpSpringAopApplication {
	public static void main(String[] args) {
		SpringApplication.run(TpSpringAopApplication.class, args);
	}

}
