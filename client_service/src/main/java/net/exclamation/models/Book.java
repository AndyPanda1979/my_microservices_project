package net.exclamation.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
@ToString
public class Book {
    @Id
    private long id;

    @NotBlank
    @Size(max = 10)
    private String title;

    private String description;
    private String imageLink;
}
