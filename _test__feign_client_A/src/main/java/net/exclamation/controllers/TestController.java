package net.exclamation.controllers;

import net.exclamation.feign.TestServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test_for_B")
public class TestController {

    final
    TestServiceFeignClient testServiceFeignClient;

    public TestController(TestServiceFeignClient testServiceFeignClient) {
        this.testServiceFeignClient = testServiceFeignClient;
    }

    @GetMapping("/try_get_data_from_B")
    public String getDataFromB_viaFeignClient() {
        System.out.println("Вызываю через Feign метод из сервиса B (./controllers/TestController#getDataFromB_viaFeignClient())");
        return testServiceFeignClient.getFirstResult();
    }
}
