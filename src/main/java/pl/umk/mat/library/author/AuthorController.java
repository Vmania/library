package pl.umk.mat.library.author;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/id")
    public Author getAuthorById(Long id) {
        return authorRepository.findAuthorById(id);
    }

    @GetMapping("/name")
    public List<Author> getAuthorByLastNameLike(String name) {
        return authorRepository.findAuthorsByLastNameLike("%"+name+"%");
    }

    @PostMapping
    public Author addAuthor(@RequestBody AuthorAddRequest authorAddRequest) {

        Author author = new Author(
                authorAddRequest.getFirstName(),
                authorAddRequest.getLastName()
        );
        return authorRepository.save(author);
    }


}
