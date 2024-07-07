package net.opencode.practice.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Swagger MedicalCalculator - OpenAPI 3.0")
                        .description(
                                """
                                        This is a sample Medical Calculator Service Server based on the
                                        OpenAPI 3.0 specification.  You can find out more about Swagger at
                                        [https://swagger.io](https://swagger.io).  Some useful links: -
                                        [The Medical Calculator Service repository](https://github.com/RR1nat/OpenCode_2024)
                                        """
                        )
                        .termsOfService("http://swagger.io/terms/")
                        .version("1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .contact(new Contact()
                                .name("Rinat")
                                .email("raychicollabs@gmail.com"))
                ).servers(List.of(
                        new Server()
                                .url("http://localhost:8080/calculator")
                                .description("Dev service"),
                        new Server()
                                .url("http://localhost:8082/calculator")
                                .description("Test service"))
                );
    }
}