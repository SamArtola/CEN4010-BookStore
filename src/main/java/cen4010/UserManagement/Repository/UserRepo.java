package cen4010.UserManagement.Repository;

import cen4010.UserManagement.Model.UserCreation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<UserCreation, Long> {
    Optional<UserCreation> findByUserNameAndPassword(String username, String password);
}

