package cen4010.UserManagement.Service;


import cen4010.UserManagement.Model.UserCreation;
import cen4010.UserManagement.Model.CreditCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {
    // save user information
    UserCreation saveUser (UserCreation userCreation);

    // Retrieves Username from user

    List<UserCreation> fetchUsername();

    // updates User's info besides email
    UserCreation updateUser ( UserCreation userCreation, Long UserId);

    // create User's credit card and match it to user's profile

    CreditCard createCC (String username, String password, CreditCard creditCard);


}
