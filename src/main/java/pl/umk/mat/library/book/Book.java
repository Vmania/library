package pl.umk.mat.library.book;

import pl.umk.mat.library.author.Author;
import pl.umk.mat.library.publisher.Publisher;

import javax.persistence.*;

@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    @Column
    private boolean isBorrowed = false;


    public Book(String title, Author author, Publisher publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public Book() {
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public Book(String title, Author author, Publisher publisher, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isBorrowed = isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
