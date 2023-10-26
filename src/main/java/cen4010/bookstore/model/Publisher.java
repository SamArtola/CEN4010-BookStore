package cen4010.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document("publisher")
@JsonIgnoreProperties(value = {"target", "source"})
public class Publisher {

    @Id
    private String id;

    private String name;

    private Double discount;

//    @DocumentReference(lazy = true)
//    @ReadOnlyProperty
    @DocumentReference(lazy = true)
    private List<Book> books;

    public Publisher() {
    }

    public Publisher(String name, Double discount, List<Book> books) {
        this.name = name;
        this.discount = discount;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                ", books=" + books +
                '}';
    }
}
