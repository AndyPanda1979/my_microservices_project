package net.exclamation.controllers;

import net.exclamation.models.Book;
import net.exclamation.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class BooksController {
    Logger logger = Logger.getLogger(BooksController.class.getName());

    private final Environment env;
    private final BooksService booksService;

    public BooksController(Environment env, BooksService booksService) {
        this.env = env;
        this.booksService = booksService;
    }

    @RequestMapping("/")
    public String home() {
        String home = "Book-Service running at port: " + env.getProperty("local.server.port");
        logger.info(home);
        return home;
    }

    @GetMapping(path = "/show")
    public List<Book> getAllBooksList() {
        logger.info("Get data from database (Feign Client on client-service side)");
        return booksService.findAllBooks();
    }

    @GetMapping("/data")
    public List<Book> data() {
        logger.info("Get data from database (RestTemplate on client-service side)");
        return booksService.findAllBooks();
    }
}
