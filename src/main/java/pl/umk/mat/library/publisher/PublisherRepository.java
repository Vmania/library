package pl.umk.mat.library.publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> getPublishersByNameLike(String name);

    Publisher getPublishersById(Long id);

}
