package net.exclamation.listeners;

import net.exclamation.models.Book;
import net.exclamation.mongoDB_sequnces.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

/**
 * Этот прослушиватель ловит события от mongoDB
 */

@Component
public class BookModelListener extends AbstractMongoEventListener<Book> {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        System.out.println("А чего, сработал BookModelListener");
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME));
        }
    }
}
