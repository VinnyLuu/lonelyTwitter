package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet {
    protected String message;
    protected Date date;
    private ArrayList<Mood> moodList;

    public void setMessage(String message) throws TooLongTweetException {
        if (this.message.length()>140) {
            this.message = message;
        } else {
            throw new TooLongTweetException();
        }
    }

    public void addMood(Mood mood){
        this.moodList.add(mood);
    }

    public void setDate(Date date){
        this.date = date;

    }
    public String getMessage(){
        return this.message;

    }
    public Date getDate(){
        return this.date;

    }

    public abstract Boolean isImportant();

}
