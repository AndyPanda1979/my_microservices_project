package net.exclamation.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "books")
public class Book {

    @Transient
    public static final String SEQUENCE_NAME = "books_sequence";

    @Id
    private long id;

    @NotBlank
    @Size(max = 10)
    private String title;

    private String description;
    private String imageLink;
}
