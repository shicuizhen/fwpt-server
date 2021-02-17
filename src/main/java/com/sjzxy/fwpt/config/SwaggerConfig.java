package com.sjzxy.fwpt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @date 2020-11-23 09:42:34
 * @author scz
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.sjzxy.fwpt.controller")
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sjzxy.fwpt.controller"))
//                .apis(RequestHandlerSelectors.basePackage("com.sjzxy.fwpt"))
                //添加ApiOperiation注解的被扫描
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("sjzxy Bim RESTful API")
                .description("石家庄学院生活服务平台")
                .version("1.0")
                .build();
    }
}
