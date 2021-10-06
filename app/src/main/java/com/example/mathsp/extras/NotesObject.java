package com.example.mathsp.extras;

public class NotesObject {
    private String date;
    private String topic;
    private String details;

    public NotesObject(String date, String topic, String details) {
        this.date = date;
        this.topic = topic;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
