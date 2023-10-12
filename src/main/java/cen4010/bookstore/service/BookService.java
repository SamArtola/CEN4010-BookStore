package cen4010.bookstore.service;

import cen4010.bookstore.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookByISBN(String isbn);
}
