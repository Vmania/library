package pl.umk.mat.library.borrowing;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    List<Borrowing> getBorrowingsById(Long id);
    List<Borrowing> getBorrowingsByUserId(long id);
    Borrowing findBorrowingById(Long id);
}
