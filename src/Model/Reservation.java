package Model;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private String id;
    private Date date;
    private int duration;
    private CoworkingSpace coworkingSpace;
    private ArrayList<Room> listRoom;
    private String note;
    private ReservationStatus status;

    public boolean setStatus(ReservationStatus status) {
        try {
            this.status = status;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
