package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {

    protected Date date;

    public abstract void setDate(Date date);

    public abstract Date getDate();

    public abstract String getMood();
}
