package com.stu.springloadbalanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringLoadBalancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoadBalancedApplication.class, args);
	}

}
