package cen4010.bookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document("book")
//@JsonIgnoreProperties(value = {"target", "source"})
public class Book {

    @Id
    private String id;

    private Double AVG_Rating;
    @DocumentReference(lazy = true)
    private Author author;
//    private List<C> comments;
    private Integer copiesSoled;
    private String description;
//    private <G> genres;
    private String ISBN;
    private Double price;

//    @DocumentReference(lazy = true)
    @DocumentReference(lazy = true)
    private Publisher publisher;
    private String title;
    private String yearPublished;


    public Book() {
    }

    public Book(Double AVG_Rating, Integer copiesSoled, String description, String ISBN, Double price, Publisher publisher, String title, String yearPublished) {
        this.AVG_Rating = AVG_Rating;
        this.copiesSoled = copiesSoled;
        this.description = description;
        this.ISBN = ISBN;
        this.price = price;
        this.publisher = publisher;
        this.title = title;
        this.yearPublished = yearPublished;
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
        return AVG_Rating;
    }

    public void setAVG_Rating(Double AVG_Rating) {
        this.AVG_Rating = AVG_Rating;
    }

    public Integer getCopiesSoled() {
        return copiesSoled;
    }

    public void setCopiesSoled(Integer copiesSoled) {
        this.copiesSoled = copiesSoled;
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
