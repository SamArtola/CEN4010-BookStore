package cen4010.bookstore.service;

import cen4010.bookstore.model.Author;
import cen4010.bookstore.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookByISBN(String isbn);

    Book saveBook(Book book);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByAuthorId(String id);

    List<Book> getBooksByAuthorFullName(String firstName, String lastName);
}
