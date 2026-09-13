package backend.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import backend.bookstore.domain.CategoryRepository;
import backend.bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {

			Category fantasy = new Category("Fantasy");
			Category programming = new Category("Programming");
			Category fiction = new Category("Fiction");

			crepository.save(fantasy);
			crepository.save(programming);
			crepository.save(fiction);

			repository.save(new Book(
					"The Hobbit",
					"J.R.R. Tolkien",
					1937,
					"9780261102217",
					29.90,
					fantasy));

			repository.save(new Book(
					"1984",
					"George Orwell",
					1949,
					"9780451524935",
					19.90,
					fiction));

			repository.save(new Book(
					"Clean Code",
					"Robert C. Martin",
					2008,
					"9780132350884",
					39.90,
					programming));
		};
	}

}
