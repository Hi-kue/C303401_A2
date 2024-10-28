package com.hikue.bilal_301326791_c303a2.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server()
                .url("http://localhost:8080")
                .description("Development Documentation Route");

        Contact contact = new Contact()
                .name("Muhammad Bilal Khan")
                .email("mkhan719@my.centennialcollege.ca");

        Info info = new Info()
                .title("User CRUD API")
                .version("1.0.0")
                .description("API Intended to perform CRUD Operations for Users Database.")
                .contact(contact);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
