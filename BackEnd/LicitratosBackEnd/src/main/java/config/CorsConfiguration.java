package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Permite requisições de 'http://localhost:5173' (a porta padrão do Vite)
                registry.addMapping("/api/**") // Aplica a todos os endpoints
                        .allowedOrigins("localhost:5173/**") // O endereço do seu frontend Vite
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                        .allowedHeaders("Content-Type", "Authorization") // Permite todos os cabeçalhos
                        .allowCredentials(false); // Permite o envio de cookies/cabeçalhos de autenticação
            }
        };
    }
}