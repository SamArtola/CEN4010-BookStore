package cen4010.bookstore.controller;

import cen4010.bookstore.model.Author;
import cen4010.bookstore.model.Book;
import cen4010.bookstore.model.Publisher;
import cen4010.bookstore.repo.AuthorRepository;
import cen4010.bookstore.repo.PublisherRepository;
import cen4010.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherRepository pubRepo;

    @Autowired
    private AuthorRepository authorRepo;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        for (int i = 0; i < books.size(); i++) {
            books.get(i).setPublisher(null);
            books.get(i).setAuthor(null);
        }
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable String isbn) {
        Book book = bookService.getBookByISBN(isbn);
        if (book != null) {
            book.setAuthor(null);
            book.setPublisher(null);
            return ResponseEntity.ok().body(book);
        }
        else
            return ResponseEntity.ok().body(null);
    }

    @PostMapping("/books")
    public ResponseEntity<String> saveBook(@RequestBody Book book) {
        Publisher publisher = pubRepo.findPublisherByName(book.getPublisher().getName());
        if (publisher == null) {
            publisher = book.getPublisher();
            if (publisher.getDiscount() == null)
                publisher.setDiscount(0.0);
            publisher = pubRepo.save(publisher);
        }
        book.setPublisher(publisher);

        Author author = authorRepo.findAuthorByFirstNameAndLastName(book.getAuthor().getFirstName(), book.getAuthor().getLastName());
        if (author == null) {
            author = book.getAuthor();
            author = authorRepo.save(author);
        }
        book.setAuthor(author);
        book = bookService.saveBook(book);

        if (publisher.getBooks() == null)
            publisher.setBooks(new ArrayList<>());
        publisher.getBooks().add(book);
        publisher = pubRepo.save(publisher);

        if (author.getBooks() == null)
            author.setBooks(new ArrayList<>());
        author.getBooks().add(book);
        author = authorRepo.save(author);
        return ResponseEntity.ok().body(book.getId());
    }

    @GetMapping("/books/author")
    public ResponseEntity<List<Book>> getBooksByAuthor(
            @RequestParam(name="firstName") String firstName,
            @RequestParam(name="lastName") String lastName) {
        Author author = authorRepo.findAuthorByFirstNameAndLastName(firstName, lastName);
        List<Book> books;
        if (author != null) {
            System.out.println(author);
            books = bookService.getBooksByAuthorId(author.getId());
//            return ResponseEntity.ok().body(books);
            books.get(0).setPublisher(null);
            for (int i = 0; i < books.size(); i++) {
                books.get(i).setPublisher(null);
                books.get(i).setAuthor(null);
            }
            return ResponseEntity.ok().body(books);
        }
        else
            return ResponseEntity.ok().body(new ArrayList<>());
    }
}
