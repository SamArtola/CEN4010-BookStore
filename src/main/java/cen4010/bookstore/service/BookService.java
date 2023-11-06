package cen4010.bookstore.service;

import cen4010.bookstore.model.Author;
import cen4010.bookstore.model.Book;
import com.geektext.bookbrowsing.model.Book;
import com.geektext.bookbrowsing.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    List<Book> getAllBooks();

    Book getBookByISBN(String isbn);

    Book saveBook(Book book);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByAuthorId(String id);

    List<Book> getBooksByAuthorFullName(String firstName, String lastName);

    public void applyDiscountByPublisher(String publisher,double discountPercent){
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books){
            double currentPrice=book.getPrice();
            double discountedPrice=currentPrice-(currentPrice*discountPercent/100);
            book.setPrice(discountedPrice);
            bookRepository.save(book);
        }
    }

    public List<Book> getBooksByGenre(List<String> genre){
        return bookRepository.findByGenresIn(genre);
    }

    public List<Book> getBooksByRating(double AVG_Rating){
        return bookRepository.findByAVGRatingGreaterThanEqual(AVG_Rating);
    }

    public List<Book> getTopBooksByGenre(List<String> genre){
        Pageable pageable = PageRequest.of(0,10);
        Page<Book> topBooks = bookRepository.findTop10RatedByGenresInOrderByAVGRatingDesc(genre,pageable);
        return topBooks.getContent();
    }

    public List<Book> getTop10BooksByCopiesSold(){
        PageRequest pageable = PageRequest.of(0,10);
        Page<Book> top10Books = bookRepository.findTop10ByOrderByCopiesSoldDesc(pageable);
        return top10Books.getContent();
    }
}
