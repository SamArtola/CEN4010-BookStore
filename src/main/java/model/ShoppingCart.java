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
public class ShoppingCart extends Books{


    private String userId;
    private ArrayList<Books> shoppingCart;



    public ShoppingCart( String userId, ArrayList<Books> shoppingCart) {
        this.userId = userId;
        this.shoppingCart = shoppingCart;
    }

}
