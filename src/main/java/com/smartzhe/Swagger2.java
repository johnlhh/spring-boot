package com.smartzhe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by luohuahua on 17/9/3.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.smartzhe"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("关爱通--项目API")
                .description("这里集成了所有的关于订单的相关API，在这里你可以查阅每一个API的功能及其描述")
                .termsOfServiceUrl("http://www.jianshu.com/p/8033ef83a8ed")
                .contact("13817006323")
                .license("Copyright 2017 关爱通")
                .licenseUrl("http://www.apache.org/licenses/")
                .version("1.0")
                .build();
    }

}

