package com.smartzhe;

import com.smartzhe.core.datasource.dynic.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by luohuahua on 17/8/4.
 *
 * Application的这个类需要放到顶层包的下面添加了
 * @SpringBootApplication可以扫描同级及以下的包的类的注解
 *
 * @EnableTransactionManagement这个注解用于启动注解式事务生效
 *
 * @Import 这个实现了注册动态多数据源的功能
 *
 * 继承SpringBootServletInitializer并重写方法configure用于tomcat启动Spring-boot项目
 */
@EnableTransactionManagement
@SpringBootApplication
@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
