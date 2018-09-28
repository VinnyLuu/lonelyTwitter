package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Tweet implements Tweetable {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    //No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public Boolean isImportant() {
        return false;
    }

    public String toString() {
        return this.date.toString() + " | " + this.message;
    }
}
