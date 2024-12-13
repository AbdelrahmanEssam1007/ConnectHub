package utils;

public enum FileNames {
    USERS("Users_DB.json"),
    POSTS("posts.json"),
    STORIES("stories.json"),
    GROUP_POSTS("groups_posts.json"),
    GROUPS("groups.json");

    private final String fileName;

    FileNames(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return "databases/" + fileName;
    }
}
