package edu.icesi.taskmanagement.services;

import edu.icesi.taskmanagement.persistence.models.Book;



import java.util.List;
import java.util.Optional;

public interface IBookService {

        public List<Book> listBooks();

        public Optional<Book> findBookById(Long id);

        public void createBook(Book book);

        public void updateBook(Book updatedBook);

        public void deleteBook(Long id);
}
