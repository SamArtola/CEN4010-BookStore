package cen4010.bookstore.service;

import cen4010.bookstore.model.Author;
import cen4010.bookstore.model.Book;
import cen4010.bookstore.model.Publisher;
import cen4010.bookstore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookByISBN(String isbn);

    Book saveBook(Book book);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByAuthorId(String id);

    List<Book> getBooksByAuthorFullName(String firstName, String lastName);

    void applyDiscountByPublisher(Publisher publisher);

    List<Book> getBooksByGenre(List<String> genre);

    List<Book> getBooksByRating(double AVG_Rating);

    public List<Book> getTopBooksByGenre(List<String> genre);

    public List<Book> getTop10BooksByCopiesSold();
}
