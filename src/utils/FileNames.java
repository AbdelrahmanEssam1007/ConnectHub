package utils;

public enum FileNames {
    USERS("Users_DB.json"),
    POSTS("posts.json"),
    STORIES("stories.json");

    private final String fileName;

    FileNames(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
