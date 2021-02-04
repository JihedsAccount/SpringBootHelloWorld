package com.javainuse.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

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
 * https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/
 * 
 * http://localhost:8080/v2/api-docs
 * http://localhost:8080/swagger-ui.html
 *
 */
@Configuration
@EnableSwagger2
public class SpringFoxSwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    /**
     * https://www.javainuse.com/spring/boot_swagger
     */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SpringBootHelloWorld API")
				.description("SpringBootHelloWorld API reference for developers")
				.termsOfServiceUrl("http://springboothelloworld.com")
				.contact("springboothelloworld@gmail.com")
				.license("SpringBootHelloWorld License")
				.licenseUrl("springboothelloworld@gmail.com")
				.version("1.0").build();
	}
}