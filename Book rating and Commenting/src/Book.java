import java.util.*;

class Book {
    private String name;
    private double rating;
    private String comment;
    private Date timestamp;

    public Book(String name) {
        this.name = name;
    }

    public void addRating(double rating) {
        this.rating = rating;
    }

    public void addComment(String comment) {
        this.comment = comment;
    }

    public void addTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String toString() {
        return "Name: " + name + " Rating: " + rating + " Comment: " + comment + " Timestamp: " + timestamp;
    }
}



