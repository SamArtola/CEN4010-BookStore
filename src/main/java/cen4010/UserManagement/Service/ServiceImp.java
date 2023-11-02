package cen4010.UserManagement.Service;

import cen4010.UserManagement.Model.CreditCard;
import cen4010.UserManagement.Model.UserCreation;
import cen4010.UserManagement.Repository.CreditCardRepo;
import cen4010.UserManagement.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceImp implements UserService {


   @Autowired
   private UserRepo userRepo;

   @Autowired
   private CreditCardRepo creditCardRepo;


   @Override
    public UserCreation saveUser(UserCreation userCreation) {
        return userRepo.save(userCreation);
    }

    @Override
    public List<UserCreation> fetchUsername() {
        return (List<UserCreation>)
                userRepo.findAll();
    }

    @Override
    public UserCreation updateUser(UserCreation userCreation, Long UserId) {
        Optional<UserCreation> optionalUser = userRepo.findById(UserId);
        if (optionalUser.isPresent()) {
            UserCreation existingUser = optionalUser.get();

            // Update user fields
            existingUser.setUserName(userCreation.getUserName());
            existingUser.setPassword(userCreation.getPassword());
            // Update other fields as needed

            // Save the updated user
            return userRepo.save(existingUser);
        } else {
            // User not found
            return null;
        }
    }

    @Override
    @Transactional
    public CreditCard createCC(String username, String password, CreditCard creditCard) {
        // Check if the user with the provided username and password exists
        Optional<UserCreation> user = userRepo.findByUserNameAndPassword(username,password);

        if(user.isPresent()){

            UserCreation userOptional = user.get();
            // set the user ID in the credit card
           creditCard.setUserId(userOptional.getUserName());

           // assign credit card to user
            userOptional.setCreditCard(creditCard);

            // save credit card entity to database
            creditCardRepo.save(creditCard);

            // save the user with updated CC
            userRepo.save(userOptional);
            return creditCard;
        }
        else{
            throw new IllegalArgumentException("Invalid username or password");
        }
    }


}
