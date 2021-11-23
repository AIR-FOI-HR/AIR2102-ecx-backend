package com.ecxfoi.wbl.wienerbergerbackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.function.Predicate;

@Configuration
public class SwaggerConfig
{
    @Bean
    public Docket apiDocket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicate.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo()
    {
        return new ApiInfo(
                "Wienerberger WBL",
                "Wienerberger WBL Project - ecx.io & FOI",
                "v0.0.1",
                "",
                new Contact("", "", ""),
                "",
                "",
                Collections.emptyList()
        );
    }
}