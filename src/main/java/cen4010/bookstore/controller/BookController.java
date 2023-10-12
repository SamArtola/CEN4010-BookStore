package cen4010.bookstore.controller;

import cen4010.bookstore.model.Book;
import cen4010.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable String isbn) {
        return ResponseEntity.ok().body(bookService.getBookByISBN(isbn));
    }
}
