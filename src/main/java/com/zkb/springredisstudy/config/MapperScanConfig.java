package com.zkb.springredisstudy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = MapperScanConfig.PACKAGE)
public class MapperScanConfig {

    static final String PACKAGE = "com.zkb.springredisstudy.mapper";
}
