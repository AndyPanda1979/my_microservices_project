package net.exclamation.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "test-eureka-client-feign-B")
public interface TestServiceFeignClient {

    @GetMapping("/test/first")   // Смотри внимательно на адреса запросов в сервисах, они должны совпадать!!!
    String getFirstResult();
}
