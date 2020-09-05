package pl.umk.mat.library.borrowing;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.umk.mat.library.book.Book;
import pl.umk.mat.library.book.BookRepository;
import pl.umk.mat.library.user.UserRepository;

import java.util.List;

@RestController
        @RequestMapping("/borrowings")
public class BorrowingController {

    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BorrowingController(BorrowingRepository borrowingRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }
    @PostMapping
    public Borrowing addBorrowing(@RequestBody BorrowingAddRequest borrowingAddRequest){
        Borrowing borrowing = new Borrowing(
            bookRepository.getBooksById(borrowingAddRequest.getBookId()),
            userRepository.getUsersById(borrowingAddRequest.getUserId())
        );
        Book book = bookRepository.getBooksById(borrowing.getBook().getId());
        book.setBorrowed(true);
        borrowing.setBorrowed(true);
        return borrowingRepository.save(borrowing);

    }
    @Transactional
    @DeleteMapping
    public Borrowing returnBorrowing(Long id){
        Borrowing borrowing = borrowingRepository.findBorrowingById(id);
        Book book = bookRepository.getBooksById(borrowing.getBook().getId());
        book.setBorrowed(false);
        borrowing.setBorrowed(false);
        return borrowing;
    }


    @GetMapping("/id")
    public List<Borrowing> getBorrowingbyId(Long id) {
        return borrowingRepository.getBorrowingsById(id);
    }

    @GetMapping("/user")
    public List<Borrowing> getBorrowingByUserId(Long id) {
        return borrowingRepository.getBorrowingsByUserId(id);
    }


    @GetMapping("/all")
    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }
}
