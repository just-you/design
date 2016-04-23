package com.example.design.configuration;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * swagger 配置类
 * Created by lxh on 16/4/21.
 */
@Configuration
@EnableSwagger2
public class AppSwaggerUI {
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")      // user api
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(or(regex("/api/.*")))
                .build()
                .apiInfo(userApiInfo());
    }

    @Bean
    public Docket menuApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("menu")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(or(regex("/api/.*")))
                .build()
                .apiInfo(menuApiInfo());
    }

    private ApiInfo userApiInfo() {
        return new ApiInfo("User Rest API", "", "0.0.1", "", "lxh", "MIT", "ww");
    }

    private ApiInfo menuApiInfo() {
        return new ApiInfo("Menu Rest API", "", "0.0.1", "", "lxh", "", "");
    }

    private ApiInfo cookingApiInfo() {
        return new ApiInfo("Cooking Rest API", "", "0.0.1", "", "lxh", "", "");
    }

    private ApiInfo articleApiInfo() {
        return new ApiInfo("Cooking Rest API", "", "0.0.1", "", "lxh", "", "");
    }

    private ApiInfo commentApiInfo() {
        return new ApiInfo("Cooking Rest API", "", "0.0.1", "", "lxh", "", "");
    }

    private ApiInfo messageApiInfo() {
        return new ApiInfo("Cooking Rest API", "", "0.0.1", "", "lxh", "", "");
    }

    private ApiInfo shareApiInfo() {
        return new ApiInfo("Cooking Rest API", "", "0.0.1", "", "lxh", "", "");
    }

    private ApiInfo reportApiInfo() {
        return new ApiInfo("Cooking Rest API", "", "0.0.1", "", "lxh", "", "");
    }

}