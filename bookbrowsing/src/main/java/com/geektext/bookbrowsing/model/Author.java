package com.geektext.bookbrowsing.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Authors")
public class Author {
    @Id
    private ObjectId ID;
    private String first_name;
    private String last_name;
    private String biography;
    private String publisher;

    public Author(ObjectId ID,String first_name,String last_name, String biography,String publisher){
       super();
       this.ID=ID;
       this.first_name=first_name;
       this.last_name=last_name;
       this.biography=biography;
       this.publisher=publisher;

    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getBiography() {
        return biography;
    }

    public ObjectId getID() {
        return ID;
    }
}
