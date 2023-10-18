package com.geektext.bookbrowsing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.reflect.Array;
import java.util.List;

@Document(collection = "Books")
public class Book {
    @Id
    private String id;
    @Field("title")
    private String title;
    @Field("author")
    private String author;
    private String ISBN;
    private int copiesSold;
    @Field("genres")
    private List<String> genres;
    @Field("averageRating")
    private double AVGRating;
    private String description;
    private double price;
    @Field("yearPublished")
    private String yr_published;
    private String publisher;


    //    private <A> authors;
//    private List<C> comments;


    //    private <G> genres;


    public Book(String id, String ISBN,String title, String author, int copiesSold, List<String> genres, double AVGRating, String description, double price, String yr_published, String publisher){
        super();
        this.id=id;
        this.title=title;
        this.copiesSold=copiesSold;
        this.genres=genres;
        this.author=author;
        this.AVGRating=AVGRating;
        this.description=description;
        this.price=price;
        this.publisher=publisher;
        this.yr_published=yr_published;
        this.ISBN=ISBN;
    }

    public double getAVG_Rating() {
        return AVGRating;
    }

    public double getPrice() {
        return price;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getYr_published() {
        return yr_published;
    }

    public void setAVG_Rating(double AVG_Rating) {
        this.AVGRating = AVG_Rating;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYr_published(String yr_published) {
        this.yr_published = yr_published;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    }
