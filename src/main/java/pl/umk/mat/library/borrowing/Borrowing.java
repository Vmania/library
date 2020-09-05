package pl.umk.mat.library.borrowing;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Temporal;
import pl.umk.mat.library.author.Author;
import pl.umk.mat.library.book.Book;
import pl.umk.mat.library.publisher.Publisher;
import pl.umk.mat.library.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity

public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Date date = new Date();

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    @Column
    private boolean isBorrowed;

    public Borrowing(Book book, User user) {
        this.book = book;
        this.user = user;
    }



    public Borrowing() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
