package backend.content;

import backend.User;

import java.time.LocalDateTime;

public class StoryFactory extends ContentFactory{
    @Override
    public Content createContent(ContentData contentData, User user) {
        return new Story(
                contentData,
                LocalDateTime.now(),
                "POSTIDTEST",
                user.getUserId(),
                user.getUserName()
        );
    }
}
