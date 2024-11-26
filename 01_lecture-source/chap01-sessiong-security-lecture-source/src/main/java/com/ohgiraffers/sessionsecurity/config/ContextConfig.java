package com.ohgiraffers.sessionsecurity.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 어플리케이션을 config 폴더 안으로 옮겼기 때문에 ComponentScan으로 경로 지정
@ComponentScan("com.ohgiraffers.sessionsecurity")
// 빈들 스캔
@MapperScan(basePackages = "com.ohgiraffers.sessionsecurity", annotationClass = Mapper.class)
@Configuration
public class ContextConfig {
}
