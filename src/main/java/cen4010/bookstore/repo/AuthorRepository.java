package cen4010.bookstore.repo;

import cen4010.bookstore.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Author findAuthorByFirstNameAndLastName(String firstName, String lastName);
}
