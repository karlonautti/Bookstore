package backend.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book(
                "The Hobbit",
                "J.R.R. Tolkien",
                1937,
                "9780261102217",
                29.90
            ));

            repository.save(new Book(
                "1984",
                "George Orwell",
                1949,
                "9780451524935",
                19.90
            ));

            repository.save(new Book(
                "Clean Code",
                "Robert C. Martin",
                2008,
                "9780132350884",
                39.90
            ));
		};
	}

}
