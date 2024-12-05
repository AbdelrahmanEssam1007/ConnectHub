package backend.content;

import backend.User;

import java.time.LocalDateTime;

public class PostFactory extends ContentFactory{
    @Override
    public Content createContent(ContentData contentData, User user) {
        return new Post(
                contentData,
                LocalDateTime.now(),
                "POSTIDTEST",
                user.getUserId(),
                user.getUserName()
        );
    }
}
