package net.exclamation.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookCreationEvent {
    private String title;
}
