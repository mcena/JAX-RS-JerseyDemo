package com.mcena.jaxrsjerseydemo.service;



import com.mcena.jaxrsjerseydemo.database.DatabaseClass;
import com.mcena.jaxrsjerseydemo.exception.DataNotFoundException;
import com.mcena.jaxrsjerseydemo.model.Message;

import java.util.*;

public class MessageService {

    private Map<Long, Message> messageMap = DatabaseClass.getMessages();


    public MessageService() {

    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messageMap.values());
    }

    public Message getMessage(long id) {
        Message message = messageMap.get(id);
        if(message == null) {
            throw new DataNotFoundException("Message with id: " + id + " not found!");
        }
        return message;
    }

    public Message addMessage(Message message) {
         message.setId(messageMap.size() + 1);
         messageMap.put(message.getId(), message);
         return message;
    }

    public Message updateMessage(Message message) {
        if(messageMap.size() <= 0 ) {
            return null;
        }
        messageMap.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messageMap.remove(id);
    }

    // pagination and filtering
    public List<Message> getMessagesByYear(int year) {
        List<Message> filteredList = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        for(Message message : messageMap.values()) {
            calendar.setTime(message.getDateCreated());
            if(calendar.get(Calendar.YEAR) == year) {
                filteredList.add(message);
            }
        }
        return filteredList;
    }

    public List<Message> getMessagesPaginated(int start, int size) {
        ArrayList<Message> messageList = new ArrayList<>(messageMap.values());
        if(start + size > messageList.size()) {
            return new ArrayList<Message>();
        }
        return messageList.subList(start, start + size);
    }
}
