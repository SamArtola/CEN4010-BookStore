package cen4010.bookstore.service;

import cen4010.bookstore.exception.ResourceNotFoundException;
import cen4010.bookstore.model.Author;
import cen4010.bookstore.model.Book;
import cen4010.bookstore.model.Publisher;
import cen4010.bookstore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return bookRepo.findAll();
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

    /*
    Sam Feature
    */
    public void applyDiscountByPublisher(Publisher publisher){
        List<Book> books = bookRepo.findByPublisher(publisher.getName());
        for (Book book : books){
            double currentPrice=book.getPrice();
            double discountedPrice=currentPrice-(currentPrice* publisher.getDiscount()/100);
            book.setPrice(discountedPrice);
            bookRepo.save(book);
        }
    }

    public List<Book> getBooksByGenre(List<String> genre){
        return bookRepo.findByGenresIn(genre);
    }

    public List<Book> getBooksByRating(double AVG_Rating){
        return bookRepo.findByAVGRatingGreaterThanEqual(AVG_Rating);
    }

    public List<Book> getTopBooksByGenre(List<String> genre){
        Pageable pageable = PageRequest.of(0,10);
        Page<Book> topBooks = bookRepo.findTop10RatedByGenresInOrderByAVGRatingDesc(genre,pageable);
        return topBooks.getContent();
    }

    public List<Book> getTop10BooksByCopiesSold(){
        PageRequest pageable = PageRequest.of(0,10);
        Page<Book> top10Books = bookRepo.findTop10ByOrderByCopiesSoldDesc(pageable);
        return top10Books.getContent();
    }
}
