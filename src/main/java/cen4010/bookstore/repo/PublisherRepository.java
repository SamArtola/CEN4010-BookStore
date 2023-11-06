package cen4010.bookstore.repo;

import cen4010.bookstore.model.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepository  extends MongoRepository<Publisher, String> {

    Publisher findPublisherByName(String name);
}
