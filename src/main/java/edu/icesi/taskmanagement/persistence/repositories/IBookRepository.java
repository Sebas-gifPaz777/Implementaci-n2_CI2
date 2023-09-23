package edu.icesi.taskmanagement.persistence.repositories;
import java.util.List;
import  java.util.Optional;

import edu.icesi.taskmanagement.persistence.models.Book;

public interface IBookRepository {
    public List<Book> listBooks();

    public Optional<Book> findBookById(Long id);

    public void addBook(Book book);

    public void updateBook(Book updatedBook);
    public void deleteBook(Long id);
}
