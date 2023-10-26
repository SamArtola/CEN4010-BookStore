package cen4010.bookstore.repo;

import cen4010.bookstore.model.Author;
import cen4010.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> findBookByISBN(String isbn);

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByAuthorId(String id);

    List<Book> findBooksByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);

}
