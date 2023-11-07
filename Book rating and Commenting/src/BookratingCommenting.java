import java.util.*;

class BookRatingCommenting {
    public static void main(String[] args) {
        Book book1 = new Book("Diary of a Wimpy Kid");
        book1.addRating(5);
        book1.addComment("Awesome book!");
        book1.addTimestamp(new Date());

        Book book2 = new Book("Dracula");
        book2.addRating(4);
        book2.addComment("Good book!");
        book2.addTimestamp(new Date());

        Book book3 = new Book(" The Lord of the Rings");
        book3.addRating(5);
        book3.addComment("Best book in the series!");
        book3.addTimestamp(new Date());

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Double.compare(b2.getRating(), b1.getRating());
            }
        });

        for (Book book : bookList) {
            System.out.println(book);
        }

        double totalRating = 0;
        for (Book book : bookList) {
            totalRating += book.getRating();
        }

        double averageRating = totalRating / bookList.size();
        System.out.println("Average rating: " + averageRating);
    }
}


