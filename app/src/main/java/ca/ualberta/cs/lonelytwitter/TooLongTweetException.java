package ca.ualberta.cs.lonelytwitter;

public class TooLongTweetException extends Exception {
    TooLongTweetException(){
        super("Message is too long.");
    }
}
