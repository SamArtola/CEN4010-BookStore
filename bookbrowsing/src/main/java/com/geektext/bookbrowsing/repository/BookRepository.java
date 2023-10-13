package com.geektext.bookbrowsing.repository;

import com.geektext.bookbrowsing.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    public Book findByTitle(String title);
    public List<Book> findByGenresIn(List<String> genres);

    List<Book> findByISBN(String ISBN);
    public List<Book> findByPublisher(String publisher);
}
