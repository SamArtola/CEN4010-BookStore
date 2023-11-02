package cen4010.UserManagement.Controller;


import cen4010.UserManagement.Model.CreditCard;
import cen4010.UserManagement.Model.UserCreation;
import cen4010.UserManagement.Repository.CreditCardRepo;
import cen4010.UserManagement.Repository.UserRepo;
import cen4010.UserManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CreditCardRepo creditCardRepo;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/Users")
    public ResponseEntity<UserCreation> creationResponseEntity(@RequestBody UserCreation userCreation) {
        UserCreation newUser = userService.saveUser(userCreation);
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping("/usernames")
    public ResponseEntity<List<UserCreation>> getAllUser() {
        List<UserCreation> usernames = userService.fetchUsername();
        return new ResponseEntity<>(usernames, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserCreation> updateUser(@PathVariable Long userId, @RequestBody UserCreation updateUser) {
        UserCreation user = userService.updateUser(updateUser, userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @PostMapping("/Create-credit-card")
    public ResponseEntity<CreditCard> createCC(@RequestParam String username, @RequestParam String password,@RequestBody
                                                                                                CreditCard creditCard){
        CreditCard createdCard = userService.createCC(username,password, creditCard);
         return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }



}

