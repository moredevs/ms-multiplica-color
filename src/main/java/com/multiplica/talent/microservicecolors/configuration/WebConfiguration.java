package com.multiplica.talent.microservicecolors.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private static final Set<String> DEFAULT_PRODUCES =
            new HashSet<String>(Arrays.asList("application/json",
                    "application/xml"));

    @Bean
    public Docket colorTalent() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.multiplica.talent.microservicecolors.controller"))
                .paths(regex("/api/v1.*"))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(metaData())
                .produces(DEFAULT_PRODUCES) ;
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Colors maintenance")
                .description("\"Spring Boot REST API for Colors maintenance\"")
                .version("1")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Paul Santibañez", "https://www.multiplicatalent.com/", "paul.santibanezdev@gmail.com"))
                .build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
}