
package com.seguridad.seguridad.json;


public class MessageJson {
    
   private String topic;
   
   private Notification notification;
   
   private DataMessage data; 

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public DataMessage getData() {
        return data;
    }

    public void setData(DataMessage data) {
        this.data = data;
    }
   
   
    
}
