package net.exclamation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class TestEurekaClientApp
{
    public static void main( String[] args )
    {

        SpringApplication.run(TestEurekaClientApp.class, args);
    }
}
