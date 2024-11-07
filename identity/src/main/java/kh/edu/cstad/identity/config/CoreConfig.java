package kh.edu.cstad.identity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CoreConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow CORS on all paths
                .allowedOrigins("http://localhost:3000") // Allow only requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true);
    }
}
