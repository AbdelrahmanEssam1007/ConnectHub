package backend.content;

public class Comment {
    private String text;
    private String commentId;
    private String authorId;

    public Comment(String text, String commentId, String authorId) {
        this.text = text;
        this.commentId = commentId;
        this.authorId = authorId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
