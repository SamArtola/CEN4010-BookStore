package repo;

import model.Books;
import model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
    Books insert(Books book);
    List<ShoppingCart> findAll();
    Books deleteBookByIsbn(long isbn);

}

