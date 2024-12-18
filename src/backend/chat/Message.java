package backend.chat;

import utils.IDGenerator;

import java.time.LocalDateTime;

public class Message {
    private String recepientID;
    private String senderID;
    private String textContent;
    private LocalDateTime creationTime;
    private String messageID;

    public Message(String textContent, String senderID, String recepientID) {
        this.textContent = textContent;
        this.senderID = senderID;
        this.recepientID = recepientID;
        this.creationTime = LocalDateTime.now();
        this.messageID = IDGenerator.generateUserId();
    }

    public String getRecepientID() {
        return recepientID;
    }

    public void setRecepientID(String recepientID) {
        this.recepientID = recepientID;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

}
