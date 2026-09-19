package backend.bookstore.web;

import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import backend.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
    private BookRepository repository;
    private CategoryRepository crepository;

    public BookController(BookRepository repository, CategoryRepository crepository) {
        this.repository = repository;
        this.crepository = crepository;
    }

    @RequestMapping(value = { "/", "/booklist" })
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }

    @GetMapping("/books")
    public @ResponseBody Iterable<Book> bookListRest() {
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId).orElse(null);
    }

}
