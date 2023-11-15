package repo;

import model.ShoppingCart;
import model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
    Book insert(Book book);
    List<ShoppingCart> findAll();
    Book deleteBookByIsbn(long isbn);

}

