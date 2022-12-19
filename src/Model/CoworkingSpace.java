package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CoworkingSpace {
    private String id;
    private String name;
    private String category;
    private String address;
    private ArrayList<Room> listRoom;
    private HashMap<User, Review> userReview;
    private HashMap<User, Reservation> userReservation;

    public List<Room> getListRoom() {
        return this.listRoom;
    }

    public List<Room> getAvailableRoom() {

    }

    public boolean addRoom(Room newRoom) {
        return listRoom.add(newRoom);
    }

    public boolean makeReservation(Room room, Date date, int duration) {

    }

    public boolean makeReview(Reservation reservation, int score, String description) {

    }

    public boolean checkSpaceAvailability(Room room) {

    }

    public float calculateRating() {

    }

    public HashMap<User, Reservation> getUserReservation() {
        return this.userReservation;
    }

    public List<Reservation> getReservationByUser() {
        return this.userReservation;
    }



}
