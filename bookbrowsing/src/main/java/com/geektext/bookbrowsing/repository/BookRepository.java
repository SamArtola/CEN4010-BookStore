package com.geektext.bookbrowsing.repository;

import com.geektext.bookbrowsing.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    Book findByTitle(String title);
    List<Book> findByGenresIn(List<String> genres);

    List<Book> findByISBN(String ISBN);
    List<Book> findByPublisher(String publisher);

    List<Book> findByAVGRatingGreaterThanEqual(double AVG_Rating);

    Page<Book> findTop10ByOrderByCopiesSoldDesc(Pageable pageable);
    Page<Book> findTop10RatedByGenresInOrderByAVGRatingDesc(List<String> genres,Pageable pageable);
}
