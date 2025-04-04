package in.ies.AR_API.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	
    @Bean
    public OpenAPI apiDoc() {
        return new OpenAPI()
                .info(new Info()
                    .title("IES Admin API")
                    .description("API documentation for Admin Module")
                    .version("1.0"));
    }


}
