/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.demo.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 API配置
 * @author geYang
 * @date 2018-05-11
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        System.out.println("======  SWAGGER CONFIG  ======");
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Fast 疾速开发  RESTful APIs")
                .description("快速上手,快速开发,快速交接")
                .contact(new Contact("geYang", "https://my.oschina.net/u/3681868/home", "572119197@qq.com"))
                .version("1.0.0")
                .build();
    }

}