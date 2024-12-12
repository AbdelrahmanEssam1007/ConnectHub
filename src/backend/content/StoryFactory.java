package backend.content;

import backend.User;
import backend.groups.Group;
import utils.IDGenerator;

import java.time.LocalDateTime;

public class StoryFactory extends ContentFactory{
    @Override
    public Content createContent(ContentData contentData, User user, Group group) {
        String groupID = null;
        if(group != null)  groupID = group.getGroupID();
        return new Story(
                contentData,
                LocalDateTime.now(),
                IDGenerator.generateUserId(),
                user.getUserId(),
                groupID,
                user.getUserName()
        );
    }
}
