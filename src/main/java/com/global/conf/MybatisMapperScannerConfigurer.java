package com.global.conf;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis扫描mapper接口工具类
 * Created by 白超 on 2017-12-17.
 */
@Configuration
//TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter
public class MybatisMapperScannerConfigurer {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        /*配置扫描包开始*/
        mapperScannerConfigurer.setBasePackage("com.svf.**.mapper");
        /*配置扫描包结束*/
        return mapperScannerConfigurer;
    }
}
