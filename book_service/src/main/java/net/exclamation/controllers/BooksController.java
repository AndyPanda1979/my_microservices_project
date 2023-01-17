package net.exclamation.controllers;

import net.exclamation.models.Book;
import net.exclamation.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
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

    @GetMapping("/show/{id}")
    public Book getBookById(@PathVariable Long id) {
        logger.log(Level.INFO, "get book with id " + id);
        return booksService.findBookByID(id);
    }

        @PostMapping("/create")
    public String createBook(@RequestBody Book book) {
            System.out.println("CATCH CREATE BOOK");
            System.out.println(book);
            booksService.createBook(book);
//            return("forward:/show");
            return ("redirect:/show");

            //TODO Хотелось бы в результате сохранения новой книги, отдавать все, но пока не получилось...
        }
}
