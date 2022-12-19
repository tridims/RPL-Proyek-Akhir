package Model;

import java.util.*;

public class Review {
    private int score;
    private String description;
    private Date datetime;
    private int duration;

    public static void displayReview(CoworkingSpace space) {
        HashMap<User,Review> user = space.getUserReviews();
        user.forEach((key, value) -> {
            System.out.println("Ditulis oleh: " + key.getName());
            System.out.println("Tanggal: " + value.getDatetime());
            System.out.println("Durasi: " + value.getDuration());
            System.out.println("Rating: " + value.getScore());
            System.out.println("Ulasan: " + value.getDescription());
            System.out.println();
        });
    }

    public static Review createReview(int score, String description, Date datetime, int duration) {
        return new Review(score, description, datetime, duration);
    }

    public String getReview() {
        return description;
    }

    public Review(int score, String description, Date datetime, int duration) {
        this.score = score;
        this.description = description;
        this.datetime = datetime;
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public String getDescription(){
        return description;
    }

    public Date getDatetime(){
        return datetime;
    }

    public int getDuration(){
        return duration;
    }
}
