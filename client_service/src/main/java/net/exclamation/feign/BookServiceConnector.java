package net.exclamation.feign;

import net.exclamation.config.FeignConfig;
import net.exclamation.models.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "book-service",
        configuration = FeignConfig.class,
        url = "${book-service.url}"
)

public interface BookServiceConnector {

    @GetMapping("/show")
    List<Book> getAllBooksList();
}
