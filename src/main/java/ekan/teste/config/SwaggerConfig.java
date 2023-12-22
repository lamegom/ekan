package ekan.teste.config;


import static java.util.Collections.emptyList;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        Docket docket;

        docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        
            docket.globalOperationParameters(
                    Arrays.asList(
                    new ParameterBuilder().name("Authorization")
                            .description("Authorization details for security (JWT token or BasicAuth)")
                            .modelRef(new ModelRef("String")).parameterType("header").required(false).build())); 
            
            return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "MyApp REST API",
                "MyApp REST API",
                "1.0",
                "Terms of service",
                new Contact("MyAppDevTeam", "http://myapp.com", "support@myapp.com"),
                "License of API", "API license URL", emptyList());
    }
}
