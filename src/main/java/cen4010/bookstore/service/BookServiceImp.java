package cen4010.bookstore.service;

import cen4010.bookstore.exception.ResourceNotFoundException;
import cen4010.bookstore.model.Author;
import cen4010.bookstore.model.Book;
import cen4010.bookstore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImp implements BookService{

    @Autowired
    private BookRepository bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book getBookByISBN(String isbn) {
        Optional<Book> oBook = this.bookRepo.findBookByISBN(isbn);

        if (oBook.isPresent()) {
            return oBook.get();
        }
        else {
            throw new ResourceNotFoundException("Book Not Found by ISBN: " + isbn);
        }
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookRepo.findBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByAuthorFullName(String firstName, String lastName) {
        return bookRepo.findBooksByAuthorFirstNameAndAuthorLastName(firstName, lastName);
    }

    @Override
    public List<Book> getBooksByAuthorId(String id) {
        return bookRepo.findBooksByAuthorId(id);
    }
}
