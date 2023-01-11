package net.exclamation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class TestController {

    Logger logger = Logger.getLogger(TestController.class.getCanonicalName());

    @GetMapping("/hello")
    public String sayHello() {
        logger.log(Level.INFO, "/hello endpoint invoked");
        return "HELLO";
    }
}
