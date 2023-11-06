package controller;

import model.ShoppingCart;
import model.Books;
import repo.ShoppingCartRepository;
import service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class ShoppingCartController {


    @Autowired
    private ShoppingCartService shoppingCartService;


    @Autowired
    private ShoppingCartRepository repository;


    @PostMapping("/createCart")
    public String saveShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.save(shoppingCart);
    }

    @PostMapping("/addBookToCart")
    public String addToCart(@RequestBody Books book) {
        return shoppingCartService.add(new Books());
    }


    @GetMapping("/allItems")
    public List<ShoppingCart> getAllItemsInCart() {
        return shoppingCartService.findAll();
    }

    @DeleteMapping("/deleteBook/{isbn}")
    public void delete(@PathVariable long isbn){
        shoppingCartService.delete(isbn);

    }

}
