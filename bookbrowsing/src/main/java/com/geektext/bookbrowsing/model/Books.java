package com.geektext.bookbrowsing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Book")
public class Books {
    @Id
    private String id;
    private String title;
    private int quantity;
    private String genre;

    public Books(String id,String title,int quantity,String genre){
        super();
        this.id=id;
        this.title=title;
        this.quantity=quantity;
        this.genre=genre;
    }
}
