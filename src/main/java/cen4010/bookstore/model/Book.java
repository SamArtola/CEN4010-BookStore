package cen4010.bookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Document("book")
//@JsonIgnoreProperties(value = {"target", "source"})
public class Book {

    @Id
    private String id;

    @Field("title")
    private String title;

    private int copiesSold;

    @Field("genres")
    private List<String> genres;

    @Field("averageRating")
    private double AVGRating;

    private String description;

    private double price;

    private String ISBN;

    @DocumentReference(lazy = true)
    private Author author;
//    @DocumentReference(lazy = true)
    @DocumentReference(lazy = true)
    private Publisher publisher;

    private String yearPublished;


    public Book(Double AVGRating, Integer copiesSold, String description, String ISBN, Double price, Publisher publisher, String title, String yearPublished, Author author,List<String> genres) {
        this.AVGRating = AVGRating;
        this.copiesSoled = copiesSold;
        this.description = description;
        this.ISBN = ISBN;
        this.price = price;
        this.publisher = publisher;
        this.author=author;
        this.title = title;
        this.yearPublished = yearPublished;
        this.genres=genres

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Double getAVG_Rating() {
        return AVGRating;
    }

    public void setAVGRating(Double AVGRating) {
        this.AVGRating = AVGRating;
    }

    public Integer getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(Integer copiesSold) {
        this.copiesSold = copiesSold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getGenres() {
        return genres;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publisher=" + publisher +
                ", title='" + title + '\'' +
                '}';
    }
}
