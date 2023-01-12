package net.exclamation.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.exclamation.feign.BookServiceConnector;
import net.exclamation.models.Book;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ClientService {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    RestTemplate restTemplate;

    Logger logger = Logger.getLogger(ClientService.class.getName());

    private final BookServiceConnector bookServiceConnector;

    public ClientService(@Lazy RestTemplate restTemplate, BookServiceConnector bookServiceConnector) {
        // @Lazy добавлена для разрешения циклических ссылок
        // Можно попробовать RestTemplate получить как @Bean в ClientServiceApp
        this.restTemplate = restTemplate;
        this.bookServiceConnector = bookServiceConnector;
    }


    public List<Book> getAllBooksList() {

        return bookServiceConnector.getAllBooksList();
    }

    public String data() {
        String response = restTemplate.getForObject("http://localhost:8081/data", String.class);
        logger.log(Level.INFO, response);
        return response;
    }


}
