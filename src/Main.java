import Model.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User(new Bookmark(new ArrayList<>()));
        Owner owner = new Owner(new ArrayList<>());
        Catalog catalog = new Catalog(new ArrayList<>());

        // =========== USE CASE PENDATAAN COWORKING SPACE ===========
        CoworkingSpace cospace = new CoworkingSpace("cospace 1", "Outdoor, Indoor", "Jl Veteran, Malang", new ArrayList<>(), new HashMap<>(), new ArrayList<>());
        owner.registerCoworkingSpace(cospace);
        catalog.insertCoworkingSpace(cospace);

        Room room1 = new Room("Mewah SS", "Mewah banget", "Kamar mandi, Wifi, AC, Proyektor", new ArrayList<>());
        Room room2 = new Room("Mewah S", "Mewah aja", "Kamar mandi, Wifi, AC, Proyektor", new ArrayList<>());

        cospace.addRoom(room1);
        cospace.addRoom(room2);

        // =========== USE CASE PENCARIAN ===========
        List<CoworkingSpace> hasilSearch = catalog.searchCoworkingSpace("cospace 1");
        for (CoworkingSpace c : hasilSearch) {
            System.out.println(c.getName());
        }

        List<CoworkingSpace> hasilRekomendasi = catalog.makeRecommendations(user);
        for (CoworkingSpace c : hasilRekomendasi) {
            System.out.println(c.getName());
        }

        // =========== USE CASE BOOKMARK ===========
        List<CoworkingSpace> daftar = catalog.getListCoworkingSpace();
        CoworkingSpace selected = daftar.get(0);

        user.addToBookmark(selected);
        List<CoworkingSpace> daftarBookmark = user.getListBookmarked();
        for (CoworkingSpace c : daftarBookmark) {
            System.out.println(c.getName());
        }

        user.removeFromBookmark(selected);
        daftarBookmark = user.getListBookmarked();
        for (CoworkingSpace c : daftarBookmark) {
            System.out.println(c.getName());
        }

        // =========== USE CASE RESERVASI TEMPAT ===========

        // user membuat reservasi
        CoworkingSpace selectedCoworkingSpace = catalog.getListCoworkingSpace().get(0);
        Room selectedRoom = selectedCoworkingSpace.getListRoom().get(0);
        selectedCoworkingSpace.makeReservation(user, selectedRoom, new Date(), 5, "Reservasi untuk 10 Orang ya");

        // owner melihat permintaan reservasi dan menerima permintaan reservasi
        List<Reservation> daftarReservasi = selectedCoworkingSpace.getListReservation();
        for (Reservation reservation: daftarReservasi) {
            System.out.println(reservation.getUser().getName());
            System.out.println(reservation.getDuration());
            System.out.println(reservation.getNote());
            System.out.println(reservation.getStatus());
        }
        Reservation selectedReservation = daftarReservasi.get(0);
        selectedReservation.setStatus(ReservationStatus.ACCEPTED);

        // =========== USE CASE REVIEW ===========
        user.makeReview(selectedCoworkingSpace, 5, "Bagus banget");
        List<Review> daftarReview = selectedCoworkingSpace.getListUserReviews();
        for (Review review: daftarReview) {
            System.out.println(review.getScore());
            System.out.println(review.getReview());
        }
    }
}