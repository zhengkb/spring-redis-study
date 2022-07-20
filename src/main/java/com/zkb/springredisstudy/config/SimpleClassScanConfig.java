package com.zkb.springredisstudy.config;

import com.zkb.springredisstudy.event.scan.SimpleClassScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleClassScanConfig {

    @Bean
    public SimpleClassScan simpleClassScan() {
        SimpleClassScan simpleClassScan = new SimpleClassScan();
        return simpleClassScan;
    }
}
