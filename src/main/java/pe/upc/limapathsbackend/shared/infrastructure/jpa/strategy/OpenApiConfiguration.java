package pe.upc.limapathsbackend.shared.infrastructure.jpa.strategy;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI securityOpenAPI() {
        OpenAPI openAPI = new OpenAPI()
                .info(new Info()
                        .title("LimaPaths Backend API")
                        .description("API for managing LimaPaths platform functionalities")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("LimaPaths Documentation")
                        .url("https://limapaths.docs.github.io"));

        // Configuración del servidor para producción o desarrollo
        Server server = new Server();
        if (isProductionEnvironment()) {
            server.setUrl("https://limapaths-backend-production.up.railway.app"); // URL de producción
            server.setDescription("Production server");
        } else {
            server.setUrl("http://localhost:8080"); // URL local para desarrollo
            server.setDescription("Local development server");
        }

        openAPI.addServersItem(server);
        return openAPI;
    }
    private boolean isProductionEnvironment() {
        String railwayEnv = System.getenv("RAILWAY_ENVIRONMENT");
        return railwayEnv != null && !railwayEnv.isEmpty();
    }
}
