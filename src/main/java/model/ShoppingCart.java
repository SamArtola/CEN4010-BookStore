package model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document
@Data
public class ShoppingCart extends Book{


    private String userId;
    private ArrayList<Book> shoppingCart;



    public ShoppingCart( String userId, ArrayList<Book> shoppingCart) {
        this.userId = userId;
        this.shoppingCart = shoppingCart;
    }

}
