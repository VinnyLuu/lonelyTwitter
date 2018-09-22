package ca.ualberta.cs.lonelytwitter;

import java.util.Calendar;
import java.util.Date;

public abstract class Mood {
    protected Date date;

    public Mood(Date date) {
        this.date = date;
    }

    public Mood(){
        Date date = Calendar.getInstance().getTime();
        this.date = date;
    }

    public abstract void setDate(Date date);

    public abstract Date getDate();

    public abstract String getMood();
}
