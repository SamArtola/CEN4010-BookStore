package cen4010.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}



/*
@SpringBootApplication
@EnableMongoRepositories
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	ReaderRepository readerRepo;

	@Autowired
	BookRepository bookRepo;

	@Autowired
	PublisherRepository publisherRepo;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		publisherRepo.deleteAll();
		bookRepo.deleteAll();

		Publisher p1 = publisherRepo.save(new Publisher("Springer", 0.0, new ArrayList<>()));

		publisherRepo.findAll().forEach(System.out::println);
//     public Book(Double AVG_Rating, Integer copiesSoled, String description, String ISBN, Double price, Publisher publisher, String title, String yearPublished) {
		Book b1 = bookRepo.save(new Book(4.6, 24, "Programming", "12-10-4321", 65.9, p1, "Software Engineering", "2018"));

		p1.getBooks().add(b1);
		publisherRepo.save(p1);
//		readerRepository.deleteAll();
//		readerRepository.save(new Reader("AlexN"));
//
//		for (Reader reader : readerRepository.findAll()) {
//			System.out.println(reader);
//		}
	}
}
*/