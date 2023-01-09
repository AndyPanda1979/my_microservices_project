package net.exclamation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TestFeignClientApp_A
{
    public static void main( String[] args )
    {

        SpringApplication.run(TestFeignClientApp_A.class, args);
    }
}
