package pl.umk.mat.library.book;


import org.springframework.web.bind.annotation.*;
import pl.umk.mat.library.author.AuthorRepository;
import pl.umk.mat.library.publisher.PublisherRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    final private BookRepository bookRepository;
    final private AuthorRepository authorRepository;
    final private PublisherRepository publisherRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @PostMapping
    public Book addBook(@RequestBody BookAddRequest bookAddRequest) {
        Book book = new Book(
                bookAddRequest.getTitle(),
                authorRepository.findAuthorById(bookAddRequest.getAuthorId()),
                publisherRepository.getPublishersById(bookAddRequest.getPublisherId())
        );
        return bookRepository.save(book);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/publisher")
    public List<Book> getBooksByPublisher(String publisher) {
        return bookRepository.getBooksByPublisher_NameLike("%" + publisher + "%");
    }

    @GetMapping("/author")
    public List<Book> getBooksByAuthor(String lastName) {
        return bookRepository.getBooksByAuthor_LastNameLike("%" + lastName + "%");
    }

    @GetMapping("/title")
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.getBooksByTitleLike("%" + title + "%");
    }


}
