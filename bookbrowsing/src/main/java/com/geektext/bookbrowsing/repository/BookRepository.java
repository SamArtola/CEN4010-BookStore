package com.geektext.bookbrowsing.repository;

import com.geektext.bookbrowsing.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Books,String> {
    public Books findByTitle(String title);
    public List<Books> findByGenre(String genre);
}
