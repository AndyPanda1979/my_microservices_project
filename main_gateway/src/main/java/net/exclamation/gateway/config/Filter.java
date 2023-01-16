package net.exclamation.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Filter implements GatewayFilter {

    Logger logger = Logger.getLogger(Filter.class.getName());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        logger.log(Level.INFO, "Request data: cookies - {0}, {1}", new Object[] {
                request.getCookies().toString(), Objects.requireNonNull(request.getLocalAddress()).toString()});

        if (request.getCookies().containsKey("spring-cloud-sample")) {
            System.out.println("remove header");
            System.out.println("IN: " + request.getHeaders());
            request.mutate().headers(httpHeaders->httpHeaders.remove("spring-cloud-sample"));
            System.out.println("OUT: " + request.getHeaders());
            return chain.filter(exchange);
        }
        return onError(exchange);
    }

    private Mono<Void> onError (ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.FORBIDDEN);

        ResponseCookie.ResponseCookieBuilder responseCookieBuilder = ResponseCookie.from("error", "forbidden");
        ResponseCookie responseCookie = responseCookieBuilder.build();
        response.addCookie(responseCookie);

        return response.setComplete();
    }
}
