package pl.umk.mat.library.borrowing;

public class BorrowingAddRequest {

    private Long userId;
    private Long bookId;

    public BorrowingAddRequest(long userId, long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public BorrowingAddRequest() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
