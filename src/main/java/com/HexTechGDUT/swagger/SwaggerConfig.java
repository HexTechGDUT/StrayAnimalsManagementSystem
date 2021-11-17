package com.HexTechGDUT.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @author HexTechGDUT
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                //有空再分组
                .groupName("All")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.HexTechGDUT.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
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

    public Docket docketByController(String groupName, String controller){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                //有空再分组
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.HexTechGDUT.controller"))
                .paths(PathSelectors.regex("/"+controller+"/.*"))
                .build();
    }

    @Bean
    public Docket getUserDocket(){
        return docketByController("User", "user");
    }
}
