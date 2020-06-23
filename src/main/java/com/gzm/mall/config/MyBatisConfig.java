package com.gzm.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 *
 * @author gzm
 * @Date 2020/06/01 15:35
 */
@Configuration
@MapperScan({"com.gzm.mall.mbg.mapper","com.gzm.mall.dao"})
public class MyBatisConfig {

}
