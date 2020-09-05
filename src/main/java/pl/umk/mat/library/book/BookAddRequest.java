package pl.umk.mat.library.book;

public class BookAddRequest {
    private String title;
    private Long authorId;
    private Long publisherId;

    public BookAddRequest(String title, Long authorId, Long publisherId) {
        this.title = title;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

    public BookAddRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
}
