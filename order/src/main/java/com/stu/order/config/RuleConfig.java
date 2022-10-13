package com.stu.order.config;

import com.netflix.loadbalancer.IRule;
import com.stu.order.rule.MyRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleConfig {

    @Bean
    public IRule ribbonRule() {
        return new MyRule();
    }
}
