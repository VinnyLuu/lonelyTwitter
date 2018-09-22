package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public String getMood() {
        return "Happy";
    }
}
