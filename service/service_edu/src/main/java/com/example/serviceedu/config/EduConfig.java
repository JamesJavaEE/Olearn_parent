package com.example.serviceedu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.serviceedu.mapper")
public class EduConfig {    //mapper配置类
    @Bean   //逻辑删除插件
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
