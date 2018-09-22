package ca.ualberta.cs.lonelytwitter;

import java.util.Calendar;
import java.util.Date;

public class Happy extends Mood {


    public Happy(Date date) {
        this.date = date;
    }

    public Happy(){
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
        return "Happy";
    }
}
