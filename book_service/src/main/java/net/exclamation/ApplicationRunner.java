package net.exclamation;

import net.exclamation.models.Book;
import net.exclamation.mongoDB_sequnces.SequenceGeneratorService;
import net.exclamation.repositories.BooksRepository;
import net.exclamation.repositories.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ApplicationRunner implements CommandLineRunner {
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private SequenceRepository sequenceRepository;
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void run(String...args) throws Exception {
        System.out.println("Try to save data...");
        booksRepository.deleteAll();
        sequenceRepository.deleteAll();
        booksRepository.save(new Book(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME), "Java", "OOP","http://infopulse-univer.com.ua/images/trenings/java.png"));
        booksRepository.save(new Book(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME), "Java", "Steram API","https://www.hdwallpaperslife.com/wp-content/uploads/2018/09/JAVA14-480x270.png"));
        booksRepository.save(new Book(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME), "Java", "Collections","https://i.ytimg.com/vi/oOOESCvGGcI/hqdefault.jpg"));
        booksRepository.save(new Book(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME), ".NET", "Basic","https://upload.wikimedia.org/wikipedia/commons/0/0e/Microsoft_.NET_logo.png"));
        booksRepository.save(new Book(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME), "C++", "Basic","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmgIz9Ug-MVzBQJMcgXedOXTqHWGmbSu5pPDivz8hrfo_GE0HZEA"));
        booksRepository.save(new Book(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME), "JavaScript", "Angular 8","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTg41zepuyHbew8bIsTYeKWJ9RYOnnV922lNa85-fQTVrKDG19K2w"));
        System.out.println("...end");
    }
}
