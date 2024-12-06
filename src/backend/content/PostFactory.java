package backend.content;

import backend.User;
import utils.IDGenerator;

import java.time.LocalDateTime;

public class PostFactory extends ContentFactory{
    @Override
    public Content createContent(ContentData contentData, User user) {
        return new Post(
                contentData,
                LocalDateTime.now(),
                IDGenerator.generateUserId(),
                user.getUserId(),
                user.getUserName()
        );
    }
}
