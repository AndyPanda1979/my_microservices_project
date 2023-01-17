package net.exclamation.publishers;

import net.exclamation.events.BookCreationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BookCreationEventPublisher {

    final
    ApplicationEventPublisher applicationEventPublisher;

    public BookCreationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(final String title) {
        applicationEventPublisher.publishEvent(new BookCreationEvent(title));
    }
}
