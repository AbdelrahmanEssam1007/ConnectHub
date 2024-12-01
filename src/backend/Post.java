package backend;

import java.time.LocalDateTime;

public class Post {
  private String contentId;
  private String authorId;
  private String contentText;
  private String contentImage;
  private LocalDateTime timeStamp;

}

class Story extends Post {
  private LocalDateTime expirationTimeStamp;
}
