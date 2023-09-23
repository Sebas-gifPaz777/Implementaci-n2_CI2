package edu.icesi.taskmanagement.persistence.repositories.impl;

import edu.icesi.taskmanagement.persistence.models.Book;
import edu.icesi.taskmanagement.persistence.repositories.IBookRepository;
import edu.icesi.taskmanagement.services.IBookService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository implements IBookRepository {
    private final List<Book> books = new ArrayList<>();
    private Long lastId = 0L;
    @Override
    public List<Book> listBooks() {
        return books;
    }
    @Override
    public Optional<Book> findBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }
    @Override
    public void addBook(Book book) {
        book.setId(++lastId);
        books.add(book);
    }
    @Override
    public void updateBook(Book updatedBook) {
        Optional<Book> existingBook = findBookById(updatedBook.getId());
        existingBook.ifPresent(book -> {
            book.setName(updatedBook.getName());
            book.setPublisher(updatedBook.getPublisher());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());
            book.setQuantity(updatedBook.getQuantity());
        });
    }
    @Override
    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
