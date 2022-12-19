package Model;

import java.util.Date;

public class Review {
    private int score;
    private String description;
    private Date datetime;
    private int duration;

    public String getReview() {
        return description;
    }

    private static Review createReview(int score, String description, Date datetime, int duration) {
        return new Review(score, description, datetime, duration);
    }

    public Review(int score, String description, Date datetime, int duration) {
        this.score = score;
        this.description = description;
        this.datetime = datetime;
        this.duration = duration;
    }

    public void displayReview() {

    }
}
