package net.exclamation.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @Value("${message}")
    private String testMessage;

    @GetMapping("/get_test_message")
    public String getTestMessage() {
        return testMessage;
    }
}
