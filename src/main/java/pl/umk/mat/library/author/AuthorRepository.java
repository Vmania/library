package pl.umk.mat.library.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(Long id);
    List<Author> findAuthorsByLastNameLike(String name);
}
