package net.exclamation;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Микросервис клиента
 * Идет через Eureka Server в book-service (Feign и RestTemplate)
 *
 */

//TODO попробовать реализовать возможность через RestTemplate получить вместо строки объекты
//TODO еще подключил вместо Hystrix Resilience4j, но пока темный лес...

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ClientServiceApp
{
    public static void main( String[] args )
    {

        SpringApplication.run(ClientServiceApp.class, args);
    }

    @Bean
    public CircuitBreaker getCircuitBreaker() {
        CircuitBreakerRegistry circuitBreakerRegistry
                = CircuitBreakerRegistry.ofDefaults();

        return circuitBreakerRegistry.circuitBreaker("circuit-breaker");
    }


    @Bean
    public ApplicationRunner applicationStartupRunner() {
        return new ApplicationRunner();
    }
}
