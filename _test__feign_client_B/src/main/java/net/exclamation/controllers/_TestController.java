package net.exclamation.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class _TestController {

    static String resultString1 = "Got Result!!!";

    @GetMapping("/first")
    public String getFirstResult() {
        System.out.println("Вызван метод ./controllers/_TestController#getFirstResult() возможно из другого сервиса");
        return resultString1;
    }
}
