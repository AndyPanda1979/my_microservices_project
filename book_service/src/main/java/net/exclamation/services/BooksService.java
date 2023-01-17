package net.exclamation.services;

import net.exclamation.models.Book;
import net.exclamation.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAllBooks() {
//        Optional<Book> bookOptional = booksRepository.findById("3");
//        bookOptional.ifPresent(System.out::println);
        return booksRepository.findAll();
    }

    public Book findBookByID(Long id) {
        Optional<Book> bookOptional= booksRepository.findById(id);
        return bookOptional.orElse(null);
    }

    public void createBook(Book book) {
        booksRepository.save(book);
    }
}