package utils;

public enum NotificationType {
    BLANK("BLANK"),
    GROUP_ACTIVITY("GROUP_ACTIVITY"),
    POST("POST"),
    STORY("STORY"),
    FRIEND_REQUEST("FRIEND_REQUEST");

    private final String type;

    NotificationType(String type){
        this.type = type;
    }

    public String getType(){ return type;}
}
