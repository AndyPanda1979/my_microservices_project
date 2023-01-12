package net.exclamation.controllers;


import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import net.exclamation.models.Book;
import net.exclamation.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import java.net.ConnectException;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class ClientServiceController {

    Logger logger = Logger.getLogger(ClientServiceController.class.getCanonicalName());

    private final ClientService clientService;
    @Autowired
    private CircuitBreaker circuitBreaker;

    public ClientServiceController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getAllBooksByFeignClient")
    public List<Book> getAllBooks() {
        List<Book> books = clientService.getAllBooksList();
        books.forEach(System.out::println);
        return books;
    }

    @GetMapping("/getAllBooksByRestTemplate")
    public String data() {
        try {
            Supplier<String> res = circuitBreaker.decorateSupplier(clientService::data);
            return res.get();
        } catch (ResourceAccessException e) {
            logger.log(Level.INFO, "unable access to the resource ({0})", e.getCause().getMessage());
            return "UNABLE TO GET DATA";
        }

    }


}
