package net.exclamation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * OpenFeignApp _ B
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TestFeignClientApp_B
{
    public static void main( String[] args )
    {
        SpringApplication.run(TestFeignClientApp_B.class, args);
    }
}
