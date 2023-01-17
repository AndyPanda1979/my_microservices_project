package net.exclamation.listeners;

import net.exclamation.events.BookCreationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookCreationEventListener {

    @EventListener
    public void handleBookCreationEvent(BookCreationEvent event) {
        System.out.println("Обрабатываем добавление новой книги");
        System.out.println(event.getTitle() + " добавлена");
    }
}
