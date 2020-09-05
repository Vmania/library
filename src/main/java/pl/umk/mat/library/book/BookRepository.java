package pl.umk.mat.library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksByTitleLike(String title);

    List<Book> getBooksByAuthor_LastNameLike(String lastName);

    List<Book> getBooksByPublisher_NameLike(String name);

    Book getBooksById(Long id);

}
