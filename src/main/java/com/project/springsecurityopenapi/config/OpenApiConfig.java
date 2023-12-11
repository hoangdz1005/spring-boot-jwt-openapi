package com.project.springsecurityopenapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring JWT Auth API - OpenAPI 3.0")
                        .description("This is a project Spring Boot Security Using JWT to Authentication")
                        .termsOfService("")
                        .version("1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .email("api@swagger.io")));
    }
}
