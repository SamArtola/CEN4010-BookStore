package cen4010.bookstore.repo;

import cen4010.bookstore.model.Author;
import cen4010.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> findBookByISBN(String isbn);

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByAuthorId(String id);

    List<Book> findBooksByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);

    List<Book> findByGenresIn(List<String> genres);

    List<Book> findByPublisher(String publisher);

    List<Book> findByAVGRatingGreaterThanEqual(double AVG_Rating);

    Page<Book> findTop10ByOrderByCopiesSoldDesc(Pageable pageable);
    Page<Book> findTop10RatedByGenresInOrderByAVGRatingDesc(List<String> genres,Pageable pageable);
}
