package com.example.demo.config;

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
 * @projectName: demo
 * @package: com.example.demo.config
 * @className: SwaggerConfig
 * @author: Vangogh
 * @description: 配置Swagger
 * @date: 2024/7/18 21:12
 * @version: 1.0
 */

@Configuration  //告诉springboot 这是一个配置类
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {

    //访问路径：http://localhost:8080/swagger-ui.html

    /**
     * 配置swagger2相关的bean
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))  //com包下面所有API交给Swagger2管理
                .paths(PathSelectors.any()).build();
    }

    /**
     * 主要是API文档页面显示信息
     * @return
     */
    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("演示项目API")  //标题
                .description("演示项目")  // 描述
                .version("1.0")  //版本
                .build();

    }

}
