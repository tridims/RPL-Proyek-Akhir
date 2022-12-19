package Model;

import java.sql.Array;
import java.util.*;

public class CoworkingSpace {
    private String id;
    private String name;
    private String category;
    private String address;
    private ArrayList<Room> listRoom;
    private HashMap<User, Review> userReviews;
    private ArrayList<Reservation> listReservation;

    public CoworkingSpace(String name, String category, String address, ArrayList<Room> listRoom, HashMap<User, Review> userReviews, ArrayList<Reservation> listReservation) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.address = address;
        this.listRoom = listRoom;
        this.userReviews = userReviews;
        this.listReservation = listReservation;
    }

    public List<Room> getListRoom() {
        return this.listRoom;
    }

    public List<Room> getAvailableRoom(Date date, int duration) {
        List<Room> availableRoom = new ArrayList<>();
        for (Room room : listRoom) {
            if (room.isAvailable(date, duration)) {
                availableRoom.add(room);
            }
        }
        return availableRoom;
    }

    public boolean addRoom(Room newRoom) {
        return listRoom.add(newRoom);
    }

    public boolean makeReservation(User user, ArrayList<Room> rooms, Date date, int duration, String note) {
        try {
            Reservation reservasi = new Reservation(user, date, duration, rooms, note, ReservationStatus.PENDING);

            // check if there are the same reservation with the same date
            for (Reservation reservation : listReservation) {
                if (reservation.getDate().equals(date) && reservation.getDuration() == duration) {
                    return false;
                }
            }

            for (Room room : rooms) {
                room.addReservation(reservasi);
            }
            
            listReservation.add(reservasi);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean makeReservation(User user, Room room, Date date, int duration, String note) {
        try {
            ArrayList<Room> daftarRoom = new ArrayList<>();
            daftarRoom.add(room);

            Reservation reservasi = new Reservation(user, date, duration, daftarRoom, note, ReservationStatus.PENDING);

            // check if there are the same reservation with the same date
            for (Reservation reservation : listReservation) {
                if (reservation.getDate().equals(date) && reservation.getDuration() == duration) {
                    return false;
                }
            }

            room.addReservation(reservasi);
            listReservation.add(reservasi);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean makeReview(User user, int score, String description) {
        // check if user have reservation
        for (Reservation reservation : listReservation) {
            if (reservation.getUser().equals(user)) {
                Review review = Review.createReview(score, description, new Date(), reservation.getDuration());
                userReviews.put(user, review);
                return true;
            }
        }
        return false;
    }

    public boolean checkSpaceAvailability(Room room, Date date, int duration) {
        return room.isAvailable(date, duration);
    }

    public float calculateRating() {
        float totalScore = 0;
        for (Review review : userReviews.values()) {
            totalScore += review.getScore();
        }
        return totalScore / userReviews.size();

    }

    public List<Reservation> getListReservation() {
        return this.listReservation;
    }

    public List<Reservation> getListReservationByStatus(ReservationStatus status) {
        List<Reservation> reservationByStatus = new ArrayList<>();
        for (Reservation reservation : listReservation) {
            if (reservation.getStatus().equals(status)) {
                reservationByStatus.add(reservation);
            }
        }
        return reservationByStatus;
    }

    public List<Reservation> getReservationByUser(User user) {
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : listReservation) {
            if (reservation.getUser().equals(user)) {
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    // Setter and getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Review> getListUserReviews() {
        return new ArrayList<>(userReviews.values());
    }

    public HashMap<User, Review> getUserReviews() {
        return userReviews;
    }
}
