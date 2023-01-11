package net.exclamation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Микросервис клиента
 * Идет через Eureka Server в book-service (Feign и RestTemplate)
 *
 */

@SpringBootApplication
@EnableDiscoveryClient

public class ClientServiceApp
{
    public static void main( String[] args )
    {

        SpringApplication.run(ClientServiceApp.class, args);
    }

    @Bean
    public ApplicationRunner applicationStartupRunner() {
        return new ApplicationRunner();
    }
}
