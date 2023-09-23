package edu.icesi.taskmanagement.controllers;

import edu.icesi.taskmanagement.persistence.models.Book;
import edu.icesi.taskmanagement.services.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listBook(Model model) {
        List<Book> books = bookService.listBooks();
        model.addAttribute("books", books);
        return "home"; // Name of the view
    }

    @GetMapping("/{id}")
    public String viewBookDetails(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findBookById(id);
        book.ifPresent(value -> model.addAttribute("book", value));
        return "details"; // Name of the view
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "create"; // Name of the view
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book) {
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findBookById(id);
        book.ifPresent(value -> model.addAttribute("book", value));
        return "edit"; // Name of the view
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute Book updatedBook) {
        updatedBook.setId(id);
        bookService.updateBook(updatedBook);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}
