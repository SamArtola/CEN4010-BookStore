package cen4010.UserManagement.Repository;

import cen4010.UserManagement.Model.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditCardRepo extends MongoRepository<CreditCard, Long> {
}
