package ca.ualberta.cs.lonelytwitter;

import java.util.Calendar;
import java.util.Date;

public class Sad extends Mood {

    public Sad(Date date) {
        this.date = date;
    }

    public Sad(){
        Date date = Calendar.getInstance().getTime();
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public String getMood() {
        return "Sad";
    }
}
