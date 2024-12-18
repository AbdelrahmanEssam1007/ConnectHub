package backend.content;

public class Like {
    private String authorID;

    public Like(){};

    public Like(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

}
