package com.fiap.ds.smartmask.configuration;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class   SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .enable(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fiap.ds.smartmask.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
        private ApiInfo getApiInfo() {
            return new ApiInfoBuilder()
                    .title("Smartmask API")
                    .description("Documentation for Smartmask API")
                    .build();
        }
}
