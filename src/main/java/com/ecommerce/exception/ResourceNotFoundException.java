package com.ecommerce.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resource;
    private String id;
    private long value;

    public ResourceNotFoundException(String resource, String id, long value) {
        super(String.format("%s not found for %s : '%s'", resource, id, value));
        this.resource = resource;
        this.id = id;
        this.value = value;
    }

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public long getValue() {
        return value;
    }

    @Configuration
    @EnableSwagger2
    public static class SwaggerConfiguration implements WebMvcConfigurer {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis((RequestHandlerSelectors.basePackage("com.dws.api")))
                    .build();
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //enabling swagger-ui part for visual documentation
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }
}
