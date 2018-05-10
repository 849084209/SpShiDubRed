/*
 * @(#) SwaggerConfig.java
 * @Author:xinyz(xinyz@usky.com.cn) 2017/5/18
 * @Copyright (c) 2002-2017 usky.com Limited. All rights reserved.
 */
package com.wilmar.tms.web.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
  * @author 李博文
  * @version 1.0
  * @Function Swagger配置
  */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    /**
      * api(swagger bean配置)
      * @return bean
      */
    @Bean
    public Docket api() {
    	return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any())	//controller路径
				.paths(PathSelectors.regex("/api/.*")).build()
		        .apiInfo(apiInfo());
    }

    /**
      * apiInfo(api信息配置)
      * @return api信息
      */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("tms-web-portal")
        		.description("测试")
        		.version("V1.0")
        		.termsOfServiceUrl("http://terms-of-services.url")
                .license("LICENSE")
                .licenseUrl("http://url-to-license.com")
                .build();
    }
}
