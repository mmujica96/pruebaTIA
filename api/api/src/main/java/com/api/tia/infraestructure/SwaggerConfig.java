package com.api.tia.infraestructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Tia")
                        .description("API Tia")
                        .version("v1.0")
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#"))
                );
    }
}
