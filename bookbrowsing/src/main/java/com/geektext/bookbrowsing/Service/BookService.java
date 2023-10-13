package com.geektext.bookbrowsing.Service;

import com.geektext.bookbrowsing.model.Book;
import com.geektext.bookbrowsing.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

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
}
