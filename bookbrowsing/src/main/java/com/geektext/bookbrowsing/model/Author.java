package com.geektext.bookbrowsing.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Authors")
public class Author {
    @Id
    private String ID;
    private String first_name;
    private String last_name;
    private String biography;
    private String publisher;

}
