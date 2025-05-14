package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        SpringDocUtils.getConfig().replaceWithSchema(MultipartFile.class,
                new Schema<MultipartFile>()
                        .type("string")
                        .format("binary"));

        return new OpenAPI()
                .info(new Info()
                        .title("Number Finder API")
                        .version("1.0")
                        .description("API для поиска N-ного минимального числа в XLSX файле"));
    }
}