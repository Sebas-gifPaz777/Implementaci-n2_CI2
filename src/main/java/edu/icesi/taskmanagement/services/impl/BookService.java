package edu.icesi.taskmanagement.services.impl;

import edu.icesi.taskmanagement.persistence.models.Book;
import edu.icesi.taskmanagement.persistence.repositories.impl.BookRepository;
import edu.icesi.taskmanagement.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> listBooks() {
        return bookRepository.listBooks();
    }
    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findBookById(id);
    }
    @Override
    public void createBook(Book book) {
        bookRepository.addBook(book);
    }
    @Override
    public void updateBook(Book updatedBook) {
        bookRepository.updateBook(updatedBook);
    }
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }
}
