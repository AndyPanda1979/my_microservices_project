package net.exclamation.mongoDB_sequnces;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class DatabaseSequence {

    @Id
    private String id;
    private long sequence;
}
