package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Reservation {
    private String id;
    private Date date;
    private int duration;
    private ArrayList<Room> listRoom;
    private String note;
    private ReservationStatus status;
    private User user;

    public Reservation(User user, Date date, int duration, ArrayList<Room> listRoom, String note, ReservationStatus status) {
        // generate id with random string
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.duration = duration;
        this.listRoom = listRoom;
        this.note = note;
        this.status = status;
        this.user = user;
    }

    public boolean setStatus(ReservationStatus status) {
        try {
            this.status = status;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User getUser() {
        return this.user;
    }
    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public String getNote() {
        return note;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}
