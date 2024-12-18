package backend.chat;

import backend.groups.Group;
import utils.FileNames;
import utils.JSONFileReader;
import utils.JSONFileWriter;

import java.util.ArrayList;
import java.util.List;

public class ChatDB {

  List<Message> messages;
  private static final ChatDB CHATDB = new ChatDB();

  ChatDB() {
    messages = new ArrayList<>();
    readFromDB();
  }

  public static ChatDB getInstance() {
    return CHATDB;
  }

  public void readFromDB(){
    try {
      messages.clear();
      List<Message> allMessages = JSONFileReader.readJson(FileNames.MESSAGES.getFileName(), Message.class);
      messages.addAll(allMessages);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void saveToDB(){
    try {
      JSONFileWriter.writeJson(FileNames.MESSAGES.getFileName(), messages);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void createMessage(String senderID, String recepientID, String messageContent) {
    Message message = new Message(messageContent, senderID, recepientID);
    messages.add(message);
    saveToDB();
  }

  public void deleteGroup(String messageID) {
    Message messageToDelete = searchMessageByID(messageID);
    messages.remove(messageToDelete);
    saveToDB();
  }

  public Message searchMessageByID(String messageID) {
    for (Message message : messages) {
      if (message.getMessageID().equals(messageID)) {
        return message;
      }
    }
    return null;
  }

  public ArrayList<Message> getMessages() {
    return new ArrayList<>(messages);
  }

}
