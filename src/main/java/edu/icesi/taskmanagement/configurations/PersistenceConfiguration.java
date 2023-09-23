package edu.icesi.taskmanagement.configurations;

import edu.icesi.taskmanagement.controllers.BookController;
import edu.icesi.taskmanagement.persistence.models.BeanA;
import edu.icesi.taskmanagement.persistence.models.BeanB;
import edu.icesi.taskmanagement.persistence.models.BeanC;
import edu.icesi.taskmanagement.persistence.repositories.impl.BookRepository;
import edu.icesi.taskmanagement.services.impl.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
//    @Bean
//    public ProjectRepositoryImpl projectRepositoryImpl(){
//        return  new ProjectRepositoryImpl();
//    }

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository());
    }

    @Bean
    public BookController bookController() {
        return new BookController(bookService());
    }
}
