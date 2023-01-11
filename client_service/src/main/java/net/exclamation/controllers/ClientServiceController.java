package net.exclamation.controllers;


import net.exclamation.feign.BookServiceConnector;
import net.exclamation.models.Book;
import net.exclamation.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class ClientServiceController {

    Logger logger = Logger.getLogger(ClientServiceController.class.getCanonicalName());

    private final ClientService clientService;

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
        return clientService.data();
    }


}
