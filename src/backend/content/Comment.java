package backend.content;

public class Comment {
    private String text;
    private String commentId;
    private String authorId;

    public Comment(){};

    public Comment buildText(String text){
        this.text = text;
        return this;
    }

    public Comment buildCommentId(String commentId){
        this.commentId = commentId;
        return this;
    }

    public Comment buildAuthorID(String authorID){
        this.authorId = authorID;
        return this;
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
