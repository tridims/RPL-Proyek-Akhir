package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private String facility;
    private ArrayList<Reservation> listReservation;

    public Room(String name, String description, String facility, ArrayList<Reservation> listReservation) {
        this.name = name;
        this.description = description;
        this.facility = facility;
        this.listReservation = listReservation;
    }

    public boolean updateData(String name, String description, String facility) {
        try {
            this.name = name;
            this.description = description;
            this.facility = facility;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isAvailable(Date date, int duration) {
        // check if room is available
        for (Reservation reservation : listReservation) {
            if (reservation.getDate().equals(date) && reservation.getDuration() == duration) {
                return false;
            }
        }
        return true;
    }

    public List<Reservation> getListReservation() {
        return this.listReservation;
    }

    public boolean addReservation(Reservation newReservation) {
        return listReservation.add(newReservation);
    }
}
