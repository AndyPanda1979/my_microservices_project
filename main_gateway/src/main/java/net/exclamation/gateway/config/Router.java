package net.exclamation.gateway.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponents;

@Configuration
@AllArgsConstructor
public class Router {

    private final Filter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return  builder.routes()
                .route("client", r -> r.path("/api/client/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://client-service"))
                .build();
    }
}
