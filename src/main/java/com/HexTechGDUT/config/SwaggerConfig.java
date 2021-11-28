package com.HexTechGDUT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author HexTechGDUT
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("All")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.HexTechGDUT.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket userDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("user")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }

    @Bean
    public Docket animalDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("animal")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/animal/**"))
                .build();
    }

    @Bean
    public Docket applicationDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("application")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/application/**"))
                .build();
    }

    @Bean
    public Docket commentDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("comment")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/animal/comment/**"))
                .build();
    }

    @Bean
    public Docket tipsDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("tips")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/tips/**"))
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfo(
                "HexTechGDUT API",
                "StrayAnimalsManagementSystem",
                "v1.0",
                "https://github.com/HexTechGDUT/StrayAnimalsManagementSystem",
                new Contact("HexTechGDUT", "https://github.com/HexTechGDUT/StrayAnimalsManagementSystem", ""),
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
