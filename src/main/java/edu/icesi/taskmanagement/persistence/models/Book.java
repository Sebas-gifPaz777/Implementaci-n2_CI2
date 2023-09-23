package edu.icesi.taskmanagement.persistence.models;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
@AllArgsConstructor
@Data
@NoArgsConstructor

public class Book {
    private Long id;
    private String name;
    private String publisher;
    private String author;
    private double price;
    private int quantity;

    public Book(Book book) {
        this(book.getId(), book.getName(), book.getAuthor(), book.getPublisher(),book.getPrice(), book.getQuantity());
    }

}
