package com.stu.springloadbalanced;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableApolloConfig
@EnableEurekaServer
@SpringBootApplication
public class SpringLoadBalancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLoadBalancedApplication.class, args);
    }

}
